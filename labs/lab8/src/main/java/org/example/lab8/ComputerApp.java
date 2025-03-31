package org.example.lab8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Подсистема: Процессор
class CPU {
    private boolean isRussian;
    public CPU(boolean isRussian) { this.isRussian = isRussian; }
    public String start() { return isRussian ? "Процессор запущен\n" : "CPU started\n"; }
    public String shutdown() { return isRussian ? "Процессор выключен\n" : "CPU shutdown\n"; }
    public String overclock() { return isRussian ? "Процессор разогнан до 4.5 ГГц\n" : "CPU overclocked to 4.5 GHz\n"; }
    public void setRussian(boolean isRussian) { this.isRussian = isRussian; }
}

// Подсистема: Память
class Memory {
    private boolean isRussian;
    public Memory(boolean isRussian) { this.isRussian = isRussian; }
    public String load() { return isRussian ? "Память загружена\n" : "Memory loaded\n"; }
    public String clear() { return isRussian ? "Память очищена\n" : "Memory cleared\n"; }
    public String allocate(int mb) { return isRussian ? "Выделено " + mb + " МБ ОЗУ\n" : "Allocated " + mb + " MB of RAM\n"; }
    public void setRussian(boolean isRussian) { this.isRussian = isRussian; }
}

// Подсистема: Жесткий диск
class HardDrive {
    private boolean isRussian;
    public HardDrive(boolean isRussian) { this.isRussian = isRussian; }
    public String readData() { return isRussian ? "Чтение данных с жесткого диска\n" : "Reading data from Hard Drive\n"; }
    public String stop() { return isRussian ? "Жесткий диск остановлен\n" : "Hard Drive stopped\n"; }
    public String writeData(String data) { return isRussian ? "Запись '" + data + "' на жесткий диск\n" : "Writing '" + data + "' to Hard Drive\n"; }
    public void setRussian(boolean isRussian) { this.isRussian = isRussian; }
}

// Подсистема: Операционная система
class OperatingSystem {
    private boolean isRussian;
    public OperatingSystem(boolean isRussian) { this.isRussian = isRussian; }
    public String boot() { return isRussian ? "ОС загружается...\n" : "OS booting...\n"; }
    public String shutdown() { return isRussian ? "ОС выключается...\n" : "OS shutting down...\n"; }
    public String update() { return isRussian ? "Установка обновлений ОС\n" : "Installing OS updates\n"; }
    public void setRussian(boolean isRussian) { this.isRussian = isRussian; }
}

// Подсистема: Видеокарта
class GraphicsCard {
    private boolean isRussian;
    public GraphicsCard(boolean isRussian) { this.isRussian = isRussian; }
    public String enable() { return isRussian ? "Видеокарта включена\n" : "Graphics Card enabled\n"; }
    public String disable() { return isRussian ? "Видеокарта выключена\n" : "Graphics Card disabled\n"; }
    public String render(String content) { return isRussian ? "Рендеринг " + content + "\n" : "Rendering " + content + "\n"; }
    public void setRussian(boolean isRussian) { this.isRussian = isRussian; }
}

// Фасад: Компьютер
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    private OperatingSystem os;
    private GraphicsCard gpu;
    private boolean isRussian;

    public ComputerFacade(boolean isRussian) {
        this.isRussian = isRussian;
        this.cpu = new CPU(isRussian);
        this.memory = new Memory(isRussian);
        this.hardDrive = new HardDrive(isRussian);
        this.os = new OperatingSystem(isRussian);
        this.gpu = new GraphicsCard(isRussian);
    }

    public void setRussian(boolean isRussian) {
        this.isRussian = isRussian;
        cpu.setRussian(isRussian);
        memory.setRussian(isRussian);
        hardDrive.setRussian(isRussian);
        os.setRussian(isRussian);
        gpu.setRussian(isRussian);
    }

    public String start() {
        StringBuilder output = new StringBuilder(isRussian ? "Запуск компьютера...\n" : "Starting computer...\n");
        output.append(cpu.start());
        output.append(memory.load());
        output.append(hardDrive.readData());
        output.append(gpu.enable());
        output.append(os.boot());
        output.append(isRussian ? "Компьютер успешно запущен\n" : "Computer started successfully\n");
        return output.toString();
    }

    public String shutdown() {
        StringBuilder output = new StringBuilder(isRussian ? "Выключение компьютера...\n" : "Shutting down computer...\n");
        output.append(os.shutdown());
        output.append(gpu.disable());
        output.append(hardDrive.stop());
        output.append(memory.clear());
        output.append(cpu.shutdown());
        output.append(isRussian ? "Компьютер успешно выключен\n" : "Computer shutdown completed\n");
        return output.toString();
    }

    public String runProgram(String programName) {
        StringBuilder output = new StringBuilder(isRussian ? "Запуск программы: " : "Running program: " + programName + "\n");
        output.append(memory.allocate(512));
        output.append(cpu.start());
        output.append(gpu.render(programName));
        output.append(isRussian ? programName + " запущена\n" : programName + " is running\n");
        return output.toString();
    }

    public String overclockCPU() {
        StringBuilder output = new StringBuilder(isRussian ? "Разгон процессора...\n" : "Overclocking CPU...\n");
        output.append(cpu.overclock());
        output.append(isRussian ? "Производительность процессора увеличена\n" : "CPU performance boosted\n");
        return output.toString();
    }

    public String saveFile(String filename) {
        StringBuilder output = new StringBuilder(isRussian ? "Сохранение файла...\n" : "Saving file...\n");
        output.append(hardDrive.writeData(filename));
        output.append(isRussian ? "Файл '" + filename + "' сохранён\n" : "File '" + filename + "' saved\n");
        return output.toString();
    }

    public String updateOS() {
        StringBuilder output = new StringBuilder(isRussian ? "Обновление ОС...\n" : "Updating OS...\n");
        output.append(os.update());
        output.append(isRussian ? "ОС успешно обновлена\n" : "OS updated successfully\n");
        return output.toString();
    }

    public String renderGraphics(String content) {
        StringBuilder output = new StringBuilder(isRussian ? "Рендеринг графики...\n" : "Rendering graphics...\n");
        output.append(gpu.render(content));
        output.append(isRussian ? "Графика отрендерена\n" : "Graphics rendered\n");
        return output.toString();
    }

    public String allocateMemory(int mb) {
        StringBuilder output = new StringBuilder(isRussian ? "Выделение памяти...\n" : "Allocating memory...\n");
        output.append(memory.allocate(mb));
        output.append(isRussian ? "Выделение памяти завершено\n" : "Memory allocation completed\n");
        return output.toString();
    }

    public String readFile(String filename) {
        StringBuilder output = new StringBuilder(isRussian ? "Чтение файла...\n" : "Reading file...\n");
        output.append(hardDrive.readData());
        output.append(isRussian ? "Файл '" + filename + "' прочитан\n" : "File '" + filename + "' read\n");
        return output.toString();
    }

    public String restart() {
        StringBuilder output = new StringBuilder(isRussian ? "Перезапуск компьютера...\n" : "Restarting computer...\n");
        output.append(shutdown());
        output.append("----------------\n");
        output.append(start());
        return output.toString();
    }
}

// Главный класс с JavaFX интерфейсом
public class ComputerApp extends Application {
    private ComputerFacade computer = new ComputerFacade(false); // По умолчанию английский
    private TextArea outputArea;
    private boolean isRussian = false;

    // Кнопки
    private Button startButton, shutdownButton, runProgramButton, overclockButton,
            saveFileButton, updateOSButton, renderGraphicsButton,
            allocateMemoryButton, readFileButton, restartButton, languageButton;

    @Override
    public void start(Stage primaryStage) {
        // Инициализация кнопок
        startButton = new Button("Start Computer");
        shutdownButton = new Button("Shutdown Computer");
        runProgramButton = new Button("Run Program");
        overclockButton = new Button("Overclock CPU");
        saveFileButton = new Button("Save File");
        updateOSButton = new Button("Update OS");
        renderGraphicsButton = new Button("Render Graphics");
        allocateMemoryButton = new Button("Allocate Memory");
        readFileButton = new Button("Read File");
        restartButton = new Button("Restart Computer");
        languageButton = new Button("Switch to Russian");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(300);

        // Обработчики событий
        startButton.setOnAction(e -> outputArea.appendText(computer.start() + "----------------\n"));
        shutdownButton.setOnAction(e -> outputArea.appendText(computer.shutdown() + "----------------\n"));
        runProgramButton.setOnAction(e -> outputArea.appendText(computer.runProgram("TextEditor") + "----------------\n"));
        overclockButton.setOnAction(e -> outputArea.appendText(computer.overclockCPU() + "----------------\n"));
        saveFileButton.setOnAction(e -> outputArea.appendText(computer.saveFile("document.txt") + "----------------\n"));
        updateOSButton.setOnAction(e -> outputArea.appendText(computer.updateOS() + "----------------\n"));
        renderGraphicsButton.setOnAction(e -> outputArea.appendText(computer.renderGraphics("3D Model") + "----------------\n"));
        allocateMemoryButton.setOnAction(e -> outputArea.appendText(computer.allocateMemory(1024) + "----------------\n"));
        readFileButton.setOnAction(e -> outputArea.appendText(computer.readFile("document.txt") + "----------------\n"));
        restartButton.setOnAction(e -> outputArea.appendText(computer.restart() + "----------------\n"));

        // Переключение языка
        languageButton.setOnAction(e -> {
            isRussian = !isRussian;
            computer.setRussian(isRussian);
            updateLanguage();
        });

        // Компактная сетка для кнопок
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);
        buttonGrid.setPadding(new Insets(10));
        buttonGrid.setAlignment(Pos.CENTER);

        // Расположение кнопок в сетке (3 столбца)
        buttonGrid.add(startButton, 0, 0);
        buttonGrid.add(shutdownButton, 1, 0);
        buttonGrid.add(runProgramButton, 2, 0);
        buttonGrid.add(overclockButton, 0, 1);
        buttonGrid.add(saveFileButton, 1, 1);
        buttonGrid.add(updateOSButton, 2, 1);
        buttonGrid.add(renderGraphicsButton, 0, 2);
        buttonGrid.add(allocateMemoryButton, 1, 2);
        buttonGrid.add(readFileButton, 2, 2);
        buttonGrid.add(restartButton, 0, 3);
        buttonGrid.add(languageButton, 1, 3);

        // Основная компоновка
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(buttonGrid, outputArea);

        Scene scene = new Scene(layout, 450, 450);
        primaryStage.setTitle("Dashkevich Anton lab8");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Обновление текста кнопок при смене языка
    private void updateLanguage() {
        if (isRussian) {
            startButton.setText("Запустить компьютер");
            shutdownButton.setText("Выключить компьютер");
            runProgramButton.setText("Запустить программу");
            overclockButton.setText("Разогнать процессор");
            saveFileButton.setText("Сохранить файл");
            updateOSButton.setText("Обновить ОС");
            renderGraphicsButton.setText("Рендерить графику");
            allocateMemoryButton.setText("Выделить память");
            readFileButton.setText("Прочитать файл");
            restartButton.setText("Перезапустить компьютер");
            languageButton.setText("Switch to English");
        } else {
            startButton.setText("Start Computer");
            shutdownButton.setText("Shutdown Computer");
            runProgramButton.setText("Run Program");
            overclockButton.setText("Overclock CPU");
            saveFileButton.setText("Save File");
            updateOSButton.setText("Update OS");
            renderGraphicsButton.setText("Render Graphics");
            allocateMemoryButton.setText("Allocate Memory");
            readFileButton.setText("Read File");
            restartButton.setText("Restart COMPUTER");
            languageButton.setText("Switch to Russian");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
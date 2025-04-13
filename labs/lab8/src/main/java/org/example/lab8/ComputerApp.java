package org.example.lab8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Locale;
import java.util.ResourceBundle;

public class ComputerApp extends Application {
    private ComputerFacade computer;
    private TextArea outputArea;
    private ResourceBundle messages;
    private String[] languageCodes = {"en", "ru", "fr", "de", "es"};
    private String[] languageNames = {"English", "Русский", "Français", "Deutsch", "Español"};

    // Кнопки и ComboBox
    private Button startButton, shutdownButton, runProgramButton, overclockButton,
            saveFileButton, updateOSButton, renderGraphicsButton,
            allocateMemoryButton, readFileButton, restartButton;
    private ComboBox<String> languageSelector;

    @Override
    public void start(Stage primaryStage) {
        // Инициализация с английским языком по умолчанию
        messages = ResourceBundle.getBundle("languages.Messages", new Locale(languageCodes[0]));
        computer = new ComputerFacade(messages);

        // Инициализация кнопок
        startButton = new Button(messages.getString("startComputer"));
        shutdownButton = new Button(messages.getString("shutdownComputer"));
        runProgramButton = new Button(messages.getString("runProgram"));
        overclockButton = new Button(messages.getString("overclockCPU"));
        saveFileButton = new Button(messages.getString("saveFile"));
        updateOSButton = new Button(messages.getString("updateOS"));
        renderGraphicsButton = new Button(messages.getString("renderGraphics"));
        allocateMemoryButton = new Button(messages.getString("allocateMemory"));
        readFileButton = new Button(messages.getString("readFile"));
        restartButton = new Button(messages.getString("restartComputer"));

        // Инициализация ComboBox для выбора языка
        languageSelector = new ComboBox<>();
        languageSelector.getItems().addAll(languageNames);
        languageSelector.setValue(languageNames[0]); // По умолчанию English
        languageSelector.setPromptText(messages.getString("selectLanguage"));

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

        // Обработчик смены языка
        languageSelector.setOnAction(e -> {
            int index = languageSelector.getSelectionModel().getSelectedIndex();
            messages = ResourceBundle.getBundle("languages.Messages", new Locale(languageCodes[index]));
            computer.setMessages(messages);
            updateLanguage();
        });

        // Компактная сетка для кнопок
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);
        buttonGrid.setPadding(new Insets(10));
        buttonGrid.setAlignment(Pos.CENTER);
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

        // Отдельная область для выбора языка
        VBox languageBox = new VBox(10);
        languageBox.setAlignment(Pos.CENTER);
        languageBox.getChildren().add(languageSelector);

        // Основная компоновка
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(buttonGrid, languageBox, outputArea);

        Scene scene = new Scene(layout, 450, 450);
        primaryStage.setTitle("Computer Facade Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Обновление текста кнопок при смене языка
    private void updateLanguage() {
        startButton.setText(messages.getString("startComputer"));
        shutdownButton.setText(messages.getString("shutdownComputer"));
        runProgramButton.setText(messages.getString("runProgram"));
        overclockButton.setText(messages.getString("overclockCPU"));
        saveFileButton.setText(messages.getString("saveFile"));
        updateOSButton.setText(messages.getString("updateOS"));
        renderGraphicsButton.setText(messages.getString("renderGraphics"));
        allocateMemoryButton.setText(messages.getString("allocateMemory"));
        readFileButton.setText(messages.getString("readFile"));
        restartButton.setText(messages.getString("restartComputer"));
        languageSelector.setPromptText(messages.getString("selectLanguage"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

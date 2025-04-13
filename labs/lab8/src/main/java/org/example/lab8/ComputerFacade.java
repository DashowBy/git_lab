package org.example.lab8;

import java.util.ResourceBundle;

public class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    private OperatingSystem os;
    private GraphicsCard gpu;
    private ResourceBundle messages;

    public ComputerFacade(ResourceBundle messages) {
        this.messages = messages;
        this.cpu = new CPU(messages);
        this.memory = new Memory(messages);
        this.hardDrive = new HardDrive(messages);
        this.os = new OperatingSystem(messages);
        this.gpu = new GraphicsCard(messages);
    }

    public void setMessages(ResourceBundle messages) {
        this.messages = messages;
        cpu.setMessages(messages);
        memory.setMessages(messages);
        hardDrive.setMessages(messages);
        os.setMessages(messages);
        gpu.setMessages(messages);
    }

    public String start() {
        StringBuilder output = new StringBuilder(messages.getString("starting") + "\n");
        output.append(cpu.start());
        output.append(memory.load());
        output.append(hardDrive.readData());
        output.append(gpu.enable());
        output.append(os.boot());
        output.append(messages.getString("computerStarted") + "\n");
        return output.toString();
    }

    public String shutdown() {
        StringBuilder output = new StringBuilder(messages.getString("shuttingDown") + "\n");
        output.append(os.shutdown());
        output.append(gpu.disable());
        output.append(hardDrive.stop());
        output.append(memory.clear());
        output.append(cpu.shutdown());
        output.append(messages.getString("computerShutdown") + "\n");
        return output.toString();
    }

    public String runProgram(String programName) {
        StringBuilder output = new StringBuilder(messages.getString("runningProgram") + programName + "\n");
        output.append(memory.allocate(512));
        output.append(cpu.start());
        output.append(gpu.render(programName));
        output.append(programName + messages.getString("programRunning") + "\n");
        return output.toString();
    }

    public String overclockCPU() {
        StringBuilder output = new StringBuilder(messages.getString("overclocking") + "\n");
        output.append(cpu.overclock());
        output.append(messages.getString("cpuBoosted") + "\n");
        return output.toString();
    }

    public String saveFile(String filename) {
        StringBuilder output = new StringBuilder(messages.getString("savingFile") + "\n");
        output.append(hardDrive.writeData(filename));
        output.append(String.format(messages.getString("fileSaved") + "\n", filename));
        return output.toString();
    }

    public String updateOS() {
        StringBuilder output = new StringBuilder(messages.getString("updatingOS") + "\n");
        output.append(os.update());
        output.append(messages.getString("osUpdated") + "\n");
        return output.toString();
    }

    public String renderGraphics(String content) {
        StringBuilder output = new StringBuilder(messages.getString("renderingGraphics") + "\n");
        output.append(gpu.render(content));
        output.append(messages.getString("graphicsRendered") + "\n");
        return output.toString();
    }

    public String allocateMemory(int mb) {
        StringBuilder output = new StringBuilder(messages.getString("allocatingMemory") + "\n");
        output.append(memory.allocate(mb));
        output.append(messages.getString("memoryAllocated") + "\n");
        return output.toString();
    }

    public String readFile(String filename) {
        StringBuilder output = new StringBuilder(messages.getString("readingFile") + "\n");
        output.append(hardDrive.readData());
        output.append(String.format(messages.getString("fileRead") + "\n", filename));
        return output.toString();
    }

    public String restart() {
        StringBuilder output = new StringBuilder(messages.getString("restarting") + "\n");
        output.append(shutdown());
        output.append("----------------\n");
        output.append(start());
        return output.toString();
    }
}

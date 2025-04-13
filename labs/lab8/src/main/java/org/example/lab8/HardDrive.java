package org.example.lab8;

import java.util.ResourceBundle;

public class HardDrive {
    private ResourceBundle messages;
    public HardDrive(ResourceBundle messages) { this.messages = messages; }
    public String readData() { return messages.getString("hdReading") + "\n"; }
    public String stop() { return messages.getString("hdStopped") + "\n"; }
    public String writeData(String data) {
        return String.format(messages.getString("hdWriting") + "\n", data);
    }
    public void setMessages(ResourceBundle messages) { this.messages = messages; }
}

package org.example.lab8;

import java.util.ResourceBundle;

public class CPU {
    private ResourceBundle messages;
    public CPU(ResourceBundle messages) { this.messages = messages; }
    public String start() { return messages.getString("cpuStarted") + "\n"; }
    public String shutdown() { return messages.getString("cpuShutdown") + "\n"; }
    public String overclock() { return messages.getString("cpuOverclocked") + "\n"; }
    public void setMessages(ResourceBundle messages) { this.messages = messages; }
}

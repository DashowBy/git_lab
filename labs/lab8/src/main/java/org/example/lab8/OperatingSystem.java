package org.example.lab8;

import java.util.ResourceBundle;

public class OperatingSystem {
    private ResourceBundle messages;
    public OperatingSystem(ResourceBundle messages) { this.messages = messages; }
    public String boot() { return messages.getString("osBooting") + "\n"; }
    public String shutdown() { return messages.getString("osShuttingDown") + "\n"; }
    public String update() { return messages.getString("osUpdating") + "\n"; }
    public void setMessages(ResourceBundle messages) { this.messages = messages; }
}

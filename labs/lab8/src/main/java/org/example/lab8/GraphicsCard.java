package org.example.lab8;

import java.util.ResourceBundle;

public class GraphicsCard {
    private ResourceBundle messages;
    public GraphicsCard(ResourceBundle messages) { this.messages = messages; }
    public String enable() { return messages.getString("gpuEnabled") + "\n"; }
    public String disable() { return messages.getString("gpuDisabled") + "\n"; }
    public String render(String content) {
        return String.format(messages.getString("gpuRendering") + "\n", content);
    }
    public void setMessages(ResourceBundle messages) { this.messages = messages; }
}

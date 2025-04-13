package org.example.lab8;

import java.util.ResourceBundle;

public class Memory {
    private ResourceBundle messages;
    public Memory(ResourceBundle messages) { this.messages = messages; }
    public String load() { return messages.getString("memoryLoaded") + "\n"; }
    public String clear() { return messages.getString("memoryCleared") + "\n"; }
    public String allocate(int mb) {
        return String.format(messages.getString("memoryAllocatedMb") + "\n", mb);
    }
    public void setMessages(ResourceBundle messages) { this.messages = messages; }
}

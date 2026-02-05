package com.example.todo;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;

public class TodoService {

    // Intentional: raw type warning (should be List<TodoItem>)
    private List items = new ArrayList();

    // Intentional: unused field
    private String serviceName = "TodoService";

    // Intentional: non-static field that could be static
    private final String VERSION = "1.0.0";

    public void addItem(String title, String description, int priority) {
        TodoItem item = new TodoItem(title, description);
        // Intentional: unchecked call warning
        items.add(item);

        // Intentional: unused local variable
        int itemCount = items.size();
    }

    // Intentional: parameter 'soft' is unused
    public boolean removeItem(int index, boolean soft) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public void completeItem(int index) {
        if (index >= 0 && index < items.size()) {
            // Intentional: unchecked cast
            TodoItem item = (TodoItem) items.get(index);
            item.markComplete();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TodoItem> getAllItems() {
        // Intentional: returning raw type as generic
        return items;
    }

    // Intentional: parameter 'returnCopy' is unused
    public TodoItem getItem(int index, boolean returnCopy) {
        if (index >= 0 && index < items.size()) {
            return (TodoItem) items.get(index);
        }
        return null;
    }

    // Intentional: parameter 'keepCompleted' is unused
    public void clearAll(boolean keepCompleted) {
        items.clear();
        // Intentional: unreachable code
        return;
        // items = new ArrayList();
    }

    // Intentional: resource leak - stream not closed properly
    public String loadFromFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            byte[] data = new byte[1024];
            fis.read(data);
            return new String(data);
        } catch (IOException e) {
            // Intentional: empty catch block
        }
        return null;
    }

    // Intentional: synchronization on non-final field
    public void syncOperation() {
        synchronized (items) {
            // do something
        }
    }

    // Intentional: comparing strings with ==
    public boolean hasItem(String title) {
        for (Object item : items) {
            TodoItem todo = (TodoItem) item;
            if (todo.getTitle() == title) {
                return true;
            }
        }
        return false;
    }
}

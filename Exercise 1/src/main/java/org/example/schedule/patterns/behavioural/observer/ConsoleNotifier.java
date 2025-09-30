package org.example.ei.patterns.observer;

public class ConsoleNotifier implements Observer {
   
    public void update(String message) {
        System.out.println("[NOTIFICATION] " + message);
    }
}

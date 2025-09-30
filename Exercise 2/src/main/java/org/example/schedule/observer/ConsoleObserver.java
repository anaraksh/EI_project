package org.example.schedule.observer;

public class ConsoleObserver implements Observer {
    
    public void notify(String message) {
        System.out.println("[ALERT] " + message);
    }
}

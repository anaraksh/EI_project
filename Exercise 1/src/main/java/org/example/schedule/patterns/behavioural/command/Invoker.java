package org.example.ei.patterns.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class Invoker {
    private final Deque<Command> history = new ArrayDeque<>();

    public void run(Command c) throws Exception {
        c.execute();
        history.push(c);
    }

    
}

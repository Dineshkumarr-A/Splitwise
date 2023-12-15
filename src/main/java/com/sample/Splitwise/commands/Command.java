package com.sample.Splitwise.commands;

public interface Command {
    void execute(String input);
    boolean matches(String input);
}

package com.decathlon.hexagonaldemoapp.core.commands;

public interface CommandHandler<C extends Command, R> {
    R handle(C c);
}

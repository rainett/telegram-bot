package com.example.telegrambot.telegram.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Executable
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    String name();
    String description() default "ㅤ";
    boolean hideFromMenu() default false;
}

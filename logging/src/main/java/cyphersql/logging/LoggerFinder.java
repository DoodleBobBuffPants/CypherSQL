package cyphersql.logging;

import java.lang.System.Logger;
import java.util.HashMap;
import java.util.Map;

public class LoggerFinder extends System.LoggerFinder {
    private static final Map<String, Logger> LOGGERS = new HashMap<>();

    @Override
    public Logger getLogger(String name, Module module) {
        return LOGGERS.computeIfAbsent(name, ConsoleLogger::new);
    }
}

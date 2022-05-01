package cyphersql.logging;

import java.lang.System.Logger;
import java.util.ResourceBundle;

import static java.text.MessageFormat.format;

public class ConsoleLogger implements Logger {
    private final String name;

    public ConsoleLogger(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isLoggable(Level level) {
        return true;
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
        if (!isLoggable(level)) {
            return;
        }
        switch (level) {
            case ERROR:
                System.err.println(msg);
                thrown.printStackTrace();
                break;
            case OFF:
                break;
            default:
                System.out.println(msg);
        }
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {
        log(level, bundle, format(format, params), (Throwable) null);
    }
}

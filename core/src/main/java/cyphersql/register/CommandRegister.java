package cyphersql.register;

import cyphersql.api.Command;
import cyphersql.api.exception.NoCommandFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class CommandRegister {
    private static List<Command<?>> commands = null;

    public static Command<?> get(String command) {
        return get().stream().filter(c -> c.handlesCommand(command)).findFirst().orElseThrow(() -> new NoCommandFoundException(command));
    }

    public static List<Command<?>> get() {
        if (commands == null) register();
        return commands;
    }

    private synchronized static void register() {
        commands = new ArrayList<>();
        ServiceLoader.load(Command.class).forEach(t -> commands.add(t));
    }
}

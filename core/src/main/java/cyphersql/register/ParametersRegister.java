package cyphersql.register;

import cyphersql.api.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class ParametersRegister {
    private static List<Parameters> parameters = null;

    public static List<Parameters> getParameters() {
        if (parameters == null) {
            register();
        }
        return parameters;
    }

    private synchronized static void register() {
        parameters = new ArrayList<>();
        ServiceLoader.load(Parameters.class).forEach(t -> parameters.add(t));
    }
}

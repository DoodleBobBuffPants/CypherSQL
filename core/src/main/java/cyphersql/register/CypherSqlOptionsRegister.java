package cyphersql.register;

import cyphersql.api.CypherSqlOptions;
import cyphersql.api.exception.NoServiceFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class CypherSqlOptionsRegister {
    private static List<CypherSqlOptions> options = null;

    @SuppressWarnings("unchecked")
    public static <T extends CypherSqlOptions> T get(Class<T> clazz) {
        return (T) get().stream().filter(o -> o.getClass().getCanonicalName().equals(clazz.getCanonicalName())).findFirst().orElseThrow(() -> new NoServiceFoundException(clazz));
    }

    public static List<CypherSqlOptions> get() {
        if (options == null) register();
        return options;
    }

    private synchronized static void register() {
        options = new ArrayList<>();
        ServiceLoader.load(CypherSqlOptions.class).forEach(t -> options.add(t));
    }
}

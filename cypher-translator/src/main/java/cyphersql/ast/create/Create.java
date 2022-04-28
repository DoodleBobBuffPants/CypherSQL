package cyphersql.ast.create;

import java.util.HashMap;
import java.util.Map;

public abstract class Create {
    public final Map<String, String> fields = new HashMap<>();
}

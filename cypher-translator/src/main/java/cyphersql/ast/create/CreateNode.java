package cyphersql.ast.create;

import java.util.ArrayList;
import java.util.List;

public class CreateNode extends Create {
    public final List<String> labels = new ArrayList<>();
    public int id;
}

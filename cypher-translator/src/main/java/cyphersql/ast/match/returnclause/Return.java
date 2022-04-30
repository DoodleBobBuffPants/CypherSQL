package cyphersql.ast.match.returnclause;

import java.util.ArrayList;
import java.util.List;

public class Return {
    public List<ReturnItem> returnItems = new ArrayList<>();
    public boolean isDistinct;
}

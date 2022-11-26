package cyphersql.listener;

import java.util.List;

public interface ListenerVisitor {
    List<String> visit(CypherCreateListener listener);
    List<String> visit(CypherMatchListener listener);
}

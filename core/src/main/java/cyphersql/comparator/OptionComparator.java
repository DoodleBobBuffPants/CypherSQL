package cyphersql.comparator;

import org.apache.commons.cli.Option;

import java.util.Comparator;

public class OptionComparator implements Comparator<Option> {
    @Override
    public int compare(Option o1, Option o2) {
        int i = Boolean.compare(o1.hasArg(), o2.hasArg());
        if (i == 0) return o1.getOpt().compareTo(o2.getOpt());
        return i;
    }
}

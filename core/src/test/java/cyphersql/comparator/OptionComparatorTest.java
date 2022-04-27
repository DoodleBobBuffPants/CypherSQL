package cyphersql.comparator;

import org.apache.commons.cli.Option;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionComparatorTest {
    private final Comparator<Option> comparator = new OptionComparator();

    @Test
    public void sortOptionsWithNoArgsInAlphabeticalOrder() {
        Option option1 = new Option("a", false, "");
        Option option2 = new Option("b", false, "");
        assertEquals(-1, comparator.compare(option1, option2));
        assertEquals(1, comparator.compare(option2, option1));
    }

    @Test
    public void sortOptionsWithArgsInAlphabeticalOrder() {
        Option option1 = new Option("a", true, "");
        Option option2 = new Option("b", true, "");
        assertEquals(-1, comparator.compare(option1, option2));
        assertEquals(1, comparator.compare(option2, option1));
    }

    @Test
    public void sortOptionsWithNoArgsBeforeOptionsWithArgs() {
        Option option1 = new Option("a", false, "");
        Option option2 = new Option("b", true, "");
        assertEquals(-1, comparator.compare(option1, option2));
        assertEquals(1, comparator.compare(option2, option1));
    }
}

package de.dhbw.cleanproject.application.stellenangebot.sorter;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlphabeticSorter<T> {

    Function<T, String> convert;

    public AlphabeticSorter(Function<T, String> toString) {
        this.convert = toString;
    }

    public List<T> sort(List<T> tList) {
        return tList.stream()
                .sorted(Comparator.comparing(s -> this.convert.apply(s)))
                .collect(Collectors.toList());
    }
}

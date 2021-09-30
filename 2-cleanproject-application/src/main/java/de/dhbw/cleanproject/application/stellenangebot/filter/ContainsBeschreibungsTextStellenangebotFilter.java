package de.dhbw.cleanproject.application.stellenangebot.filter;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContainsBeschreibungsTextStellenangebotFilter implements FilterStellenangeboteDomainService {
    private final String needle;

    public ContainsBeschreibungsTextStellenangebotFilter(String needle) {
        this.needle = needle;
    }

    @Override
    public List<Stellenangebot> filter(List<Stellenangebot> allStellenangebote) {
        return allStellenangebote.stream()
                .filter(contains(needle))
                .collect(Collectors.toList());
    }

    private static Predicate<Stellenangebot> contains(String needle) {
        return stellenangebot -> {
            String haystack = stellenangebot.getBeschreibung();
            return haystack.contains(needle);
        };
    }
}

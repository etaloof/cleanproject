package de.dhbw.cleanproject.application.stellenangebot.filter;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;

import java.util.Arrays;
import java.util.List;

public class ListStellenangebotFilter implements FilterStellenangeboteDomainService {
    private final List<FilterStellenangeboteDomainService> filters;

    public ListStellenangebotFilter(List<FilterStellenangeboteDomainService> filters) {
        this.filters = filters;
    }

    public ListStellenangebotFilter(FilterStellenangeboteDomainService... filters) {
        this(Arrays.asList(filters));
    }

    @Override
    public List<Stellenangebot> filter(List<Stellenangebot> allStellenangebote) {
        for (FilterStellenangeboteDomainService filter : filters) {
            allStellenangebote = filter.filter(allStellenangebote);
        }

        return allStellenangebote;
    }
}

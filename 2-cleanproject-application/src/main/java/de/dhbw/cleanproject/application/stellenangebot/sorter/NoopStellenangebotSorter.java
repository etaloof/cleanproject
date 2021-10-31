package de.dhbw.cleanproject.application.stellenangebot.sorter;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;

import java.util.List;

public class NoopStellenangebotSorter implements SorterStellenangeboteDomainService {
    @Override
    public List<Stellenangebot> sort(List<Stellenangebot> allStellenangebote) {
        return allStellenangebote;
    }
}

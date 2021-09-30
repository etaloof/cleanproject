package de.dhbw.cleanproject.application.stellenangebot.filter;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;

import java.util.List;

public class NoopStellenangebotFilter implements FilterStellenangeboteDomainService {
    @Override
    public List<Stellenangebot> filter(List<Stellenangebot> allStellenangebote) {
        return allStellenangebote;
    }
}

package de.dhbw.cleanproject.application.stellenangebot.filter;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;

import java.util.List;

public interface FilterStellenangeboteDomainService {
    List<Stellenangebot> filter(List<Stellenangebot> allStellenangebote);
}

package de.dhbw.cleanproject.application.stellenangebot.sorter;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;

import java.util.List;

public interface SorterStellenangeboteDomainService {
    List<Stellenangebot> sort(List<Stellenangebot> allStellenangebote);
}

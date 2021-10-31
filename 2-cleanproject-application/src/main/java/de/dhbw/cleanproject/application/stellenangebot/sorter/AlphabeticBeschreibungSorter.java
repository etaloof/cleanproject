package de.dhbw.cleanproject.application.stellenangebot.sorter;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;

import java.util.List;

public class AlphabeticBeschreibungSorter implements SorterStellenangeboteDomainService {
    @Override
    public List<Stellenangebot> sort(List<Stellenangebot> allStellenangebote) {
        return new AlphabeticSorter<>(Stellenangebot::getBeschreibung).sort(allStellenangebote);
    }
}

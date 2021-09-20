package de.dhbw.cleanproject.domain.stellenangebot;

import java.util.List;

public interface StellenangebotRepository {

    List<Stellenangebot> findAllStellenangebote();

    Stellenangebot save(Stellenangebot stellenangebot);
}

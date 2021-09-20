package de.dhbw.cleanproject.application.stellenangebot;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
import de.dhbw.cleanproject.domain.stellenangebot.StellenangebotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StellenangebotApplicationService {

    private StellenangebotRepository stellenangebotRepository;

    @Autowired
    public StellenangebotApplicationService(StellenangebotRepository stellenangebotRepository) {
        this.stellenangebotRepository = stellenangebotRepository;
    }

    public List<Stellenangebot> findAllStellenangebote() {
        return this.stellenangebotRepository.findAllStellenangebote();
    }
}

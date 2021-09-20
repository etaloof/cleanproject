package de.dhbw.plugins.persistence.hibernate.stellenangebote;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
import de.dhbw.cleanproject.domain.stellenangebot.StellenangebotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StellenangebotRepositoryBridge implements StellenangebotRepository {

    private SpringDataStellenangebotRepository springDataStellenangebotRepository;

    @Autowired
    public StellenangebotRepositoryBridge(SpringDataStellenangebotRepository springDataStellenangebotRepository) {
        this.springDataStellenangebotRepository = springDataStellenangebotRepository;
    }

    @Override
    public List<Stellenangebot> findAllStellenangebote() {
        return this.springDataStellenangebotRepository.findAll();
    }

    @Override
    public Stellenangebot save(Stellenangebot stellenangebot) {
        return this.springDataStellenangebotRepository.save(stellenangebot);
    }
}

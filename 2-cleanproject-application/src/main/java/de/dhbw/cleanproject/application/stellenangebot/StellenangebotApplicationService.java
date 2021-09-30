package de.dhbw.cleanproject.application.stellenangebot;

import de.dhbw.cleanproject.application.stellenangebot.filter.FilterStellenangeboteDomainService;
import de.dhbw.cleanproject.application.stellenangebot.filter.NoopStellenangebotFilter;
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
        return findAllStellenangebote(new NoopStellenangebotFilter());
    }

    public List<Stellenangebot> findAllStellenangebote(FilterStellenangeboteDomainService filterStellenangeboteDomainService) {
        return filterStellenangeboteDomainService.filter(findAllStellenangeboteUnfiltered());
    }

    private List<Stellenangebot> findAllStellenangeboteUnfiltered() {
        return this.stellenangebotRepository.findAllStellenangebote();
    }
}

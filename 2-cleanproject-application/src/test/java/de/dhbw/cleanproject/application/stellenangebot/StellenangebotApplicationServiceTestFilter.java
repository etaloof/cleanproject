 package de.dhbw.cleanproject.application.stellenangebot;

import de.dhbw.cleanproject.application.stellenangebot.filter.*;
import de.dhbw.cleanproject.domain.gültigkeitszeitraum.Gültigkeitszeitraum;
import de.dhbw.cleanproject.domain.stellenangebot.arbeitszeit.Arbeitszeit;
import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
import de.dhbw.cleanproject.domain.stellenangebot.StellenangebotRepository;
import de.dhbw.cleanproject.domain.unternehmen.Unternehmen;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StellenangebotApplicationServiceTestFilter extends StellenangebotApplicationServiceTest {
    static class MockRespository implements StellenangebotRepository {
        private final List<Stellenangebot> list;

        public MockRespository(List<Stellenangebot> list) {
            this.list = list;
        }

        @Override
        public List<Stellenangebot> findAllStellenangebote() {
            return list;
        }

        @Override
        public Stellenangebot save(Stellenangebot stellenangebot) {
            return null;
        }
    }

    @Test
    void findAllStellenangeboteFilterNoop() {
        List<Stellenangebot> stellenangebots = new ArrayList<>();
        stellenangebots.add(getStellenangebot(0));
        stellenangebots.add(getStellenangebot(1));
        MockRespository repository = new MockRespository(new ArrayList<>(stellenangebots));

        StellenangebotApplicationService stellenangebotApplicationService =
                new StellenangebotApplicationService(repository);

        assertEquals(stellenangebots, stellenangebotApplicationService.findAllStellenangebote(
                new NoopStellenangebotFilter()
        ));
    }

    @Test
    void findAllStellenangeboteFilterListNoop() {
        List<Stellenangebot> stellenangebots = new ArrayList<>();
        stellenangebots.add(getStellenangebot(0));
        stellenangebots.add(getStellenangebot(1));
        MockRespository repository = new MockRespository(new ArrayList<>(stellenangebots));

        StellenangebotApplicationService stellenangebotApplicationService =
                new StellenangebotApplicationService(repository);

        assertEquals(stellenangebots, stellenangebotApplicationService.findAllStellenangebote(
                new ListStellenangebotFilter(
                        new NoopStellenangebotFilter(),
                        new NoopStellenangebotFilter(),
                        new ListStellenangebotFilter(
                                new NoopStellenangebotFilter()
                        )
                )
        ));
    }

    @Test
    void findAllStellenangeboteFilterIsGültig() {
        LocalDate now = LocalDate.now();
        Gültigkeitszeitraum gültigkeitszeitraum = new Gültigkeitszeitraum(now, now.plusDays(4));
        Stellenangebot valid = getStellenangebot(0, gültigkeitszeitraum);
        Stellenangebot invalid = getStellenangebot(1);
        List<Stellenangebot> stellenangebots = Arrays.asList(valid, invalid);
        MockRespository repository = new MockRespository(stellenangebots);

        StellenangebotApplicationService stellenangebotApplicationService =
                new StellenangebotApplicationService(repository);

        assertEquals(Collections.singletonList(valid), stellenangebotApplicationService.findAllStellenangebote(
                new IsGültigStellenangebotFilter(now.plusDays(1))
        ));
    }

    @Test
    void findAllStellenangeboteSearchBeschreibung() {
        Stellenangebot invalid = getStellenangebotWithBeschreibung(0, "Corn Corn");
        Stellenangebot valid = getStellenangebot(1);
        List<Stellenangebot> stellenangebots = Arrays.asList(invalid, valid);
        MockRespository repository = new MockRespository(stellenangebots);

        StellenangebotApplicationService stellenangebotApplicationService =
                new StellenangebotApplicationService(repository);

        assertEquals(Collections.singletonList(valid), stellenangebotApplicationService.findAllStellenangebote(
                new ContainsBeschreibungsTextStellenangebotFilter("well")
        ));
    }

    @Test
    void findAllStellenangeboteFilterArbeitszeit() {
        Stellenangebot invalid = getStellenangebotWithArbeitszeit(4, Arbeitszeit.TEILZEIT);
        Stellenangebot invalid2 = getStellenangebotWithArbeitszeit(5, Arbeitszeit.TEILZEIT);
        List<Stellenangebot> stellenangebots = getStellenangebotList();
        List<Stellenangebot> stellenangebotsWithInvalid = new ArrayList<>(stellenangebots);
        stellenangebotsWithInvalid.add(1, invalid2);
        stellenangebotsWithInvalid.add(3, invalid);
        MockRespository repository = new MockRespository(stellenangebotsWithInvalid);

        StellenangebotApplicationService stellenangebotApplicationService =
                new StellenangebotApplicationService(repository);

        assertEquals(stellenangebots, stellenangebotApplicationService.findAllStellenangebote(
                new ArbeitszeitMatchesStellenangebotFilter(Arbeitszeit.VOLLZEIT)
        ));
    }
}
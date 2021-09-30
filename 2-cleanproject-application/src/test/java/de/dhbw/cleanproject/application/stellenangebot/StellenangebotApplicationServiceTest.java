 package de.dhbw.cleanproject.application.stellenangebot;

import de.dhbw.cleanproject.domain.gültigkeitszeitraum.Gültigkeitszeitraum;
import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
import de.dhbw.cleanproject.domain.stellenangebot.StellenangebotRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StellenangebotApplicationServiceTest {
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


    private static Stellenangebot getStellenangebot(long l) {
        String titel = "Der Winterkönig";
        String url = "https://job.unternehmen/" + l;
        String beschreibung = "Bernard Cornwell";
        LocalDate of = LocalDate.of(1996, 1, 1);
        Gültigkeitszeitraum gültigkeitszeitraum = new Gültigkeitszeitraum(of, of.plusMonths(3));
        return new Stellenangebot(l, titel, beschreibung, url, gültigkeitszeitraum, arbeitszeit, berufserfahrung, unterxnehmen, branche);
    }

    @Test
    void findAllStellenangebote() {
        List<Stellenangebot> stellenangebots = new ArrayList<>();
        stellenangebots.add(getStellenangebot(0));
        stellenangebots.add(getStellenangebot(1));
        MockRespository repository = new MockRespository(new ArrayList<>(stellenangebots));

        StellenangebotApplicationService stellenangebotApplicationService =
                new StellenangebotApplicationService(repository);

        assertEquals(stellenangebots, stellenangebotApplicationService.findAllStellenangebote());
    }
}
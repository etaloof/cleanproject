package de.dhbw.cleanproject.application.stellenangebot;

import de.dhbw.cleanproject.domain.gültigkeitszeitraum.Gültigkeitszeitraum;
import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
import de.dhbw.cleanproject.domain.stellenangebot.StellenangebotRepository;
import de.dhbw.cleanproject.domain.stellenangebot.arbeitszeit.Arbeitszeit;
import de.dhbw.cleanproject.domain.unternehmen.Unternehmen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StellenangebotApplicationServiceTest {
    static Stellenangebot getStellenangebot(long l) {
        LocalDate of = LocalDate.of(1996, 1, 1);
        Gültigkeitszeitraum gültigkeitszeitraum = new Gültigkeitszeitraum(of, of.plusMonths(3));
        return StellenangebotApplicationServiceTest.getStellenangebot(l, gültigkeitszeitraum);
    }

    static Stellenangebot getStellenangebot(long l, Gültigkeitszeitraum gültigkeitszeitraum) {
        String titel = "Der Winterkönig";
        String url = "https://job.unternehmen/" + l;
        String beschreibung = "Bernard Cornwell";
        Arbeitszeit arbeitszeit = Arbeitszeit.VOLLZEIT;
        Long berufserfahrung = 3L;
        Unternehmen unternehmen = new Unternehmen("DHBW");
        String branche = "branche";
        return new Stellenangebot(l, titel, beschreibung, url, gültigkeitszeitraum, arbeitszeit, berufserfahrung, unternehmen, branche);
    }

    static Stellenangebot getStellenangebotWithBeschreibung(long l, String beschreibung) {
        String titel = "Der Winterkönig";
        String url = "https://job.unternehmen/" + l;
        LocalDate of = LocalDate.of(1996, 1, 1);
        Gültigkeitszeitraum gültigkeitszeitraum = new Gültigkeitszeitraum(of, of.plusMonths(3));
        Arbeitszeit arbeitszeit = Arbeitszeit.VOLLZEIT;
        Long berufserfahrung = 3L;
        Unternehmen unternehmen = new Unternehmen("DHBW");
        String branche = "branche";
        return new Stellenangebot(l, titel, beschreibung, url, gültigkeitszeitraum, arbeitszeit, berufserfahrung, unternehmen, branche);
    }

    static List<Stellenangebot> getStellenangebotList() {
        List<Stellenangebot> stellenangebots = new ArrayList<>();
        stellenangebots.add(StellenangebotApplicationServiceTest.getStellenangebotWithBeschreibung(0, "B. Corn"));
        stellenangebots.add(StellenangebotApplicationServiceTest.getStellenangebotWithBeschreibung(1, "A. Corn"));
        stellenangebots.add(StellenangebotApplicationServiceTest.getStellenangebotWithBeschreibung(2, "C. Corn"));
        stellenangebots.add(StellenangebotApplicationServiceTest.getStellenangebotWithBeschreibung(3, "D. Corn"));
        return stellenangebots;
    }

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
}

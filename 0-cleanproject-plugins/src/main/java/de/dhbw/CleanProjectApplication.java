package de.dhbw;

import de.dhbw.cleanproject.domain.gültigkeitszeitraum.Gültigkeitszeitraum;
import de.dhbw.cleanproject.domain.stellenangebot.arbeitszeit.Arbeitszeit;
import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
import de.dhbw.cleanproject.domain.stellenangebot.StellenangebotRepository;
import de.dhbw.cleanproject.domain.unternehmen.Unternehmen;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class CleanProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StellenangebotRepository repository) {
        return (args) -> {
            repository.save(getStellenangebot(1L));
            repository.save(getStellenangebot(2L));
            repository.save(getStellenangebot(3L));
        };
    }

    private static Stellenangebot getStellenangebot(long l) {
        String titel = "Der Winterkönig";
        String url = "https://job.unternehmen/" + l;
        String beschreibung = "Bernard Cornwell";
        LocalDate of = LocalDate.of(1996, 1, 1);
        Gültigkeitszeitraum gültigkeitszeitraum = new Gültigkeitszeitraum(of, of.plusMonths(3));
        Arbeitszeit arbeitszeit = Arbeitszeit.VOLLZEIT;
        Long berufserfahrung = 3L;
        Unternehmen unternehmen = new Unternehmen("DHBW");
        String branche = "branche";
        return new Stellenangebot(l, titel, beschreibung, url, gültigkeitszeitraum, arbeitszeit, berufserfahrung, unternehmen, branche);
    }

}

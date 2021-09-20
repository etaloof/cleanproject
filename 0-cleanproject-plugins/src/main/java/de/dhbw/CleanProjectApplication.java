package de.dhbw;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
import de.dhbw.cleanproject.domain.stellenangebot.StellenangebotRepository;
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
        return new Stellenangebot(l, titel, beschreibung, url, of, of.plusMonths(3));
    }

}

package de.dhbw.cleanproject.application.stellenangebot.filter;

import de.dhbw.cleanproject.domain.gültigkeitszeitraum.Gültigkeitszeitraum;
import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IsGültigStellenangebotFilter implements FilterStellenangeboteDomainService {
    private final LocalDate now;

    public IsGültigStellenangebotFilter(LocalDate now) {
        this.now = now;
    }

    public IsGültigStellenangebotFilter() {
        this(LocalDate.now());
    }

    @Override
    public List<Stellenangebot> filter(List<Stellenangebot> allStellenangebote) {
        return allStellenangebote.stream()
                .filter(isValid(now))
                .collect(Collectors.toList());
    }

    private static Predicate<Stellenangebot> isValid(LocalDate now) {
        return stellenangebot -> {
            Gültigkeitszeitraum gültigkeitszeitraum = stellenangebot.getGültigkeitszeitraum();
            return gültigkeitszeitraum.getGültigBis().isAfter(now);
        };
    }
}

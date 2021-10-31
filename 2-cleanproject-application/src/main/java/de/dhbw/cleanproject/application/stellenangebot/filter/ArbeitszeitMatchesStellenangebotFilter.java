package de.dhbw.cleanproject.application.stellenangebot.filter;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
import de.dhbw.cleanproject.domain.stellenangebot.arbeitszeit.Arbeitszeit;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArbeitszeitMatchesStellenangebotFilter implements FilterStellenangeboteDomainService {
    private final Arbeitszeit arbeitszeit;

    public ArbeitszeitMatchesStellenangebotFilter(Arbeitszeit arbeitszeit) {
        this.arbeitszeit = arbeitszeit;
    }

    @Override
    public List<Stellenangebot> filter(List<Stellenangebot> allStellenangebote) {
        return allStellenangebote.stream()
                .filter(matches(arbeitszeit))
                .collect(Collectors.toList());
    }

    private static Predicate<Stellenangebot> matches(Arbeitszeit arbeitszeit) {
        return stellenangebot -> {
            Arbeitszeit stellenangebotArbeitszeit = stellenangebot.getArbeitszeit();

            if (arbeitszeit.isVollzeit()) {
                if (stellenangebotArbeitszeit.isVollzeit()) {
                    return true;
                } else if (stellenangebotArbeitszeit.isTeilzeit()) {
                    return false;
                }

                return throwUnhandledEnumValueException(stellenangebotArbeitszeit);
            } else if (arbeitszeit.isTeilzeit()) {
                if (stellenangebotArbeitszeit.isTeilzeit()) {
                    return true;
                } else if (stellenangebotArbeitszeit.isVollzeit()) {
                    return false;
                }

                return throwUnhandledEnumValueException(stellenangebotArbeitszeit);
            }

            return throwUnhandledEnumValueException(arbeitszeit);
        };
    }

    private static boolean throwUnhandledEnumValueException(Arbeitszeit arbeitszeit) {
        throw new NotImplementedException("Value of enum Arbeitszeit is left unhandled: " + arbeitszeit.name());
    }

    // this is not supposed to be handled/used anywhere because it indicates a bug, if thrown
    private static final class NotImplementedException extends RuntimeException {
        private NotImplementedException(String s) {
            super(s);
        }
    }
}

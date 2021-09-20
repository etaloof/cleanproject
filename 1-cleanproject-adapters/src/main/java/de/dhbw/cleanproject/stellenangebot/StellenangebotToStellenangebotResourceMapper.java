package de.dhbw.cleanproject.stellenangebot;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StellenangebotToStellenangebotResourceMapper implements Function<Stellenangebot, StellenangebotResource> {

    @Override
    public StellenangebotResource apply(Stellenangebot stellenangebot) {
        return map(stellenangebot);
    }

    private StellenangebotResource map(Stellenangebot stellenangebot) {
        return new StellenangebotResource(
                stellenangebot.getId(),
                stellenangebot.getTitel(),
                stellenangebot.getBeschreibung(),
                stellenangebot.getUrl(),
                stellenangebot.getGültigAb(),
                stellenangebot.getGültigBis());
    }
}

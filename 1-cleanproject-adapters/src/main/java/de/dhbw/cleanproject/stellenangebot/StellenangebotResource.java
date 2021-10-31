package de.dhbw.cleanproject.stellenangebot;

import java.time.LocalDate;

public class StellenangebotResource {

    private final Long id;

    private final String titel;

    private final String beschreibung;

    private final String url;

    private final LocalDate gültigAb;

    private final LocalDate gültigBis;

    public StellenangebotResource(Long id, String titel, String beschreibung, String url, LocalDate gültigAb, LocalDate gültigBis) {
        this.id = id;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.url = url;
        this.gültigAb = gültigAb;
        this.gültigBis = gültigBis;
    }

    public Long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getUrl() {
        return url;
    }

    public LocalDate getGültigAb() {
        return gültigAb;
    }

    public LocalDate getGültigBis() {
        return gültigBis;
    }
}

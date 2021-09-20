package de.dhbw.cleanproject.domain.stellenangebot;

import de.dhbw.cleanproject.domain.gültigkeitszeitraum.Gültigkeitszeitraum;

import javax.persistence.*;

@Entity
@Table(name = "stellenangebot")
public class Stellenangebot {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titel")
    private String titel;

    @Column(name = "beschreibung")
    private String beschreibung;

    @Column(name = "url")
    private String url;

    @Column(name = "gültigkeitszeitraum")
    private Gültigkeitszeitraum gültigkeitszeitraum;

    private Stellenangebot() {
        //default constructor for JPA
    }

    public Stellenangebot(Long id, String titel, String beschreibung, String url, Gültigkeitszeitraum gültigkeitszeitraum) {
        this.id = id;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.url = url;
        this.gültigkeitszeitraum = gültigkeitszeitraum;
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

    public Gültigkeitszeitraum getGültigkeitszeitraum() {
        return gültigkeitszeitraum;
    }
}

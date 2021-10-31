package de.dhbw.cleanproject.domain.stellenangebot;

import de.dhbw.cleanproject.domain.gültigkeitszeitraum.Gültigkeitszeitraum;
import de.dhbw.cleanproject.domain.stellenangebot.arbeitszeit.Arbeitszeit;
import de.dhbw.cleanproject.domain.unternehmen.Unternehmen;

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

    @Column(name = "standort")
    private String standort;

    @Column(name = "arbeitszeit")
    private Arbeitszeit arbeitszeit;

    @Column(name = "berufserfahrung")
    private Long berufserfahrung;

    @ManyToOne(cascade=CascadeType.ALL)
    private Unternehmen unternehmen;

    @Column(name = "branche")
    private String branche;

    private Stellenangebot() {
        //default constructor for JPA
    }

    public Stellenangebot(Long id, String titel, String beschreibung, String url, Gültigkeitszeitraum gültigkeitszeitraum, Arbeitszeit arbeitszeit, Long berufserfahrung, Unternehmen unternehmen, String branche) {
        this.id = id;
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.url = url;
        this.gültigkeitszeitraum = gültigkeitszeitraum;
        this.arbeitszeit = arbeitszeit;
        this.berufserfahrung = berufserfahrung;
        this.unternehmen = unternehmen;
        this.branche = branche;
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

    public String getStandort() {
        return standort;
    }

    public Arbeitszeit getArbeitszeit() {
        return arbeitszeit;
    }

    public Long getBerufserfahrung() {
        return berufserfahrung;
    }

    public Unternehmen getUnternehmen() {
        return unternehmen;
    }

    public String getBranche() {
        return branche;
    }
}

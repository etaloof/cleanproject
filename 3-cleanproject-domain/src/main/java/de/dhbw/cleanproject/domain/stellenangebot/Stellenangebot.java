package de.dhbw.cleanproject.domain.stellenangebot;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "gültig_ab")
    private LocalDate gültigAb;

    @Column(name = "gültig_bis")
    private LocalDate gültigBis;

    private Stellenangebot() {
        //default constructor for JPA
    }

    public Stellenangebot(Long id, String titel, String beschreibung, String url, LocalDate gültigAb, LocalDate gültigBis) {
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

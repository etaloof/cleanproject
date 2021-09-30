package de.dhbw.cleanproject.domain.nutzer;

import de.dhbw.cleanproject.domain.nutzer.status.Status;

import javax.persistence.*;

@Entity
public class Nutzer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titel")
    private String Vorname;

    @Column(name = "beschreibung")
    private String Nachname;

    @Column(name = "url")
    private Status Status;

    public Long getId() {
        return id;
    }

    public String getVorname() {
        return Vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }
}

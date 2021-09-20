package de.dhbw.cleanproject.domain.gültigkeitszeitraum;

import java.time.LocalDate;

import javax.persistence.*;

@Embeddable
@Table(name = "gültigkeitszeitraum>")
public class Gültigkeitszeitraum {
    @Column(name = "gültig_ab")
    private LocalDate gültigAb;

    @Column(name = "gültig_bis")
    private LocalDate gültigBis;

    public LocalDate getGültigAb() {
        return gültigAb;
    }

    public LocalDate getGültigBis() {
        return gültigBis;
    }

    public Gültigkeitszeitraum() {
    }

    public Gültigkeitszeitraum(LocalDate gültigAb, LocalDate gültigBis) {
        this.gültigAb = gültigAb;
        this.gültigBis = gültigBis;
    }
}
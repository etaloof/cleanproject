package de.dhbw.cleanproject.domain.gültigkeitszeitraum;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

@Embeddable
@Table(name = "gültigkeitszeitraum>")
public final class Gültigkeitszeitraum {
    @Column(name = "gültig_ab")
    private LocalDate gültigAb; // not final for JPA

    @Column(name = "gültig_bis")
    private LocalDate gültigBis; // not final for JPA

    public LocalDate getGültigAb() {
        return gültigAb;
    }

    public LocalDate getGültigBis() {
        return gültigBis;
    }

    public Gültigkeitszeitraum() {
    }

    public Gültigkeitszeitraum(LocalDate gültigAb, LocalDate gültigBis) throws IllegalArgumentException {
        this.gültigAb = gültigAb;
        this.gültigBis = gültigBis;

        if (gültigAb.isAfter(gültigBis)) {
            throw new IllegalArgumentException("gültigAb can not be before gültigBis");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gültigkeitszeitraum that = (Gültigkeitszeitraum) o;
        return gültigAb.equals(that.gültigAb) && gültigBis.equals(that.gültigBis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gültigAb, gültigBis);
    }
}
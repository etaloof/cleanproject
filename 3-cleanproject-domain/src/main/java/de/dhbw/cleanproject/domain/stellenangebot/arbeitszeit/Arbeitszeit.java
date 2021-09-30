package de.dhbw.cleanproject.domain.stellenangebot.arbeitszeit;

public enum Arbeitszeit {
    VOLLZEIT,
    TEILZEIT;

    public boolean isVollzeit() {
        return this.equals(Arbeitszeit.VOLLZEIT);
    }

    public boolean isTeilzeit() {
        return this.equals(Arbeitszeit.TEILZEIT);
    }
}

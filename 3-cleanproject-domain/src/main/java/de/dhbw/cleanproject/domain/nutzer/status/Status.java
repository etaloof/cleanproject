package de.dhbw.cleanproject.domain.nutzer.status;

public enum Status {
    ARBEITSSUCHEND,
    INAKTIV;

    public boolean isArbeitssuchend() {
        return this.equals(Status.ARBEITSSUCHEND);
    }

    public boolean isInaktiv() {
        return this.equals(Status.INAKTIV);
    }
}

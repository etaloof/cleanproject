package de.dhbw.cleanproject.domain.unternehmen;

import javax.persistence.*;

@Table(name = "unternehmen")
@Entity
public class Unternehmen {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public Unternehmen() {

    }

    public String getName() {
        return name;
    }

    public Unternehmen(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
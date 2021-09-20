package de.dhbw.plugins.persistence.hibernate.stellenangebote;

import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataStellenangebotRepository extends JpaRepository<Stellenangebot, Long> {
}

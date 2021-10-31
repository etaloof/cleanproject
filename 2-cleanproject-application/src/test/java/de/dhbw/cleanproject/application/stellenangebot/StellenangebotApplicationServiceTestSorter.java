 package de.dhbw.cleanproject.application.stellenangebot;

 import de.dhbw.cleanproject.application.stellenangebot.filter.NoopStellenangebotFilter;
 import de.dhbw.cleanproject.application.stellenangebot.sorter.NoopStellenangebotSorter;
 import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
 import org.junit.jupiter.api.Test;

 import java.util.ArrayList;
 import java.util.List;

 import static org.junit.jupiter.api.Assertions.assertEquals;

 class StellenangebotApplicationServiceTestSorter extends StellenangebotApplicationServiceTest {
     @Test
     void findAllStellenangeboteSorterNoop() {
         List<Stellenangebot> stellenangebots = getStellenangebotList();
         MockRespository repository = new MockRespository(new ArrayList<>(stellenangebots));

         StellenangebotApplicationService stellenangebotApplicationService =
                 new StellenangebotApplicationService(repository);

         assertEquals(stellenangebots, stellenangebotApplicationService.findAllStellenangebote(
                 new NoopStellenangebotFilter(),
                 new NoopStellenangebotSorter()
         ));
     }
 }
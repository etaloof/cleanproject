 package de.dhbw.cleanproject.application.stellenangebot;

 import de.dhbw.cleanproject.application.stellenangebot.filter.NoopStellenangebotFilter;
 import de.dhbw.cleanproject.application.stellenangebot.sorter.AlphabeticBeschreibungSorter;
 import de.dhbw.cleanproject.application.stellenangebot.sorter.AlphabeticSorter;
 import de.dhbw.cleanproject.application.stellenangebot.sorter.AlphabeticTitleSorter;
 import de.dhbw.cleanproject.application.stellenangebot.sorter.NoopStellenangebotSorter;
 import de.dhbw.cleanproject.domain.stellenangebot.Stellenangebot;
 import org.junit.jupiter.api.Test;

 import java.util.ArrayList;
 import java.util.Collections;
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

     @Test
     void findAllStellenangeboteSorterAlphabeticBeschreibung() {
         List<Stellenangebot> stellenangebots = getStellenangebotList();
         ArrayList<Stellenangebot> list = new ArrayList<>(stellenangebots);
         Collections.reverse(list);
         MockRespository repository = new MockRespository(list);
         Collections.swap(stellenangebots, 0, 1);

         StellenangebotApplicationService stellenangebotApplicationService =
                 new StellenangebotApplicationService(repository);

         assertEquals(stellenangebots, stellenangebotApplicationService.findAllStellenangebote(
                 new NoopStellenangebotFilter(),
                 new AlphabeticBeschreibungSorter()
         ));
     }
 }
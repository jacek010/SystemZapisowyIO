import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

public class ProwadzacyTest {
    Dane dane;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        dane = new Dane();
    }

    @Test
    public void createProwadzacy()
    {
        System.out.println("createProwadzacy");
        for (int i = 0; i < 4; i++) {
            Prowadzacy prowadzacy = new Prowadzacy(
                dane.daneProwadzacych[i][0],
                dane.daneProwadzacych[i][1],
                dane.daneProwadzacych[i][2],
                Integer.parseInt(dane.daneProwadzacych[i][3])
            );
            assertEquals(dane.legitymacjeProwadzacych[i], prowadzacy.getNumerLegitymacji());
        }
    }

    @Test
    public void getImie() {
        var prowadzacy = new Prowadzacy("Jan", "Nowak","magister", 123456);
        assertEquals("Jan", prowadzacy.getImie());
    }

    @Test
    public void setImie() {
        var prowadzacy = new Prowadzacy("Jan", "Nowak","magister", 123456);
        prowadzacy.setImie("Andrzej");
        assertEquals("Andrzej", prowadzacy.getImie());
    }

    @Test
    public void getNazwisko() {
        var prowadzacy = new Prowadzacy("Jan", "Nowak","magister", 123456);
        assertEquals("Nowak", prowadzacy.getNazwisko());
    }

    @Test
    public void setNazwisko() {
        var prowadzacy = new Prowadzacy("Jan", "Nowak","magister", 123456);
        prowadzacy.setNazwisko("ASDF");
        assertEquals("ASDF", prowadzacy.getNazwisko());
    }

    @Test
    public void getNumerLegitymacji() {
        var prowadzacy = new Prowadzacy("Jan", "Nowak","magister", 123456);
        assertEquals(123456, prowadzacy.getNumerLegitymacji());
    }

    @Test
    public void setNumerLegitymacji() {
        var prowadzacy = new Prowadzacy("Jan", "Nowak","magister", 123456);
        prowadzacy.setNumerLegitymacji(654321);
        assertEquals(654321, prowadzacy.getNumerLegitymacji());
    }

    @Test
    public void getTytul() {
        var prowadzacy = new Prowadzacy("Jan", "Nowak","magister", 123456);
        assertEquals("magister", prowadzacy.getTytul());
    }

    @Test
    public void setTytul() {
        var prowadzacy = new Prowadzacy("Jan", "Nowak","magister", 123456);
        prowadzacy.setTytul("profesor");
        assertEquals("profesor", prowadzacy.getTytul());
    }
}
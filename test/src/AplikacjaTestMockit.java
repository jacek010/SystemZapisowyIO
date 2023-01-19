package src;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AplikacjaTestMockit {

    private Kurs kursMock;
    private TreeMap<Integer, Kurs> listaKursow;


    @Before
    public void setup(){
        kursMock=mock(Kurs.class);

        listaKursow.put(1,kursMock);
    }

    @Test
    public void znajdzStudenta(){
        int idStudenta=8;
        when(kursMock.przeszukajListeStudentowKursu(idStudenta)).thenReturn(true);

        assertTrue(listaKursow.get(1).przeszukajListeStudentowKursu(8));
    }
}

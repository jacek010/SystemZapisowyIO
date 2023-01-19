import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Kurs2Test {

    public static Object[] testValues(){
        return new Object[]{
                new Object[]{1,"Informatyka", 5, "Poniedzialek", "9:15", "Paweł", "Szyc", "Doktor", 987654},
                new Object[]{4,"wf", 5, "Poniedzialek", "13:15", "Jacek", "Kot", "Magister", 555444},
                new Object[]{8,"Fizyka", 5, "Piątek", "17:15", "Katarzyna", "Szybka", "Profesor", 111333}
        };
    }


    @ParameterizedTest
    @MethodSource("testValues")
    public void test3SprawdzNazweKursu(int idKursu, String nazwaKursu, int liczbaMiejsc, String dzienTygodnia, String termin, String imieProwadzacego, String nazwiskoProwadzacego, String tytul, int numerLegitymacji){
        Kurs kurs = new Kurs(idKursu, nazwaKursu, liczbaMiejsc, dzienTygodnia, termin, imieProwadzacego, nazwiskoProwadzacego, tytul, numerLegitymacji);

        assertEquals(nazwaKursu, kurs.getNazwaKursu());
    }

}
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KursTest {

    static Dane dane;

    static Kurs[] kursy;

    public static Object[] testValues(){
        return new Object[]{
                new Object[]{1,"Informatyka", 5, "Poniedzialek", "9:15", "Paweł", "Szyc", "Doktor", 987654},
                new Object[]{4,"wf", 5, "Poniedzialek", "13:15", "Jacek", "Kot", "Magister", 555444},
                new Object[]{8,"Fizyka", 5, "Piątek", "17:15", "Katarzyna", "Szybka", "Profesor", 111333}
        };
    }
    @Before
    public void SetUp(){

        System.out.println("www");
        kursy = new Kurs[2];
        kursy[0]=new Kurs(1,"Matematyka", 10, "Wtorek", "10:25TN","Jan" ,"Kowalski", "Doktor", 999999);
        kursy[1]=new Kurs(2,"Fizyka", 20, "Czwartek", "16:15TP","Anna" ,"Nowak", "Doktor", 888888);

        dane = new Dane();
    }

    @Test
    public void test1WstawStudentaDoKursu(){
        for(int i = 0; i<2;i++){
            for(int j = 0;j<4;j++){
                kursy[i].dodajStudentaDoListyKursu(Dane.studenci[j]);
                assertTrue(kursy[i].przeszukajListeStudentowKursu(dane.indeksyStudentow[j]));
            }
        }
    }

    @Test
    public void test2SprawdzImieStudenta(){
        for(int i =0;i<2;i++){
            for(int j=0;j<4;j++){
                String nazwisko = kursy[i].zwrocStudenta(dane.indeksyStudentow[j]).getNazwisko();
                assertEquals(dane.daneStudentow[j][1], nazwisko);
            }
        }
    }

    @ParameterizedTest
    @MethodSource("testValues")
    public void test3SprawdzNazweKursu(int idKursu, String nazwaKursu, int liczbaMiejsc, String dzienTygodnia, String termin, String imieProwadzacego, String nazwiskoProwadzacego, String tytul, int numerLegitymacji){
        Kurs kurs = new Kurs(idKursu, nazwaKursu, liczbaMiejsc, dzienTygodnia, termin, imieProwadzacego, nazwiskoProwadzacego, tytul, numerLegitymacji);

        assertEquals(nazwaKursu, kurs.getNazwaKursu());
    }

}
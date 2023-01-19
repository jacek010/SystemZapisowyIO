import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AplikacjaTest {

    static Dane dane;
    static Aplikacja instance;
    static Student student;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void SetUp() {
        instance = new Aplikacja();
        dane = new Dane();
        student = new Student("Andrzej", "Kowalski", 222222);
    }


    @Test
    public void test1DodajKurs() {
        System.out.println("DodajKurs");
        instance.dodajKurs(1,"Analiza", 10,"Wtorek", "16:25 TN", "Jan", "Nowak", "doktor", 123456);
        instance.dodajKurs(2, "Algebra", 5, "Czwartek", "9:15", "Magda", "Koń", "profesor", 234567);
    }

    @Test
    public void test2DodajStudenta() {
        System.out.println("DodajStudenta");
        instance.dopiszStudenta(1, student);
        Kurs kurs = instance.zwrocKurs(1);
        assertEquals(kurs.zwrocStudenta(222222), student);
    }

    @Test
    public void test3PrzeniesStudenta() {
        System.out.println("PrzeniesStudenta");
        assertEquals(instance.zwrocStudenta(222222), instance.zwrocKurs(1).zwrocStudenta(222222));
        instance.przeniesStudenta(222222, 1, 2);
        assertEquals(instance.zwrocStudenta(222222), instance.zwrocKurs(2).zwrocStudenta(222222));
        assertNull(instance.zwrocKurs(1).zwrocStudenta(222222));
    }

    @Test
    public void test4usunStudentaZKursu() {
        System.out.println("usunStudentaZKursu");
        assertEquals(222222, instance.zwrocKurs(2).zwrocStudenta(222222).getNumerIndeksu());
        instance.usunStudentaZKursu(2, 222222);
        assertNull(instance.zwrocKurs(2).zwrocStudenta(123456));
    }

    @Test
    public void test5dopiszStudenta() {
        System.out.println("dopiszStudenta");
        assertNull(instance.zwrocKurs(1).zwrocStudenta(333333));
        instance.dopiszStudenta(1, "Franek", "Kowalczyk", 333333);
        assertEquals(333333, instance.zwrocStudenta(333333).getNumerIndeksu());
    }

    @Test
    public void test6szukajKursu() {
        assertTrue(instance.szukajKursu(1));
    }

    @Test
    public void test7getProwadzacy() {
        assertEquals(111233, instance.getProwadzacy(111233).getNumerLegitymacji());
    }

    @Test
    public void test8dodajKurs() {
        System.out.println("dodajKurs");
        instance.dodajKurs(3, "Matematyka dyskretna", 8, "Poniedziałek", "9:15", "Magda", "Koń", "profesor", 234567);
        assertEquals(3, instance.zwrocKurs(3).getIdKursu());
    }

    @Test
    public void test9usunKurs() {
        assertEquals(3, instance.zwrocKurs(3).getIdKursu());
        instance.usunKurs(3);
        assertNull(instance.zwrocKurs(3));
    }

    @Test
    public void dodajProwadzacego() {
        System.out.println("dodajProwadzacego");
        instance.dodajProwadzacego("Bartosz", "Szybki", "magister", 111233);
        assertEquals(111233, instance.getProwadzacy(111233).getNumerLegitymacji());
    }
}
import org.junit.Before;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.IllegalFormatCodePointException;

import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Dane dane=new Dane();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUP(){
        dane=new Dane();
    }

//    @Test
//    void createStudent(){
//        System.out.println("createStudent");
//        for(int i=0;i<4;i++){
//            Student student = new Student(dane.daneStudentow[i][0],dane.daneStudentow[i][1],Integer.parseInt(dane.daneStudentow[i][2]));
//            assertEquals(Dane.studenci[i], student);
//        }
//         exception.expect(IllegalFormatCodePointException.class);
//         exception.expectMessage("Code point = 0x0");
//    }


    //Test do punktu 2 instrukcji lab.


    @Test
    void createStudent2(){
        System.out.println("createStudent2");
        for(int i=0;i<4;i++){
            Student student = new Student(dane.daneStudentow[i][0],dane.daneStudentow[i][1],Integer.parseInt(dane.daneStudentow[i][2]));
            assertEquals(dane.indeksyStudentow[i], student.getNumerIndeksu());
        }
    }


    @Test
    void getImie() {
        var student = new Student("Jan", "Nowak", 123456);
        assertEquals("Jan", student.getImie());
    }

    @Test
    void setImie() {
        var student = new Student("Jan", "Nowak", 123456);
        student.setImie("Andrzej");
        assertEquals("Andrzej", student.getImie());
    }

    @Test
    void getNazwisko() {
        var student = new Student("Jan", "Nowak", 123456);
        assertEquals("Nowak", student.getNazwisko());
    }

    @Test
    void setNazwisko() {
        var student = new Student("Jan", "Nowak", 123456);
        student.setNazwisko("Kowalski");
        assertEquals("Kowalski", student.getNazwisko());
    }

    @Test
    void getNumerIndeksu() {
        var student = new Student("Jan", "Nowak", 123456);
        assertEquals(123456, student.getNumerIndeksu());
    }

    @Test
    void setNumerIndeksu() {
        var student = new Student("Jan", "Nowak", 123456);
        student.setNumerIndeksu(654321);
        assertEquals(654321, student.getNumerIndeksu());
    }
}
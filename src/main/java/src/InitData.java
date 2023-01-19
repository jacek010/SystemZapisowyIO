package src;
public class InitData
{
    public static Aplikacja createSampleAplicationWithData()
    {
        Aplikacja aplikacja = new Aplikacja();

        System.out.println("Wypełniam bazę początkowymi wartościami");

        // tworzymy prowadzacych
        aplikacja.dodajProwadzacego("Jan", "Nowak", "doktor", 123456);
        aplikacja.dodajProwadzacego("Magda", "Koń", "profesor", 234567);
        aplikacja.dodajProwadzacego("Bartosz", "Szybki", "magister", 111233);
        aplikacja.dodajProwadzacego("Marek", "Piłka", "magister", 456789);


        //tworzymy kursy
        aplikacja.dodajKurs(1,"Analiza", 10,"Wtorek", "16:25 TN", "Jan", "Nowak", "doktor", 123456);
        aplikacja.dodajKurs(2, "Algebra", 5, "Czwartek", "9:15", "Magda", "Koń", "profesor", 234567);
        aplikacja.dodajKurs(3, "Matematyka dyskretna", 8, "Poniedziałek", "9:15", "Magda", "Koń", "profesor", 234567);
        aplikacja.dodajKurs(4, "Informatyka podstawy", 4, "Poniedziałek", "11:15", "Bartosz", "Szybki", "magister", 111233);
        aplikacja.dodajKurs(5, "Bazy danych", 4, "Środa", "15:15", "Bartosz", "Szybki", "magister", 111233);
        // aplikacja.dodajKurs(6, "WF", 10, "Czwartek", "15:15", "Marek", "Piłka", "magister", 456789);
        aplikacja.dodajKurs(6, "WF", 10, "Czwartek", "15:15", aplikacja.getProwadzacy(456789));

        //zapisujemy studentów na kursy
        aplikacja.dopiszStudenta(1, "Andrzej", "Kowalski", 222222);

        aplikacja.dopiszStudenta(6, "Karolina", "Kowalska", 122234);

        return aplikacja;
    }

}

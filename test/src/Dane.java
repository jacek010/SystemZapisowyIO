public class Dane {

    public String daneStudentow[][] = new String[][]{
            {"Jan", "Nowak", "111111"},
            {"Anna", "Kowalska", "222222"},
            {"Kazimierz", "Grzyb", "333333"},
            {"Filip", "Piotrowski", "444444"}
    };

    public int[] indeksyStudentow={111111, 222222, 333333, 444444};

    public static Student studenci[]={
            new Student("Jan", "Nowak", 111111),
            new Student("Anna", "Kowalska", 222222),
            new Student("Kazimierz", "Grzyb", 333333),
            new Student("Filip", "Piotrowski", 444444),
    };


    //int idKursu, String nazwaKursu, int liczbaMiejsc, String dzienTygodnia, String termin, String imieProwadzacego, String nazwiskoProwadzacego, String tytul, int numerLegitymacji
    public static Kurs[] daneKursow = {
            new Kurs(1,"Matematyka", 10, "Wtorek", "10:25TN","Jan" ,"Kowalski", "Doktor", 999999),
            new Kurs(2,"Fizyka", 20, "Czwartek", "16:15TP","Anna" ,"Nowak", "Doktor", 888888)
    };
}

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

    public String daneProwadzacych[][] = new String[][]{
            {"Jan", "Nowak", "doktor", "123456"},
            {"Magda", "Koń", "profesor", "234567"},
            {"Bartosz", "Szybki", "magister", "111233"},
            {"Marek", "Piłka", "magister", "456789"}
    };

    public int[] legitymacjeProwadzacych = {123456, 234567, 111233, 456789};
}

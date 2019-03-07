import callendar.Hours_Days;
import callendar.Callendar;
import reservation.Reservation;
import doctor.DoctorController;
import patient.PatientController;

public class Main {
    public static void main(String[] args) {
        PatientController pC = new PatientController();
        Hours_Days hD = new Hours_Days();
        DoctorController dC = new DoctorController(pC, hD);
        Callendar callendar = new Callendar();
        Reservation reservation = new Reservation(dC, pC);
        // Dodanie nowego Doktora
        dC.newDoctor("Jan", "Kowalski");
        dC.newDoctor("Jan2", "Kowalski2");
        dC.newDoctor("Jan3", "Kowalski3");
        dC.newDoctor("Jan4", "Kowalski4");
        System.out.println("=========================================================================");
        // Dodanie dnia pracy do doktorka od razu z godzinami pracy
        // Nie doda dwa razy tego samego dnia do pracy doktorka (trzeba zrobiić zakaz dodania tych samych godzin)
        // (może się uda ale jest to póki co nie potrzebne)
        dC.addWorkingHoursToSpecificDay(0, 2, 1, 3);
        dC.addWorkingHoursToSpecificDay(1, 3, 5, 7);
        dC.addWorkingHoursToSpecificDay(1, 4, 5, 7);
        dC.addWorkingHoursToSpecificDay(2, 3, 5, 7);
        dC.addWorkingHoursToSpecificDay(3, 5, 1, 2);
        dC.addWorkingHoursToSpecificDay(3, 5, 4, 7);
        dC.showDoctors();
        System.out.println("=========================================================================");
        // Nowy pacjent
        pC.newPatient("Zenek", "Retet");
        pC.newPatient("Zenek2", "Retet2");
        pC.newPatient("Zenek3", "Retet3");
        pC.showPatients();
        System.out.println("=========================================================================");
        //sprawdzenie czy kalendarz działa poprawnie oraz czy można zdefiniować dowolny dzień
        //i określić jaki to dzień tygodnia
        callendar.getCallendar();
        callendar.getCallendarDayNow();
        System.out.println("=========================================================================");
        callendar.setCallenadrDayOfVisit(13, 3, 2019);
        callendar.getCallendarDayNow();
        callendar.getCallendar();
        System.out.println("=========================================================================");
        //Wyszukiwanie w jaki dzień konkretny doktor pracuje
        dC.getAllDaysDocIsWorking(1);
        System.out.println("=========================================================================");
        //Wyszukiwanie kto pracuje w dany dzień
        dC.getAllDoctorsWorkingInThatDay(3);
        System.out.println("=========================================================================");
        //Pacjent do Doktorka w Konretny dzień
        //Przyjmuje tylko jednego pacjeta na dana godzine w dany dzien
        //Nie sprawdza czy termin zajety nie informuje czy termin zajety
        reservation.addPatientToDay(0, 0, 25, 3, 2019, 2);
        reservation.addPatientToDay(1, 0, 25, 3, 2019, 3);
        reservation.addPatientToDay(1, 0, 25, 3, 2019, 4);
        reservation.addPatientToDay(2, 3, 28, 3, 2019, 6);
        dC.getReservation();
    }
}



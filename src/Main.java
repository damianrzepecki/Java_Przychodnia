import callendar.CalendarController;
import callendar.Callendar;
import reservation.Reservation;
import doctor.DoctorController;
import patient.PatientController;

public class Main {
    public static void main(String[] args) {
        CalendarController cC = new CalendarController();
        cC.definehoursAday();
        Reservation reservation = new Reservation();
        // Dodanie nowego Doktora
        DoctorController dc = new DoctorController();
        dc.newDoctor("Jan", "Kowalski");
        dc.newDoctor("Jan2", "Kowalski2");
        dc.newDoctor("Jan3", "Kowalski3");
        System.out.println("=========================================================================");
        // Dodanie dnia pracy do doktorka od razu z godzinami pracy
        // Nie doda dwa razy tego samego dnia do pracy doktorka (trzeba zrobiić zakaz dodania tych samych godzin)
        // (może się uda ale jest to póki co nie potrzebne)
        dc.addWorkingHoursToSpecificDay(0,2,1,3);
        dc.addWorkingHoursToSpecificDay(1,3,5,7);
        dc.addWorkingHoursToSpecificDay(1,4,5,7);
        dc.addWorkingHoursToSpecificDay(2,3,5,7);
        dc.addWorkingHoursToSpecificDay(3,1,1,7);
        dc.addWorkingHoursToSpecificDay(3,1,1,7);
        dc.showDoctors();
        System.out.println("=========================================================================");
        // Dodanie do dnia pracy doktorka godzin pracy
        PatientController pc = new PatientController();
        pc.newPatient("Zenek", "Retet");
        pc.newPatient("Zenek2", "Retet2");
        pc.newPatient("Zenek3", "Retet3");
        pc.showPatients();
        System.out.println("=========================================================================");
        Callendar callendar = new Callendar();
        callendar.getCallendar();
        callendar.getCallendarDayNow();
        System.out.println("=========================================================================");
        callendar.setCallenadrDayOfVisit(13,3,2019);
        callendar.getCallendarDayNow();
        callendar.getCallendar();
        System.out.println("=========================================================================");
//      Wyszukiwanie w jaki dzień konkretny doktor pracuje
        dc.getAllDaysDocIsWorking(1);
        System.out.println("=========================================================================");
//      Wyszukiwanie kto pracuje w dany dzień
        dc.getAllDoctorsWorkingInThatDay(3);
        System.out.println("=========================================================================");
//      Pacjent do Doktorka w Konretny dzień
//        dc.addPatientToDay(0,0,25,3,2019);

        System.out.println("=========================================================================");
        reservation.addPatientToDay(0,0,25,3,2019);
    }
}



package reservation;

import callendar.CalendarController;
import doctor.DoctorController;
import patient.PatientController;

public class Reservation{

    DoctorController dC = new DoctorController();
    PatientController pC = new PatientController();
    CalendarController cC = new CalendarController();

    public void addPatientToDay(int patient_ID, int doc_ID, int day, int month, int year) {
        dC.addPatientToDay(patient_ID, doc_ID, day, month, year);
        System.out.println("!!!");
        dC.getReservation();
    }
}

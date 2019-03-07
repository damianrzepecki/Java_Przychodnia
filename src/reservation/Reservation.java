package reservation;

import doctor.DoctorController;
import patient.PatientController;

public class Reservation {
    private DoctorController dC;
    private PatientController pC;

    public Reservation(DoctorController dC, PatientController pC) {
        this.dC = dC;
        this.pC = pC;
    }

    public void addPatientToDay(int patient_ID, int doc_ID, int day, int month, int year, int hour) {
        dC.addPatientToDay(patient_ID, doc_ID, day, month, year, hour);
    }
}
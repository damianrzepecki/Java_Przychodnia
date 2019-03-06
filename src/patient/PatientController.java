package patient;

import java.util.ArrayList;
import java.util.List;

public class PatientController {
    private List<Patient> patients = new ArrayList<>();
    private int patient_ID = 0;

    public void newPatient(String patient_Name, String patient_Surname) {
        Patient pat = new Patient(patient_ID, patient_Name, patient_Surname);
        patients.add(pat);
        patient_ID++;
    }
    public void showPatients() {
        for (Patient pat : patients) {
            System.out.println(pat);
        }
    }
    public String getPatientData(int patient_id) {
        for (Patient pat : patients) {
            if (pat.getPatient_ID() == patient_id) {
                return pat.toString();
            }
        }
        return null;
    }
}

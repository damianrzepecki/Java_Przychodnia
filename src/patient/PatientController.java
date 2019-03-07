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

    private Patient getPatientData(int patient_id) {
        for (Patient pat : patients) {
            if (pat.getPatient_ID() == patient_id) {
                return pat;
            }
        }
        return null;
    }

    public String addPatientToDoctor(int patient_id) {
        Patient pat = getPatientData(patient_id);
        assert pat != null;
        return "Pacjęt: " + pat.getPatient_Name() + " " + pat.getPatient_Surname();
    }
}
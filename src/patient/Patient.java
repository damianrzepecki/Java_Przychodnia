package patient;

public class Patient {
    private int patient_ID = 0;
    private String patient_Name;
    private String patient_Surname;

    int getPatient_ID() {
        return patient_ID;
    }

    public void setPatient_ID(int patient_ID) {
        this.patient_ID = patient_ID;
    }

    String getPatient_Name() {
        return patient_Name;
    }

    public void setPatient_Name(String patient_Name) {
        this.patient_Name = patient_Name;
    }

    String getPatient_Surname() {
        return patient_Surname;
    }

    public void setPatient_Surname(String patient_Surname) {
        this.patient_Surname = patient_Surname;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_ID=" + patient_ID +
                ", patient_Name='" + patient_Name + '\'' +
                ", patient_Surname='" + patient_Surname + '\'' +
                '}';
    }

    Patient(int patient_ID, String patient_Name, String patient_Surname) {
        this.patient_ID = patient_ID;
        this.patient_Name = patient_Name;
        this.patient_Surname = patient_Surname;
    }
}
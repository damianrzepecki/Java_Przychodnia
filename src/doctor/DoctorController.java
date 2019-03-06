package doctor;

import callendar.CalendarController;
import callendar.Callendar;
import patient.PatientController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoctorController{
    private List<Doctor> doctors = new ArrayList<>();
    private CalendarController calCont = new CalendarController();
    private int doc_ID=0;
    private Callendar callendar = new Callendar();
    Set<String> reservation = new HashSet<>();
    private PatientController pT = new PatientController();

    public void newDoctor(String doctor_Name, String doctor_Surname) {
        Doctor doc = new Doctor(doc_ID, doctor_Name, doctor_Surname);
        doctors.add(doc);
        doc_ID++;
    }
    public void showDoctors(){
        for(Doctor doc : doctors){
            System.out.println(doc);
        }
    }
    private void addDay(int doc_ID, int dayOfWeek) {
        for(Doctor doc : doctors){
            if(doc.getDoc_ID() == doc_ID){
                doc.setDaysOfWork(dayOfWeek);
            }
        }
    }
    public void addWorkingHoursToSpecificDay(int doc_ID, int dayOfWeek, int hourStart, int hourEnd) {
        for(Doctor doc : doctors){
            if(doc.getDoc_ID() == doc_ID){
                addDay(doc_ID,dayOfWeek);
                if(doc.daysOfWork.contains(calCont.theDay(dayOfWeek))){
                    doc.setWorgingHoursADay(dayOfWeek,hourStart,hourEnd);
                }
            }
        }
    }
    public void getAllDaysDocIsWorking(int doc_ID) {
        for(Doctor doc : doctors){
            if (doc.getDoc_ID() == doc_ID){
                System.out.println(doc.getDoctorName() + " " + doc.getDoctorSurname() + " Pracuje w :" + doc.getHoursA_Day());
            }
        }
    }
// dodać warunek jeżeku puste
    public void getAllDoctorsWorkingInThatDay(int dayOfWeek) {
        System.out.println(calCont.theDay(dayOfWeek)+":");
        for(Doctor doc : doctors){
            if(doc.daysOfWork.contains(calCont.theDay(dayOfWeek))){
                System.out.println(" Pracuje " + doc.getDoctorName()+" "+doc.getDoctorSurname());
            }
        }
    }
    public void addPatientToDay(int patient_ID, int doc_ID, int day, int month, int year) {
        month --;
        for(Doctor doc : doctors) {
            if (doc.getDoc_ID() == doc_ID) {
                if(doc.daysOfWork.contains(callendar.getDayThan(day,month,year))){
                reservation.add(
                        (callendar.getDayThan(day,month,year)+" "+
                        doc.getDoctorName()+" "+
                        doc.getDoctorSurname()+" "+
                        pT.getPatientData(patient_ID)

                ));
                }
            }
        }
    }
    public void getReservation() {
        System.out.println(reservation);

    }
}

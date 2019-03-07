package doctor;

import callendar.Hours_Days;
import callendar.Callendar;
import patient.PatientController;

import java.util.*;

public class DoctorController {
    private List<Doctor> doctors = new ArrayList<>();
    private Hours_Days hoursDays;
    private int doc_ID = 0;
    private Callendar callendar = new Callendar();
    private PatientController pT;
    private Map<String, String> reservationFinal = new HashMap<>();


    public DoctorController(PatientController pT, Hours_Days hoursDays) {
        this.pT = pT;
        this.hoursDays = hoursDays;
    }

    public void newDoctor(String doctor_Name, String doctor_Surname) {
        Doctor doc = new Doctor(doc_ID, doctor_Name, doctor_Surname);
        doctors.add(doc);
        doc_ID++;
    }

    public void showDoctors() {
        for (Doctor doc : doctors) {
            System.out.println(doc);
        }
    }

    private void addDay(int doc_ID, int dayOfWeek) {
        for (Doctor doc : doctors) {
            if (doc.getDoc_ID() == doc_ID) {
                doc.setDaysOfWork(dayOfWeek);
            }
        }
    }

    public void addWorkingHoursToSpecificDay(int doc_ID, int dayOfWeek, int hourStart, int hourEnd) {
        for (Doctor doc : doctors) {
            if (doc.getDoc_ID() == doc_ID) {
                addDay(doc_ID, dayOfWeek);
                if (doc.daysOfWork.contains(hoursDays.theDay(dayOfWeek))) {
                    doc.setWorgingHoursADay(dayOfWeek, hourStart, hourEnd);
                    doc.setDocHours(hourStart, hourEnd);
                }
            }
        }
    }

    public void getAllDaysDocIsWorking(int doc_ID) {
        for (Doctor doc : doctors) {
            if (doc.getDoc_ID() == doc_ID) {
                System.out.println(doc.getDoctorName() + " " + doc.getDoctorSurname() + " Pracuje w :" + doc.getHoursA_Day());
            }
        }
    }

    // dodać warunek jeżeku puste
    public void getAllDoctorsWorkingInThatDay(int dayOfWeek) {
        System.out.println(hoursDays.theDay(dayOfWeek) + ":");
        for (Doctor doc : doctors) {
            if (doc.daysOfWork.contains(hoursDays.theDay(dayOfWeek))) {
                System.out.println(" Pracuje " + doc.getDoctorName() + " " + doc.getDoctorSurname());
            }
        }
    }

    public void addPatientToDay(int patient_ID, int doc_ID, int day, int month, int year, int hour) {
        month--;
        for (Doctor doc : doctors) {
            if (doc.getDoc_ID() == doc_ID) {
                if (doc.daysOfWork.contains(callendar.getDayThan(day, month, year))) {
                    if (doc.getDocHours().containsKey(hour)) {
                        String reservationKey = day + "-" + (month + 1) + "-" + year + ": " + callendar.getDayThan(day, month, year) + "-" + doc.getDoctorName() + " " + doc.getDoctorSurname() + " " + doc.getDocHours().get(hour);
                        String reservationValue = pT.addPatientToDoctor(patient_ID);
                        reservationFinal.put(reservationKey, reservationValue);
                    }
                }
            }
        }
    }

    public void getReservation() {
        reservationFinal.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(System.out::println);

    }
}
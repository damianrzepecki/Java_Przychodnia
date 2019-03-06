package doctor;

import callendar.CalendarController;
import java.util.*;


public class Doctor {
    private int doc_ID;
    private String doctorName;
    private String doctorSurname;
    private List<String> hoursA_Day = new ArrayList<>();
    private CalendarController calCont = new CalendarController();
    private StringBuilder sB = new StringBuilder();
    List<String> daysOfWork = new ArrayList<>();

    public List<String> getDaysOfWork() {
        return daysOfWork;
    }
    int getDoc_ID() {
        return doc_ID;
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "Doc_ID=" + doc_ID +
                ", DoctorName='" + doctorName + '\'' +
                ", DoctorSurname='" + doctorSurname + '\'' +
                ", DaysOfWork=" + hoursA_Day  +
                "}";
    }
    Doctor(int doc_ID, String doctorName, String doctorSurname) {
        this.doc_ID = doc_ID;
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
    }
    public int getNumber() {
        return doc_ID;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public String getDoctorSurname() {
        return doctorSurname;
    }
    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }
    public List<String> daysOfWork() {
        return daysOfWork;
    }
    void setDaysOfWork(int day) {
        if(!daysOfWork.contains(calCont.theDay(day))){
            this.daysOfWork.add(calCont.theDay(day));
        }
    }
    public List<String>hoursA_Day(){
        return hoursA_Day;
    }
    private String hourRange(int dayOfWeek, int hStart, int hEnd){
        sB.delete(0, sB.length());
        sB.append(calCont.theDay(dayOfWeek));
        sB.append(": ");
        sB.append(calCont.getHoursAday(hStart));
        sB.append(" - ");
        sB.append(calCont.getHoursAday(hEnd));
        return sB.toString();
    }
    void setWorgingHoursADay(int dayOfWeek, int hourStart, int hourEnd) {
        this.hoursA_Day.add(hourRange(dayOfWeek,hourStart,hourEnd));
    }
    public List<String> getHoursA_Day() {
        return hoursA_Day;
    }
}

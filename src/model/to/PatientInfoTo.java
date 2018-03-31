package model.to;

import java.sql.Date;

public class PatientInfoTo {

    private int patient_id;
    private String patient_name;
    private String contact_no;
    private String attendent;
    private Date date_of_birth;
    private String address;

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getAttendent() {
        return attendent;
    }

    public void setAttendent(String attendent) {
        this.attendent = attendent;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return patient_id + "." + patient_name;
    }
}

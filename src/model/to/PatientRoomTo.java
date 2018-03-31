package model.to;

import java.sql.Date;

public class PatientRoomTo {

    private int proom_id;   
    private int patient_id;
    private String room_id;
    private Date admit_date;
    private Date discharge_date;
    private float amount;
    private String ispaid;

    public int getProom_id() {
        return proom_id;
    }

    public void setProom_id(int proom_id) {
        this.proom_id = proom_id;
    }

    public Date getDischarge_date() {
        return discharge_date;
    }

    public void setDischarge_date(Date discharge_date) {
        this.discharge_date = discharge_date;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public Date getAdmit_date() {
        return admit_date;
    }

    public void setAdmit_date(Date admit_date) {
        this.admit_date = admit_date;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getIspaid() {
        return ispaid;
    }

    public void setIspaid(String ispaid) {
        this.ispaid = ispaid;
    }

}

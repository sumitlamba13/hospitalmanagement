package model.to;

public class RoomTypeTo {
    private String type_id;
    private String type_name;
    private float charges;

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public float getCharges() {
        return charges;
    }

    public void setCharges(float charges) {
        this.charges = charges;
    }

    public String toString(){
        return type_name + "[Rs. " + charges + " ]";
    }
    
}

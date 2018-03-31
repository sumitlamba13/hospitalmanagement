package model.to;

public class FloorInfoTo {
    private String floor_id;
    private String floor_type;

    public String getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(String floor_id) {
        this.floor_id = floor_id;
    }

    public String getFloor_type() {
        return floor_type;
    }

    public void setFloor_type(String floor_type) {
        this.floor_type = floor_type;
    }

    public String toString(){
        return floor_type;
    }
    
}

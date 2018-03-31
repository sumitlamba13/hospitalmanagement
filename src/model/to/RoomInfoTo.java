package model.to;

public class RoomInfoTo {

    private String room_no;
    private String floor_id;
    private String floor_name;
    private String room_type;
    private String type_name;
    private int no_of_bed;

    public String getFloor_name() {
        return floor_name;
    }

    public void setFloor_name(String floor_name) {
        this.floor_name = floor_name;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(String floor_id) {
        this.floor_id = floor_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public int getNo_of_bed() {
        return no_of_bed;
    }

    public void setNo_of_bed(int no_of_bed) {
        this.no_of_bed = no_of_bed;
    }

    public String toString() {
        return room_no;
    }
}

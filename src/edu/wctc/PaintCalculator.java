package edu.wctc;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class PaintCalculator implements Serializable {
    private ArrayList<Room> roomList = new ArrayList<>();

    public void addRoom(double length, double width, double height){
        Room r = new Room(width, height, length);
        roomList.add(r);
    }

    public String toString(){
        String roomAreas = "";
        if (roomList.size()==0){
            return "No rooms are available";
        }
        else {
            for (Room i : roomList){
                roomAreas = roomAreas + i.toString() + " ";
            }
            return roomAreas;
        }
    }

}

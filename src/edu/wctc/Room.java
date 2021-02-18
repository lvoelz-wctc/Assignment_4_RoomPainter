package edu.wctc;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Room implements Serializable{

    private ArrayList<Wall> wallList = new ArrayList<>();

    //constructor
    public Room(double width, double height, double length){
        Wall wallOne = new Wall(width, height);
        Wall wallTwo = new Wall(width, height);
        Wall wallThree = new Wall(length, height);
        Wall wallFour = new Wall(length, height);

        wallList.add(wallOne);
        wallList.add(wallTwo);
        wallList.add(wallThree);
        wallList.add(wallFour);
    }

    public double getArea(){
        double roomArea = 0;
        for (Wall i : wallList){
            roomArea = (roomArea + i.getArea());
        }
        return roomArea;
    }

    public String toString(){
        return String.valueOf(getArea());
    }
}

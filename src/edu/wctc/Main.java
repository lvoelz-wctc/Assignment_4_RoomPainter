package edu.wctc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintcalculator = new PaintCalculator();
    private static boolean loop;

    private static void printMenu(){
        //prints menu options

        System.out.println("Choose your option:");
        System.out.println("A. Add Room."); //call promptForDimension, which calls createRoom
        System.out.println("V. View Room.");
        System.out.println("R. Read Rooms from file.");
        System.out.println("W. Write rooms to file.");
        System.out.println("E. Exit program.");
    }

    private static double promptForDimension(String dimensionName){
        if (dimensionName.equals("length")){
            System.out.println("Enter a length: ");
        }
        else if (dimensionName.equals("width")){
            System.out.println("Enter a width: ");
        }
        else if (dimensionName.equals("height")){
            System.out.println("Enter a height: ");
        }
        return Double.parseDouble(keyboard.nextLine());
    }

    private static void createRoom(){
        double length = promptForDimension("length");
        double width = promptForDimension("width");
        double height = promptForDimension("height");

        paintcalculator.addRoom(length, width, height);
        System.out.println("Room created successfully");
    }

    private static void readFile(){
        //reads a file.
    }

    private static void writeFile() throws IOException {
        //writes paint calculator field to a file. exception handling to print an error if unwriteable.
    }


    public static void main(String[] args) {
    do {
        printMenu();

        String response = keyboard.nextLine();
        if (response.equals("A")){
            createRoom();
        }
        else if (response.equals("V")){
            System.out.println(paintcalculator.toString());
        }
        else if (response.equals("R")){
            System.out.println("Read rooms");
        }
        else if (response.equals("W")){
            System.out.println("Write rooms");
        }
        else if (response.equals("E")){
            loop = false;
        }
    }
    while (loop == true);//end do while loop

    }
}

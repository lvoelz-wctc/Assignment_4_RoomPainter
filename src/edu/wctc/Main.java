package edu.wctc;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintcalculator = new PaintCalculator();
    private static boolean loop = true;

    private static void printMenu(){
        //prints menu options

        System.out.println("Choose your option:");
        System.out.println("1. Add Room.");
        System.out.println("2. View Room.");
        System.out.println("3. Read Rooms from file.");
        System.out.println("4. Write rooms to file.");
        System.out.println("5. Exit program.");
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
        // Read the binary file into paintcalculator
        try (
                FileInputStream fis = new FileInputStream("paintcalculator.obj");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            paintcalculator = (PaintCalculator)ois.readObject();
            System.out.println("Rooms read from file.");
        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Can't read file.");
        }

    }

    private static void writeFile() throws IOException {
        // Write object list as binary file
        try (
                FileOutputStream fos = new FileOutputStream("paintcalculator.obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(paintcalculator);
            System.out.println("Rooms written to file.");
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Can't write file.");
        }
    }


    public static void main(String[] args) throws IOException {
    do {
        printMenu();

        String response = keyboard.nextLine();
        if (response.equals("1")){
            createRoom();
        }
        else if (response.equals("2")){
            System.out.println(paintcalculator.toString());
        }
        else if (response.equals("3")){
            readFile();
        }
        else if (response.equals("4")){
            writeFile();
        }
        else if (response.equals("5")){
            loop = false;
        }
    }
    while (loop == true);//end do while loop

    }
}

package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author olga
 */
public class Main
{

    public static void main(String[] args) throws Exception
    {
        String plate;
        String brand;
        String color;
        String wheelBrandB;
        double diameterB;
        String wheelBrandF;
        double diameterF;
        List<Wheel> frontWheels = new ArrayList<Wheel>();;
        List<Wheel> backWheels = new ArrayList<Wheel>();;

        Scanner sc = new Scanner(System.in);

        System.out.println("Diga'm la matrícula del cotxe");
        plate = sc.nextLine();
        System.out.println("Diga'm la marca");
        brand = sc.nextLine();
        System.out.println("Diga'm el color");
        color = sc.nextLine();

        Car newCar = new Car(plate, brand, color);

        System.out.println("Diga'm la marca de les rodes posteriors");
        wheelBrandB = sc.nextLine();

        diameterB = checkDiameter("posteriors", sc);

        Wheel backWheel = new Wheel(wheelBrandB, diameterB);
        backWheels = listingWheels(backWheel);

        System.out.println("Diga'm la marca de les rodes davanteres");
        wheelBrandF = sc.next();

        diameterF = checkDiameter("davanteres", sc);

        Wheel frontWheel = new Wheel(wheelBrandF, diameterF);
        frontWheels = listingWheels(frontWheel);

        newCar.addWheels(frontWheels, backWheels);

        System.out.println("marca: " + newCar.getBrand()
                + " color: " + newCar.getColor()
                + "\n matricula: " + newCar.getPlate()
                + "\n roda1 marca: " + newCar.getWheels().get(0).getBrand()
                + " diametre: " + newCar.getWheels().get(0).getDiameter()
                + "\n roda2 marca: " + newCar.getWheels().get(1).getBrand()
                + " diametre: " + newCar.getWheels().get(1).getDiameter()
                + "\n roda3 marca: " + newCar.getWheels().get(2).getBrand()
                + " diametre: " + newCar.getWheels().get(2).getDiameter()
                + "\n roda4 marca: " + newCar.getWheels().get(3).getBrand()
                + " diametre: " + newCar.getWheels().get(3).getDiameter());
    }

    private static double checkDiameter(String wheelPosition, Scanner sc)
    {
        boolean diamIsCorrect = false;
        double diameter = 0;

        while (!diamIsCorrect)
        {
            try
            {
                System.out.println("Diga'm el diàmetre de les rodes "
                        + wheelPosition);
                diameter = sc.nextDouble();
                diamIsCorrect = true;
            } catch (Exception e)
            {
                diamIsCorrect = false;
                System.out.println("Ha de ser un número");
                sc.next();
            }
        }

        return diameter;

    }

    private static List<Wheel> listingWheels(Wheel wheel)
    {
        List<Wheel> wheelsList = new ArrayList<Wheel>();
        wheelsList.add(wheel);
        wheelsList.add(wheel);
        return wheelsList;
    }
}

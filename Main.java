package com.vehicles.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

        plate = checkPlate(sc);
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

    private static double checkDiameter(String wheelPosition, Scanner sc) throws Exception
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

                if (diameter > 0.4 && diameter < 4)
                {
                    diamIsCorrect = true;
                } else
                {
                    //System.out.println("error");
                    throw new IOException();

                }

            } catch (IOException e)
            {
                diamIsCorrect = false;
                System.out.println("Ha de ser un número, superior a 0.4 i inferior a 4");

            } catch (InputMismatchException e)
            {
                diamIsCorrect = false;
                System.out.println("Ha de ser un número, superior a 0.4 i inferior a 4");
                sc.next();
            }

        }

        return diameter;

    }

    private static String checkPlate(Scanner sc) throws Exception
    {
        boolean plateIsCorrect = false;
        String plate = null;
        int numLetters = 0;
        int numDigits = 0;

        while (!plateIsCorrect)
        {
            try
            {
                System.out.println("Diga'm la matrícula del cotxe");
                plate = sc.nextLine();

                if (plate.length() < 6 || plate.length() > 7)
                {
                    throw new IOException();
                }

                for (int i = 0; i < 4; i++)
                {
                    Character c = plate.charAt(i);
                    if (Character.isDigit(c))
                    {
                        numDigits++;
                    } else
                    {
                        throw new IOException();
                    }
                }

                if (numDigits < 4)
                {
                    throw new IOException();
                }

                for (int i = 4; i < plate.length(); i++)
                {
                    Character c = plate.charAt(i);
                    if (Character.isLetter(c))
                    {
                        numLetters++;
                    } else
                    {
                        throw new IOException();
                    }
                }

                if (numLetters < 2 && numLetters > 4)
                {
                    throw new IOException();
                } else
                {
                    plateIsCorrect = true;
                }

            } catch (IOException e)
            {
                plateIsCorrect = false;
                System.out.println("La matrícula han de ser 4 lletres i 2-3 números");
            }
        }
        return plate;
    }

    private static List<Wheel> listingWheels(Wheel wheel)
    {
        List<Wheel> wheelsList = new ArrayList<Wheel>();
        wheelsList.add(wheel);
        wheelsList.add(wheel);
        return wheelsList;
    }
}

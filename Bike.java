package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle
{

    public Bike(String plate, String brand, String color)
    {
        super(plate, brand, color);
    }

    public String getPlate()
    {
        return plate;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getColor()
    {
        return color;
    }

    public List<Wheel> getWheels()
    {
        return wheels;
    }

    public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception
    {
        addOneWheel(frontWheels);
        addOneWheel(backWheels);
    }

    public void addOneWheel(List<Wheel> wheels) throws Exception
    {
        if (wheels.size() != 1)
        {
            throw new Exception();
        }

        Wheel wheel = wheels.get(0);

        this.wheels.add(wheel);
    }

}

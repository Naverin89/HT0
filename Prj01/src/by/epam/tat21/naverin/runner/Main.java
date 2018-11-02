package by.epam.tat21.naverin.runner;

import by.epam.tat21.naverin.exceptions.IlluminanceTooMuchException;
import by.epam.tat21.naverin.exceptions.SpaceUsageTooMuchException;
import by.epam.tat21.naverin.furniture.*;
import by.epam.tat21.naverin.items.LightBulb;
import by.epam.tat21.naverin.model.Building;
import by.epam.tat21.naverin.model.Room;

public class Main {
    public static void main(String[] args) {
        try {
            Building bld = new Building("Building 1");
            bld.addRoom(new Room("Room 1", 80, 1));
            bld.getRoom("Room 1").addFurniture(new Table("Table 1", 2));
            bld.getRoom("Room 1").addFurniture(new Bed("Bed 1", 2));
            bld.getRoom("Room 1").addFurniture(new Chair("Chair 1", 2));
            bld.getRoom("Room 1").addFurniture(new Chair("Chair 2", 3));
            bld.getRoom("Room 1").addBulbs(new LightBulb(200));

            bld.addRoom(new Room("Room 2", 90, 3));
            bld.getRoom("Room 2").addFurniture(new Table("Table 2", 6));
            bld.getRoom("Room 2").addFurniture(new Bed("Bed 2", 3));
            bld.getRoom("Room 2").addFurniture(new Chair("Chair 3", 1, 2));
            bld.getRoom("Room 2").addFurniture(new Chair("Chair 4", 2, 5));
            bld.getRoom("Room 2").addBulbs(new LightBulb(300));
            bld.getRoom("Room 2").addBulbs(new LightBulb(600));

            bld.addRoom(new Room("Room 3", 30, 2));
            bld.getRoom("Room 3").addFurniture(new Table("Table 3", 6));
            bld.getRoom("Room 3").addFurniture(new Bed("Bed 3", 2));
            bld.getRoom("Room 3").addFurniture(new Chair("Chair 5", 1,3));
            bld.getRoom("Room 3").addBulbs(new LightBulb(300));
            bld.getRoom("Room 3").addBulbs(new LightBulb(400));
            bld.getRoom("Room 3").addBulbs(new LightBulb(230));

            System.out.println(bld.validation());
            System.out.println(bld.describe());

        } catch (SpaceUsageTooMuchException e) {
            System.out.println(e);
        } catch (IlluminanceTooMuchException e) {
            System.out.println(e);
        }


    }

}

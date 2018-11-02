package by.epam.tat21.naverin.furniture;

import by.epam.tat21.naverin.items.iItem;

public class Bed extends AbstractFurnitureModel implements iItem {
    public Bed(String name, double maxArea){
        super(name,maxArea);

    }

    @Override
    public String toString() {
        return "Bed " + super.toString();
    }
}

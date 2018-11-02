package by.epam.tat21.naverin.furniture;

import by.epam.tat21.naverin.items.iItem;

public class Table extends AbstractFurnitureModel implements iItem {
    public Table(String name, double maxArea){
        super(name,maxArea);
    }

    @Override
    public String toString() {
        return "Table " + super.toString();
    }
}

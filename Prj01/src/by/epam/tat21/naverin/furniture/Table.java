package by.epam.tat21.naverin.furniture;

public class Table extends AbstractFurnitureModel {
    public Table(String name, double maxArea){
        super(name,maxArea);
    }

    @Override
    public String toString() {
        return "Table " + super.toString();
    }
}

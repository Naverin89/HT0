package by.epam.tat21.naverin.furniture;

public class Bed extends AbstractFurnitureModel {
    public Bed(String name, double maxArea){
        super(name,maxArea);

    }

    @Override
    public String toString() {
        return "Bed " + super.toString();
    }
}

package by.epam.tat21.naverin.furniture;

public class Chair extends AbstractFurnitureModel {

    public Chair(String name, double maxArea){
        super(name,maxArea);
    }

    public Chair(String name, double minArea, double maxArea){
        super(name,minArea,maxArea);
    }

    @Override
    public String toString() {
        return "Chair " + super.toString();
    }
}

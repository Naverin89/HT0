package by.epam.tat21.naverin.furniture;

/**
 * This class represent parent for all furniture items
 */

public class AbstractFurnitureModel {
    private String name;
    private double minArea;
    private double maxArea;

    //this constructor take place if areas is the same
    public AbstractFurnitureModel(String name, double maxArea) {
        this.name = name;
        this.maxArea = maxArea;
        this.minArea = maxArea;
    }

    //checking for min and max area of furniture (or if it's doubleAread)
    public AbstractFurnitureModel(String name, double minArea, double maxArea) {
        this.name = name;
        if (minArea <= 0) {
            System.out.println("Area of a furniture can't be 0 or negative value. Default value (0.5) m2 will set as an area  ");
            this.minArea = 0.5;
        } else {
            this.minArea = minArea <= maxArea ? minArea : maxArea;
        }
        if (maxArea <= 0) {
            System.out.println("Area of a furniture can't be 0 or negative value. Default value (0.5) m2 will set as an area  ");
            this.maxArea = 0.5;
        } else {
            this.maxArea = maxArea >= minArea ? maxArea : minArea;
        }
    }

    public String getName() {
        return name;
    }

    public double getMinArea() {
        return minArea;
    }

    public double getMaxArea() {
        return maxArea;
    }

    @Override
    public String toString() {
        if (maxArea == minArea) {
            return name + "(has area of " + maxArea + " m2)";
        } else {
            return name + "(has area of " + minArea + " m2 to " + maxArea + " m2)";
        }
    }

}

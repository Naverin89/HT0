package by.epam.tat21.naverin.model;

import by.epam.tat21.naverin.exceptions.IlluminanceTooMuchException;
import by.epam.tat21.naverin.exceptions.SpaceUsageTooMuchException;
import by.epam.tat21.naverin.furniture.AbstractFurnitureModel;
import by.epam.tat21.naverin.items.LightBulb;

import java.util.ArrayList;
import java.util.List;

public class Room {
    public static final int MIN_ILLUMINATION = 300;
    public static final int MAX_ILLUMINATION = 4000;
    public static final int WINDOW_ILLUMINATION = 700;
    public static final double ALLOWED_AREA = 0.7;


    private String roomName;

    private boolean valid = false;

    private int windowsAmount;

    private double roomArea;
    private double maxAllowedArea;
    private double roomIlluminance;
    private double minFurnitureArea = 0;
    private double maxFurnitureArea = 0;


    private List<AbstractFurnitureModel> furnitureList;
    private List<LightBulb> bulbsList;

    public Room(String roomName, double roomArea, int windowsAmount) {
        this.roomName = roomName;
        this.roomArea = roomArea;
        this.maxAllowedArea = roomArea * ALLOWED_AREA;
        this.windowsAmount = windowsAmount;
        this.furnitureList = new ArrayList<>();
        this.bulbsList = new ArrayList<>();
    }


    public String getRoomName() {
        return roomName;
    }

    public double getRoomArea() {
        return roomArea;
    }

    public int getWindowsAmount() {
        return windowsAmount;
    }

    public List<AbstractFurnitureModel> getFurniture() {
        return furnitureList;
    }

    public List<LightBulb> getBulbs() {
        return bulbsList;
    }

    public double getRoomIlluminance() {
        double windowLux = windowsAmount * WINDOW_ILLUMINATION;
        double bulbsLux = 0;
        for (LightBulb bulb : this.getBulbs()) {
            bulbsLux += bulb.getLux();
        }
        this.roomIlluminance = windowLux + bulbsLux;
        return this.roomIlluminance;
    }

    public void addFurniture(AbstractFurnitureModel furniture) throws SpaceUsageTooMuchException {

        minFurnitureArea += furniture.getMinArea();
        maxFurnitureArea += furniture.getMaxArea();
        if (maxFurnitureArea > maxAllowedArea) {
            throw new SpaceUsageTooMuchException("Furniture" + furniture.getName() + " doesn't fit to this room anymore ");
        }
        furnitureList.add(furniture);
    }

    public void removeFurniture(AbstractFurnitureModel furniture) {
        furnitureList.remove(furniture);
    }

    public AbstractFurnitureModel getFurniture(String furnName) {
        for (AbstractFurnitureModel furnElm : this.getFurniture()) {
            if (furnElm.getName().equals(furnName)) {
                return furnElm;
            }
        }
        return null;
    }

    public void addBulbs(LightBulb bulb) throws IlluminanceTooMuchException {
        double totalLux = this.roomIlluminance + bulb.getLux();
        if (totalLux > MAX_ILLUMINATION) {
            throw new IlluminanceTooMuchException("Bulb with " + bulb.getLux() + " will be redundant");
        }
        bulbsList.add(bulb);
    }

    public void removeBulb(LightBulb bulb) {
        bulbsList.remove(bulb);
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(roomName).append(":\n");
        sb.append("\t\tIllumination = ").append(this.getRoomIlluminance());
        sb.append(" (" + this.windowsAmount).append(" windows for 700 lux, light bulbs for ");
        for (LightBulb bulb : this.getBulbs()) {
            if (bulb.equals(this.getBulbs().get(getBulbs().size() - 1))) {
                sb.append(bulb.getLux()).append(" lux)\n ");
            } else {
                sb.append(bulb.getLux()).append(" lux, ");
            }

        }
        sb.append("\t\tArea  = ").append(this.getRoomArea()).append(" m^2 (occupied area ");
        double minArea = this.minFurnitureArea;
        double maxArea = this.maxFurnitureArea;
        if (minArea == maxArea) {
            sb.append(maxArea).append(" m^2, ");
        } else {
            sb.append(minArea).append("-").append(maxArea).append(" m^2, ");
        }
        sb.append("guaranted free ");
        double freeSpace = this.roomArea - maxArea;
        double freePerc = 100. - (maxArea / this.roomArea) * 100;
        String perc = String.format("%.2f", freePerc);
        sb.append(freeSpace).append(" m2 or ").append(perc).append("% of room area)\n");
        if (this.getFurniture().size() != 0) {
            sb.append("\t\t\t Furniture:\n");
            for (AbstractFurnitureModel furn : this.getFurniture()) {
                sb.append("\t\t\t\t").append(furn).append("\n");
            }
        } else {
            sb.append("\t\t\t Furniture:\n\t\t\t None");
        }
        return sb.toString();

    }

}

package by.epam.tat21.naverin.model;

import java.util.ArrayList;
import java.util.List;

public class Building implements IValidation {
    private boolean valid = false;
    private String builingName;
    private List<Room> rooms;

    public Building(String builingName) {
        this.builingName = builingName;
        this.rooms = new ArrayList<>();
    }

    public String getBuilingName() {
        return this.builingName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoom(String name) {
        for (Room room : this.getRooms()) {
            if (room.getRoomName().equals(name)) {
                return room;
            }
        }
        return null;
    }


    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.builingName).append(":\n");
        for (Room room : this.getRooms()) {
            sb.append("\t").append(room.toString());
        }
        return sb.toString();
    }

    @Override
    public String validation() {
        int troubleCount = 0;
        StringBuilder sbval = new StringBuilder();
        for (Room room : rooms) {
            if (room.getRoomIlluminance() < room.MIN_ILLUMINATION) {
                troubleCount++;
                sbval.append("Illumination of the ").append(room.getRoomName()).append("is ").append(room.getRoomIlluminance()).append(", that is less than minimum allowed illumination. Add more light bulbs!");

            } else if (room.getRoomName() == null) {
                troubleCount++;
                sbval.append("Room doesn't have any name! Name it!");
            } else if (room.getRoomIlluminance() > room.MAX_ILLUMINATION) {
                troubleCount++;
                sbval.append("Illumination of the ").append(room.getRoomName()).append(" is ").append(room.getRoomIlluminance()).append(", that is more than maximum allowed illumination. Remove light bulbs for ").append(room.getRoomIlluminance() - room.MAX_ILLUMINATION).append(" lux!");
            }

        }
        if (troubleCount == 0) {
            sbval.append("Building is valid!");
        } else {
            sbval.append("\nBuilding isn't valid! There is/are ").append(troubleCount).append(" problem/s");
        }
        return sbval.toString();
    }
}

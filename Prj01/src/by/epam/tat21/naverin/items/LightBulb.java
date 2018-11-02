package by.epam.tat21.naverin.items;

public class LightBulb implements  iItem{
    private int lux;

    public LightBulb(int lux){
        if (lux<1){
            System.out.println("Minimal value of lux for light bulb is 1. Its value \"1 lux\" will be applied as value ");
       this.lux=1;
        }else {
            this.lux = lux;
        }
    }

    public int getLux(){
        return lux;
    }

    @Override
    public String toString() {
        return "Light bulb lux = " + lux;
    }
}

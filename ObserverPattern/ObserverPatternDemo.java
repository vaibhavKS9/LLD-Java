package ObserverPattern;
import java.util.*;


// OBSERVER
abstract class Display{
    public int num;
    public abstract void displayNum();
    public abstract void update(int num);
}

// CONCRETE OBSERVERS

class BinaryDisplay extends Display {
    public BinaryDisplay(int num){
        this.num=num;
    }
    public BinaryDisplay(){
    }
    @Override
    public void displayNum(){
        System.out.println("BinaryDisplay "+Integer.toBinaryString(this.num));
    }
    @Override
    public void update(int num){
        this.num=num;
    }
}


class HexadecimalDisplay extends Display {
    public HexadecimalDisplay(int num){
        this.num=num;
    }
    public HexadecimalDisplay(){
    }
    @Override
    public void displayNum(){
        System.out.println("HexadecimalDisplay "+Integer.toHexString(this.num));
    }
    @Override
    public void update(int num){
        this.num=num;
    }
}


// SUBJECT OBSERVER MANAGER

class DisplayStation {
    private final List<Display>displays;
    private int num;

    public DisplayStation(){
        this.displays=new ArrayList<>();
    }

    public void addDisplay(Display display){
        displays.add(display);
    }

    public void setNum(int num){
        this.num=num;
        notifyObservers();
    }

    public void notifyObservers(){
        for(Display display:this.displays){
            display.update(this.num);
        }
    }

    public void displayNum(){
        for(Display display:this.displays){
            display.displayNum();
        }
    }

}


public class ObserverPatternDemo {
    
    public static void main(String[] args){
        Display display=new BinaryDisplay();
        Display display2=new HexadecimalDisplay();
        DisplayStation monitor=new DisplayStation();

        monitor.addDisplay(display);
        monitor.addDisplay(display2);
        monitor.setNum(10);
        monitor.displayNum();
        monitor.setNum(1124);
        monitor.displayNum();

    }

}

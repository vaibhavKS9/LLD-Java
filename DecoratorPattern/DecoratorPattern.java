package DecoratorPattern;

interface Coffee{
    int getPrice();
    String getDescription();
}

// base decorator

class SimpleCoffee implements Coffee{
    @Override
    public int getPrice(){
        return 10;
    }
    @Override
    public String getDescription(){
        return "Milk";
    }
}

abstract class Decorator implements Coffee{
    protected Coffee coffee;
    public Decorator(Coffee coffee){
        this.coffee=coffee;
    }
    public int getPrice(){
        return coffee.getPrice();
    }
    public String getDescription(){
        return coffee.getDescription();
    }
    
} 

// concrete decorator (extra features)
class ChocolateDecorator extends Decorator{
    public ChocolateDecorator(Coffee coffee){
        super(coffee);
    }
    public int getPrice(){
        return super.getPrice()+20;
    }
    public String getDescription(){
        return super.getDescription()+"Chocolate";
    }
}

class CaramelDecorator extends Decorator{
    public CaramelDecorator(Coffee coffee){
        super(coffee);
    }
    public int getPrice(){
        return super.getPrice()+30;
    }
    public String getDescription(){
        return super.getDescription()+"Caramel";
    }
}



public class DecoratorPattern {
    public static void main(String[] args) {

        Coffee customCoffee = new ChocolateDecorator(
            new CaramelDecorator(
                new ChocolateDecorator(new SimpleCoffee())
            )
        );
        System.out.println("price "+customCoffee.getPrice());
        System.out.println("description "+customCoffee.getDescription());


    }
}
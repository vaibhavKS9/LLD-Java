

package FactoryPattern;


abstract class Vehicle{
    public abstract void printVehicleType();
}

class Car extends Vehicle {

    @Override
    public void printVehicleType(){
        System.out.println("This is a Car");
    }
}

class Bike extends Vehicle {

    @Override
    public void printVehicleType(){
        System.out.println("This is a Bike");
    }
}

abstract class Factory {
    public abstract Vehicle produceVehicle();
}

class CarFactory extends Factory {
    
    @Override
    public Vehicle produceVehicle(){
        return new Car();
    }
}

class BikeFactory extends Factory {
    
    @Override
    public Vehicle produceVehicle(){
        return new Bike();
    }
}




public class FactoryPatternDemo {
    public static void main(String[] args){
        
        Factory carFactory=new CarFactory();
        Factory bikeFactory=new BikeFactory();

        Vehicle vehicle1=carFactory.produceVehicle();
        Vehicle vehicle2=bikeFactory.produceVehicle();

        vehicle1.printVehicleType();
        vehicle2.printVehicleType();

        
    }
}

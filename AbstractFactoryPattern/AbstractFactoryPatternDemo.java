package AbstractFactoryPattern;

// Products
abstract class Cpu {
    public abstract void printCpuSpecs();
}

abstract class Gpu {
    public abstract void printGpuSpecs();
}

class AmdCpu extends Cpu {
    @Override
    public void printCpuSpecs(){
        System.out.println("This is Amd Cpu");
    }
}
class IntelCpu extends Cpu {
    @Override
    public void printCpuSpecs(){
        System.out.println("This is Intel Cpu");
    }
}

class QualcommGpu extends Gpu {
    @Override
    public void printGpuSpecs(){
        System.out.println("This is Qualcomm Gpu");
    }
}

class NvidiaGpu extends Gpu {
    @Override
    public void printGpuSpecs(){
        System.out.println("This is Nvidia Gpu");
    }
}




// Abstract Factory
abstract class LaptopFactory {

    public abstract Gpu createGpu();
    public abstract Cpu createCpu();
}

// Concrete Factories (families)

class AbcCorp extends LaptopFactory{

    @Override
    public Gpu createGpu(){
        return new NvidiaGpu();
    }

    @Override
    public Cpu createCpu(){
        return new AmdCpu();
    }
}

class BcdCorp extends LaptopFactory{
    @Override
    public Gpu createGpu(){
        return new QualcommGpu();
    }

    @Override
    public Cpu createCpu(){
        return new IntelCpu();
    }
}

// Client/Product that uses the factory

class Laptop {
    private final Gpu gpu;
    private final Cpu cpu;
    public Laptop(LaptopFactory factory){
        this.gpu=factory.createGpu();
        this.cpu=factory.createCpu();
    }
    public void printLaptopSpecs(){
        this.cpu.printCpuSpecs();
        this.gpu.printGpuSpecs();
    }
}



public class AbstractFactoryPatternDemo {
    
    public static void main(String[] args){
        LaptopFactory factory1=new AbcCorp();
        LaptopFactory factory2=new BcdCorp();
        Laptop laptop1=new Laptop(factory1);
        Laptop laptop2=new Laptop(factory2);
        System.out.println("Laptop1Specs");
        laptop1.printLaptopSpecs();
        System.out.println("Laptop2Specs");
        laptop2.printLaptopSpecs();

    }

}

package SingletonPattern;


class Singleton {
    private static Singleton instance;
    private Singleton(){
        System.out.println("Creating a new Instance");
    }
    public static Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }else{
            System.out.println("Instance already created. Fetching the singleton instance");
        }
        return instance;
        
    }

    public static void doSomething(){
        System.out.println("Doing something");
    }
}


public class SingletonPatternDemo {
    
    public static void main(String[] args){

        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        

    }

}

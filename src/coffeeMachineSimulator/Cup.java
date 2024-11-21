package coffeeMachineSimulator;

public class Cup {
    private final  static int water=200;
    private static int milk=50;
    private  static int bean=15;

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBean() {
        return bean;
    }
    public void show(){
        System.out.println("Bean:"+this.bean+"Milk:"+this.getMilk()+"water:"+this.getWater());
    }


}

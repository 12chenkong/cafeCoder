package coffeeMachineSimulator.coffee_type;

public class Cup {
    private  int water;
    private  int milk;
    private  int bean;
    private  int cost;

    public Cup(){}
    public Cup(int water,int milk,int bean,int cost){
        this.water=water;
        this.milk=milk;
        this.bean=bean;
        this.cost=cost;
    }

    public int getCost() {
        return cost;
    }

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

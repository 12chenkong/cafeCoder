package coffeeMachineSimulator;

public class MachineCapacity {
    private static int totalWater;
    private static int totoalBean;
    private static int totalMilk;
    private static int totalMoney;
    private static int disposableCups;

    private static int priciple;


    public MachineCapacity(){}
    public MachineCapacity(int totalWater, int totoalBean, int totalMilk,int totalMoney,int disposableCups) {
        this.totalWater = totalWater;
        this.totoalBean = totoalBean;
        this.totalMilk = totalMilk;
        this.totalMoney=totalMoney;
        this.priciple=totalMoney;
        this.disposableCups=disposableCups;

    }

    public static int getTotalMoney() {
        return totalMoney;
    }

    public static void setTotalMoney(int totalMoney) {
        MachineCapacity.totalMoney = totalMoney;
    }

    public static int getDisposableCups() {
        return disposableCups;
    }

    public static void setDisposableCups(int disposableCups) {
        MachineCapacity.disposableCups = disposableCups;
    }

    public static void setTotalWater(int totalWater) {
        MachineCapacity.totalWater = totalWater;
    }

    public static void setTotoalBean(int totoalBean) {
        MachineCapacity.totoalBean = totoalBean;
    }

    public static void setTotalMilk(int totalMilk) {
        MachineCapacity.totalMilk = totalMilk;
    }

    public static void machineInfo(boolean is_true){
        System.out.println("The coffee machine has:");
        System.out.println(getTotalWater()+" ml of water");
        System.out.println(getTotalMilk()+" ml of milk");
        System.out.println(getTotoalBean()+" ml of beans");
        System.out.println(getDisposableCups()+" disposable cups");
        if(!is_true){
            int profit=getTotalMoney()-priciple;
            System.out.println("$"+profit+" of money");
        }else
        System.out.println(getTotalMoney()+"$ of money");
    }

    public boolean maxCapacity(){
        int averageAmount=getTotalWater()+getTotalMilk()+getTotoalBean()/3;
        boolean is_full=false;
        if(averageAmount>1000 || getDisposableCups()>20){
             is_full=true;
        }

        return is_full;
    }

    public boolean minCapacity(){
        return false;
    }


    public static int getTotalWater() {
        return totalWater;
    }

    public static int calResource(int requirement,int resource){

        return resource=resource-requirement;

    }

    public static int calcMoney(int requirement,int resource){
        return resource=resource+requirement;
    }


    public static int getTotoalBean() {
        return totoalBean;
    }

    public static int getTotalMilk() {

        return totalMilk;
    }
}

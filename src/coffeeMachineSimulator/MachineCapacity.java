package coffeeMachineSimulator;

import coffeeMachineSimulator.Connection.JdbcUtil;

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
        JdbcUtil.InfoFetching();
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

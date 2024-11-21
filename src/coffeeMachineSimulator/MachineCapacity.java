package coffeeMachineSimulator;

public class MachineCapacity {
    private static int totalWater;
    private static int totoalBean;
    private static int totalMilk;


    public MachineCapacity(){}
    public MachineCapacity(int totalWater, int totoalBean, int totalMilk) {
        this.totalWater = totalWater;
        this.totoalBean = totoalBean;
        this.totalMilk = totalMilk;
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

    public static int getTotalWater() {
        return totalWater;
    }

    public static int getTotoalBean() {
        return totoalBean;
    }

    public static int getTotalMilk() {
        return totalMilk;
    }
}

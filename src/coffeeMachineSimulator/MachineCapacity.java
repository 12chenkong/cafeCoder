package coffeeMachineSimulator;

import coffeeMachineSimulator.Connection.JdbcUtil;
import coffeeMachineSimulator.Connection.MyJDBC;
import coffeeMachineSimulator.coffee_type.Cup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
        JdbcUtil.InfoFetching(is_true);
    }



    public static int getTotalWater() {
        return totalWater;
    }

    public static void calResource(Cup cup){
        JdbcUtil.calcResourceAndCost(cup);
    }


    public static int getTotoalBean() {
        return totoalBean;
    }

    public static int getTotalMilk() {

        return totalMilk;
    }
}

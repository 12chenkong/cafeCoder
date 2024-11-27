package coffeeMachineSimulator.utility;

import coffeeMachineSimulator.MachineCapacity;
import coffeeMachineSimulator.coffee_type.Cup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Util {

    public static void calculateIngredientsAndCost(Cup coffeeType){


        final  int oneCupOnly=1;
            int waterRemainig= MachineCapacity.calResource(coffeeType.getWater(),MachineCapacity.getTotalWater());
            int milkRemainig =MachineCapacity.calResource(coffeeType.getMilk(),MachineCapacity.getTotalMilk());
            int beansRemainig =MachineCapacity.calResource(coffeeType.getBean(),MachineCapacity.getTotoalBean());
            int diposableCupRemainig =MachineCapacity.calResource(oneCupOnly,MachineCapacity.getDisposableCups());
            int moneyRemainig =MachineCapacity.calcMoney(coffeeType.getCost(),MachineCapacity.getTotalMoney());
            MachineCapacity.setTotalWater(waterRemainig);
            MachineCapacity.setTotalMoney(moneyRemainig);
            MachineCapacity.setTotoalBean(beansRemainig);
            MachineCapacity.setTotalMilk(milkRemainig);
            MachineCapacity.setDisposableCups(diposableCupRemainig);
            MachineCapacity.machineInfo(true);


    }
    public static void addMoreResource(Scanner scanner) {

        System.out.println("Write how ml of water you want to add");
        int waterAddition=scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add");
        int milkAddition=scanner.nextInt();
        System.out.println("Write how many ml grams of bean you want to add");
        int beansAddition= scanner.nextInt();
        System.out.println("Write how many of disposable cups you want to add: ");
        int diposableCupsAddition=scanner.nextInt();
        MachineCapacity machine=new MachineCapacity();
            // add more resource to coffee machine
            int waterResource=MachineCapacity.getTotalWater();
            waterResource+=waterAddition;
            MachineCapacity.setTotalWater(waterResource);

            int beanResource=MachineCapacity.getTotoalBean();
            beanResource+=beansAddition;
            MachineCapacity.setTotoalBean(beanResource);

            int milkResource=MachineCapacity.getTotalMilk();
            milkResource+=milkAddition;
            MachineCapacity.setTotalMilk(milkResource);

            int disposable=MachineCapacity.getDisposableCups();
            disposable+=diposableCupsAddition;
            MachineCapacity.setDisposableCups(disposable);
//        This info of coffee machine
            MachineCapacity.machineInfo(true);

    }
}

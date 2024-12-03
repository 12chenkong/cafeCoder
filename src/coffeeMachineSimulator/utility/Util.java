package coffeeMachineSimulator.utility;

import coffeeMachineSimulator.Connection.JdbcUtil;
import coffeeMachineSimulator.MachineCapacity;
import coffeeMachineSimulator.coffee_type.Cup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Util {

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
        JdbcUtil.ResourceInsertion(
                MachineCapacity.getTotoalBean(),MachineCapacity.getTotalWater(),MachineCapacity.getTotalMilk(),
                MachineCapacity.getDisposableCups()
        );
//        This info of coffee machine
            MachineCapacity.machineInfo(true);

    }

   public  static  void calcIngredients(){
        Scanner scanner=new Scanner(System.in);
        int numOfCups;
        int waterAmount=0;
        int milkAmount=0;
        int beanAmout=0;
        int totalCupsMachineMake;
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water=scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk=scanner.nextInt();
        System.out.println("Write how many grams of bean the coffee machine has: ");
        int beans=scanner.nextInt();
        System.out.println("Write how many cups of coffee you need: ");
        numOfCups=scanner.nextInt();
        List<Cup> cupList=new ArrayList<>();
        for(int i=0;i<numOfCups;i++){
            cupList.add(new Cup(water,milk,beans));
        }
        System.out.println("For "+numOfCups+" you will need: ");
        for(int i=0;i<numOfCups;i++){
            waterAmount+=cupList.get(i).getWater();
            beanAmout+=cupList.get(i).getBean();
            milkAmount+=cupList.get(i).getMilk();
        }

        System.out.println("Water: "+waterAmount+"ml");
        System.out.println("Bean:"+beanAmout+"g");
        System.out.println("Milk:"+milkAmount+"ml");
        System.out.println("\n\n");



   }

}

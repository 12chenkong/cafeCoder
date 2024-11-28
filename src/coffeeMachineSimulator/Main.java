package coffeeMachineSimulator;

import coffeeMachineSimulator.Connection.MyJDBC;
import coffeeMachineSimulator.coffee_type.Cup;
import coffeeMachineSimulator.utility.Util;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyJDBC.Connection();
        Scanner scanner=new Scanner(System.in);
        /*
        int numOfCups;
        int waterAmount=0;
        int milkAmount=0;
        int beanAmout=0;
        int totalCupsMachineMake;
        MachineCapacity machineCapacity=new MachineCapacity();
        System.out.println("Write how many ml of water the coffee machine has: ");
        MachineCapacity.setTotalWater(scanner.nextInt());
        System.out.println("Write how many ml of milk the coffee machine has: ");
        MachineCapacity.setTotalMilk(scanner.nextInt());
        System.out.println("Write how many grams of bean the coffee machine has: ");
        MachineCapacity.setTotoalBean(scanner.nextInt());
        System.out.println("Write how many cups of coffee you need: ");
        numOfCups=scanner.nextInt();
        List<Cup> cupList=new ArrayList<>();
        for(int i=0;i<numOfCups;i++){
            cupList.add(new Cup());
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


        if(
                ( MachineCapacity.getTotalWater()>waterAmount && MachineCapacity.getTotalMilk()>milkAmount
                && MachineCapacity.getTotoalBean()>beanAmout)
        ){
              totalCupsMachineMake=numberOfCupsMachineMake();

            if(totalCupsMachineMake==1)
                System.out.println("Yes,I can make that amount of coffee");
            else
                System.out.println("I can make that amount of coffee "+"(even "+(totalCupsMachineMake-numOfCups)+" more than that)");

        } else if (
                (waterAmount>MachineCapacity.getTotalWater() || waterAmount<=MachineCapacity.getTotalWater()) &&(milkAmount>=MachineCapacity.getTotalMilk() || milkAmount<MachineCapacity.getTotalMilk())
                && (beanAmout>MachineCapacity.getTotoalBean()|| beanAmout<MachineCapacity.getTotoalBean())
        ){
            totalCupsMachineMake=numberOfCupsMachineMake();
            System.out.println("No, I can make only "+totalCupsMachineMake+" caps of coffee");

        } else if ((MachineCapacity.getTotoalBean()==0 || MachineCapacity.getTotoalBean()<15)&& (MachineCapacity.getTotalMilk()==0 || MachineCapacity.getTotalMilk()<50)
                &&(MachineCapacity.getTotalWater()==0 || MachineCapacity.getTotalWater()<200)) {
            System.out.println("No, I can make only 0 cups of coffee");
        }

         */

        MachineCapacity machineCapacity=new MachineCapacity(0,0,0,0,0);
        MachineCapacity.machineInfo(true);
        String choice;
        System.out.println("Write action (buy,fill,take):");
        choice=scanner.nextLine();
        if(choice.equalsIgnoreCase("buy")){

                System.out.println("What do you want to buy? 1-espresso, 2-latte, 3-cappuccino:");
                int typeOfCoffee=scanner.nextInt();
                switch (typeOfCoffee){
                    case 1:
                    {
                        System.out.println("You just clicked buy option");
//                  creating object of espresso
                        Cup espresso=new Cup(250,60,16,4);
                        Util.calculateIngredientsAndCost(espresso);
                    }
                    break;
                    case 2: {
                        System.out.println("You have clicked fill option");
                        Cup latte = new Cup(350, 75, 20, 7);
                        Util.calculateIngredientsAndCost(latte);
                    }
                    break;
                    case 3:
                    {
                        System.out.println("You hve just clicked take option");
                        Cup  cappuccino=new Cup(200,100,12,6);
                        Util.calculateIngredientsAndCost(cappuccino);

                    }
                    break;
                    default:
                        System.out.println("Invalid input");
                }
        } else if (choice.equalsIgnoreCase("fill")) {

            Util.addMoreResource(scanner);


        }else if (choice.equalsIgnoreCase("take"))
            MachineCapacity.machineInfo(false);


    }

    public static int numberOfCupsMachineMake(){
        int cupOfWater= (MachineCapacity.getTotalWater()/200);
        int cupOfMilk=(MachineCapacity.getTotalMilk()/50);
        int cupOfBeans=MachineCapacity.getTotoalBean()/15;

//      find the Minimum value among three
        int minValue=cupOfMilk;
        if(cupOfWater<minValue)
            minValue=cupOfWater;
         if (cupOfBeans<minValue)
            minValue=cupOfBeans;

        return minValue;
    }


}

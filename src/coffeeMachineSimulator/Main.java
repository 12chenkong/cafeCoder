package coffeeMachineSimulator;

import coffeeMachineSimulator.Connection.MyJDBC;
import coffeeMachineSimulator.coffee_type.Cup;
import coffeeMachineSimulator.utility.Util;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static coffeeMachineSimulator.utility.Util.calcIngredients;

public class Main {
    public static void main(String[] args) {
        MyJDBC.Connection();
        Scanner scanner=new Scanner(System.in);
        MachineCapacity machineCapacity=new MachineCapacity(0,0,0,0,0);
        MachineCapacity.machineInfo(false);
        String choice;
        boolean is_true=true;

        while(is_true){

            System.out.println("Write action (buy,fill,take,calculate):");
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
                        MachineCapacity.calResource(espresso);
                    }
                    break;
                    case 2: {
                        System.out.println("You have clicked fill option");
                        Cup latte = new Cup(350, 75, 20, 7);
                        MachineCapacity.calResource(latte);
                    }
                    break;
                    case 3:
                    {
                        System.out.println("You hve just clicked take option");
                        Cup  cappuccino=new Cup(200,100,12,6);
                        MachineCapacity.calResource(cappuccino);

                    }
                    break;
                    default:
                        System.out.println("Invalid input");
                }
            } else if (choice.equalsIgnoreCase("fill")) {
                Util.addMoreResource(scanner);

            }else if (choice.equalsIgnoreCase("take"))
                MachineCapacity.machineInfo(true);

            else if(choice.equalsIgnoreCase("calculate"))
                calcIngredients();

            System.out.println("continue or not (1/0)");
            int status=scanner.nextInt();
            scanner.nextLine();// Consume the leftover newline
            if(status==0)
                is_true=false;

        }



    }




}

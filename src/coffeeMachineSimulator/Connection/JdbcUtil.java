package coffeeMachineSimulator.Connection;

import coffeeMachineSimulator.coffee_type.Cup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {

    public static void calcResourceAndCost(Cup cup){
        Connection connection=MyJDBC.Connection();
        String query="UPDATE machine " +
                "SET " +
                "total_beas=total_beas - ? ," +
                "total_milk=total_milk - ? ," +
                "total_water=total_water - ? ," +
                "total_disCaps=total_disCaps - ? ," +
                "total_money=total_money + ? "+
                "WHERE id=1 " +
                "AND total_beas >= ? " +
                "AND total_milk >=? " +
                "AND  total_water >=? " +
                "AND  total_disCaps >=? " ;

        try {
            PreparedStatement smt=connection.prepareStatement(query);
            smt.setInt(1,cup.getBean());
            smt.setInt(2,cup.getMilk());
            smt.setInt(3,cup.getWater());
            smt.setInt(4,1);
            smt.setInt(5,cup.getCost());
            smt.setInt(6,cup.getBean());
            smt.setInt(7,cup.getMilk());
            smt.setInt(8,cup.getWater());
            smt.setInt(9,1);
            int row=smt.executeUpdate();
            if(row==0){
                System.out.println("Resource is not enough to make coffee! Please add resource!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void InfoFetching(boolean is_true){
        Connection connection=MyJDBC.Connection();
        int income=0;
                try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM machine");
                    System.out.println("Machine has: ");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("total_beas")+" g of beans");
                System.out.println(resultSet.getInt("total_water")+" ml of water");
                System.out.println(resultSet.getInt("total_milk")+" ml of milk");
                System.out.println(resultSet.getInt("total_disCaps")+ " cups ");
                income=resultSet.getInt("total_money");
            }
            if(is_true){
                System.out.println("Earned money: "+ income+"$");
            }
        }catch (Exception e){
           e.printStackTrace();
        }
    }

    public static void ResourceInsertion(int beans,int water,int milk,int disCups){
        String query="UPDATE machine SET " +
                "total_beas = total_beas + ?, " +
                "total_water = total_water + ?, " +
                "total_milk = total_milk + ?, " +
                "total_disCaps = total_disCaps + ? " +
                "WHERE id=1 " +
                "AND total_beas + ? <=1000 " +
                "AND total_water + ? <=1000  " +
                "AND total_milk  + ? <=1000 " +
                "AND total_disCaps + ? <=20 ";
        //    Declare a reference type get type Connect result
        Connection connection=MyJDBC.Connection();
        try {
            PreparedStatement smt=connection.prepareStatement(query);
            smt.setInt(1,beans);
            smt.setInt(2,water);
            smt.setInt(3,milk);
            smt.setInt(4,disCups);
            smt.setInt(5,beans);
            smt.setInt(6,milk);
            smt.setInt(7,water);
            smt.setInt(8,disCups);

            int rowUpdate=smt.executeUpdate();
            if(rowUpdate==0){
                System.out.println("Added amount exceed Machine capacity!!");
            }else
            System.out.println(rowUpdate+" rows update successfully!!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

package coffeeMachineSimulator.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {


    public static void InfoFetching(){
        Connection connection=MyJDBC.Connection();
                try {
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM machine");
                    System.out.println("Machine has: ");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("total_beas")+" g of beans");
                System.out.println(resultSet.getInt("total_water")+" ml of water");
                System.out.println(resultSet.getInt("total_milk")+" ml of milk");
                System.out.println(resultSet.getInt("total_disCaps")+ " cups ");
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

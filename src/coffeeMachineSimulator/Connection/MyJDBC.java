package coffeeMachineSimulator.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {

    public static Connection Connection(){
        String url="jdbc:mysql://localhost:3306/java_machine";
        String user="root";
        String password="1234567";
//        try {
//            Connection connection=DriverManager.getConnection(url,user,password);
//            Statement statement=connection.createStatement();
//            ResultSet resultSet=statement.executeQuery("SELECT * FROM machine");
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("total_beas"));
//                System.out.println(resultSet.getInt("total_water"));
//            }
//        }catch (Exception e){
//           e.printStackTrace();
//        }
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(url,user,password);

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;

    }





}

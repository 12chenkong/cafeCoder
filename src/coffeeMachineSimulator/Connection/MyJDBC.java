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
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(url,user,password);

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;

    }





}

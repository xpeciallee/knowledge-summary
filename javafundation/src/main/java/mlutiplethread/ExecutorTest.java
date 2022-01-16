package mlutiplethread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.Executors;

public class ExecutorTest {

    public static void main(String[] args) {
/*
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1);
        Executors.newScheduledThreadPool(1);
        Executors.newWorkStealingPool(1);*/
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=nacos";
        String userName="sa";
        String userPwd="xpeciallee";
        try
        {
            Class.forName(driverName);
            Connection dbConn= DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println("success!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("fail!");
        }

    }
}

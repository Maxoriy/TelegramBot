package interfaces;

import Tools.ITool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataBaseManager {
    private Connection dndconnector;
    private static DataBaseManager Instance;
    private DataBaseManager(){
        try {

            String dbName = "dndbotbase";
            String dbUserName = "root";
            String dbPassword = "@Cryptec03";
            String connectionString = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
            dndconnector= DriverManager.getConnection(connectionString);
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
    public static DataBaseManager getInstance(){
        if(Instance==null){
            Instance=new DataBaseManager();
        }
        return Instance;
    }
    public ArrayList<String> GetDataFromDB(String statement){
        ArrayList<String> answ = new ArrayList<>();
        try {

            PreparedStatement stmt = dndconnector.prepareStatement(statement);
            ResultSet ans=stmt.executeQuery();
            while(ans.next()){
               answ.add(ans.getString(2));
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
        return answ;
    }
    public ArrayList<ITool> GetToolsFromDb(String statement){
        ArrayList<ITool> answ = new ArrayList<>();
        try{
            PreparedStatement stmt= dndconnector.prepareStatement(statement);
            ResultSet ans=stmt.executeQuery();
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        return null;
    };
}

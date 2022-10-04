import com.opencsv.CSVReader;
import org.checkerframework.checker.units.qual.A;

import java.io.FileReader;
import java.util.ArrayList;

import java.sql.*;
import java.util.Arrays;


public class test {
    static ArrayList<Abilities> data;

    private static void SQLTest(){
    try{
        Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dndtest","root","@Cryptec03");


        for(Abilities a:data){
            PreparedStatement stmt =myConn.prepareStatement("insert into abilities(name,description,abilityLevel,SourceId) values(?,?,?,?)");
            stmt.setString(1,a.name);
            stmt.setString(2,a.descr);
            stmt.setString(3,Integer.toString(a.level));
            stmt.setString(4,"1");
            stmt.executeUpdate();
        }

        



    }
    catch(Exception exc){
        exc.printStackTrace();

    }
}

    public static void main(String[] args) {

        CsvTest();
        SQLTest();
    }
    public static void CsvTest(){
        data=new ArrayList<>();
        ArrayList<String> initstr=new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("C:/Users/as-pa/IdeaProjects/TelegramBot/src/main/java/Варвар.csv");
            CSVReader csvREader= new CSVReader(fileReader);
            String[] nextRecord;
            while((nextRecord= csvREader.readNext())!=null){
                initstr.addAll(Arrays.asList(nextRecord));
                data.add(new Abilities(initstr.get(0),initstr.get(1),initstr.get(2)));
                initstr.clear();
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println();
    }


}
/*DataStorage InfaSeeker=new TestDataStorage();
        String race="Голиаф";
        String clss="Варвар";
        String backsrty="Беспризорник";
        interfaces.CharInfo grog=new interfaces.CharInfo(race,clss,backsrty);
        grog.Inventory=InfaSeeker.getItemList(grog.InputRace,grog.InputClass,grog.InputBackstory);
        grog.Abilities=InfaSeeker.getAbilityList(grog.InputRace,grog.InputClass,grog.InputBackstory,0);
        grog.SkillAndSaveProficiency=InfaSeeker.getProficiencies(grog.InputRace,grog.InputClass,grog.InputBackstory);
        System.out.println("program ended");

* */
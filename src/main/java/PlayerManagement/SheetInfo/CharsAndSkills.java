package PlayerManagement.SheetInfo;

import Enums.SkillsEnum;
import Enums.StatsEnum;
import com.google.common.math.Stats;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class CharsAndSkills {
    public ArrayList<StatsEnum> SavingThrowProf;
    public ArrayList<SkillsEnum> SkillProf;
    public HashMap<StatsEnum,Integer> StatValue;
    public CharsAndSkills(){
        SavingThrowProf=new ArrayList<>();
        SkillProf=new ArrayList<>();
        StatValue=new HashMap<>();
        for (var a:StatsEnum.values()) {
            StatValue.put(a,10);
        }
    }
    public void addThrowProf(String prof){
        StatsEnum ad= Arrays.stream(StatsEnum.values())
                .filter(pr->{return Objects.equals(prof, pr.getName());})
                .findAny()
                .orElse(null);
        if (ad==null || SavingThrowProf.contains(ad)){return;}
        SavingThrowProf.add(ad);

    }
    public void addSkillProf(String prof){
        SkillsEnum ad= Arrays.stream(SkillsEnum.values())
                .filter(pr->{return Objects.equals(prof, pr.getName());})
                .findAny()
                .orElse(null);
        if (ad==null || SkillProf.contains(ad)){return;}
        SkillProf.add(ad);
    }
    public void setStatValue(String stat, int val){
        StatsEnum ad= Arrays.stream(StatsEnum.values())
                .filter(pr->{return Objects.equals(stat, pr.getName());})
                .findAny()
                .orElse(null);
        if (ad==null){return;}
        StatValue.put(ad,val);
    }
    public void addStatValue(String stat,int toAdd){
        StatsEnum ad= Arrays.stream(StatsEnum.values())
                .filter(pr->{return Objects.equals(stat, pr.getName());})
                .findAny()
                .orElse(null);
        if (ad==null){return;}
        StatValue.put(ad,StatValue.get(ad)+toAdd);
    }

    public static void main(String[] args) {
        CharsAndSkills dat=new CharsAndSkills();
        dat.setStatValue(StatsEnum.Charisma.getName(),20);
        dat.addSkillProf(SkillsEnum.Athletics.getName());
        dat.addSkillProf("randomShit");
    }
}

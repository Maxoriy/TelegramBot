package PlayerManagement.SheetInfo;

import Tools.ITool;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class ArraysHolder {
    public ArrayList<ITool> Equipment;
    public ArrayList<ITool> Abilities;
    public ArrayList<String> EquipmentProf;

    public ArraysHolder(){
        Equipment=new ArrayList<>();
        Abilities=new ArrayList<>();

        EquipmentProf=new ArrayList<>();
    }
    public void AddEquipment(ITool eq){
        Equipment.add(eq);
    }
    public void AddAbility(ITool eq){
        Abilities.add(eq);
    }


}

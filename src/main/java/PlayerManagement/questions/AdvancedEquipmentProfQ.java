package PlayerManagement.questions;

import PlayerManagement.SheetInfo.SheetInfoHolder;

import java.util.function.Consumer;

public class AdvancedEquipmentProfQ extends NoOptionQuestion{
    public AdvancedEquipmentProfQ(String description, SheetInfoHolder h) {
        super(description, (ans)->{h.toolLists.EquipmentProf.add(ans);});
    }
}

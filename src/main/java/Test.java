import interfaces.*;

import java.util.ArrayList;

public class Test implements CharInfo {



    @Override
    public int GetMajorStatVal(StatsEnum stat) {
        return 34;
    }

    @Override
    public int GetSkillVal(SkillsEnum stat) {
        return 24;
    }

    @Override
    public int GetSavingThrows(StatsEnum stat) {
        return 14;
    }

    @Override
    public String GetMajorCharacteristic(MajorCharacteristic stat) {
        return "Варвар";
    }

    @Override
    public int GetMajorCharacteristics(MajorCharacteristics stats) {
        return 4;
    }

    @Override
    public ToolIterator GetStringField(ToolField st) {
        return new ToolIteratorImp();
    }
}

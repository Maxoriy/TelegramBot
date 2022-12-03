package Enums;

import Tools.ToolField;
import Tools.ToolIterator;

public interface CharInfo {
    int GetMajorStatVal(StatsEnum stat);

    int GetSkillVal(SkillsEnum stat);

    int GetSavingThrows(StatsEnum stat);

    String GetNames(Names stat);

    int GetMajorCharacteristics(MajorCharacteristics stats);

    ToolIterator GetStringField(ToolField st);
}

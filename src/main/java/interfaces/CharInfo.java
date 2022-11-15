package interfaces;

public interface CharInfo {
    int GetMajorStatVal(StatsEnum stat);

    int GetSkillVal(SkillsEnum stat);

    int GetSavingThrows(StatsEnum stat);

    String GetMajorCharacteristic(MajorCharacteristic stat);

    int GetMajorCharacteristics(MajorCharacteristics stats);

    ToolIterator GetStringField(ToolField st);
}

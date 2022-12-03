package PlayerManagement.questions;

import Tools.ITool;

public class EquipmentOption implements ITool{
    public int count;
    public ITool val;
    public EquipmentOption(int cnt, ITool nme){
        count=cnt;
        val=nme;
    }
    public String getStr(){
        return String.format("(%d)%s",count,val.getName());
    }

    @Override
    public String getName() {
        return getStr();
    }

    @Override
    public String getDescription() {
        return val.getDescription();
    }
}

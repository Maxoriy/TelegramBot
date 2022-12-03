package Tools;

import java.util.ArrayList;

public class StringToolIterImp implements ToolIterator{

    public ArrayList<String> data;
    int curid;
    public StringToolIterImp(ArrayList<String> a){
        data=a;
        curid=0;
    }

    @Override
    public ITool GetCurrent() {
        return new DefaultTool(data.get(curid),"");
    }

    @Override
    public void Next() {
        curid++;

    }

    @Override
    public boolean IsOver() {
        return curid>=data.size();
    }

    @Override
    public void RestartIteration() {
        curid=0;
    }
}

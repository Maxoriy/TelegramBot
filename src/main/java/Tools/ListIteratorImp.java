package Tools;

import java.util.ArrayList;

public class ListIteratorImp implements ToolIterator{
    private ArrayList<ITool> data;
    private int id;
    public ListIteratorImp(ArrayList<ITool> d){
        data=d;
        id=0;
    }
    @Override
    public ITool GetCurrent() {
        return data.get(id);
    }

    @Override
    public void Next() {
        id++;
    }

    @Override
    public boolean IsOver() {
        return id>=data.size();
    }

    @Override
    public void RestartIteration() {
        id=0;
    }
}

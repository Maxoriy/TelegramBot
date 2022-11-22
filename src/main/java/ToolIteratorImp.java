import interfaces.ITool;
import interfaces.ToolIterator;

import java.util.ArrayList;

public class ToolIteratorImp implements ToolIterator {
    private ArrayList<ITool> data;
    private int currentid = 0;

    ToolIteratorImp() {
        data = new ArrayList<>();
        data.add(new DefaultToolImp("ability1"));
        data.add(new DefaultToolImp("ability2"));
        data.add(new DefaultToolImp("ability3"));

    }

    @Override
    public ITool GetCurrent() {
        return data.get(currentid);
    }

    @Override
    public void Next() {
        currentid++;
    }

    @Override
    public boolean IsOver() {
        return currentid >= data.size();
    }

    @Override
    public void RestartIteration() {
        currentid = 0;
    }

    public static void main(String[] args) {
    }
}

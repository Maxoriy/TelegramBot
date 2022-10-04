package interfaces;

public interface ToolIterator {
    ITool GetCurrent();
    void Next();
    boolean IsOver();
    void RestartIteration();
}

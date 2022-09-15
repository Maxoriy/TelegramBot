public class Tool implements ITool{
    private String _name;
    private String _descr;

    public Tool(String _name, String _descr) {
        this._name = _name;
        this._descr = _descr;
    }

    public String getName(){return _name;};
    public String getDescription(){return _descr;};
}

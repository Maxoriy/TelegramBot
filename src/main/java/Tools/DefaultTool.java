package Tools;

public class DefaultTool implements ITool{
    private String name;
    private String descr;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return descr;
    }
    public DefaultTool(String nme, String descr){
        name=nme;
        this.descr=descr;
    }
}

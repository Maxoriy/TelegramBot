import interfaces.ITool;

class DefaultToolImp extends ToolIteratorImp implements ITool {
    private final String name;

    DefaultToolImp(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "";
    }
}


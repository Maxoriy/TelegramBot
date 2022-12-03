package Enums;

public enum Languages {
    Giant("Владение великаньим языком",false),
    Gnome("Владение гномий языком",false),
    Goblin("Владение гоблинский языком",false),
    Dwarf("Владение дварфийский языком",false),
    Common("Владение общим языком",false),
    Ork("Владение орочьим языком",false),
    Hafling("Владение языком полуросликов",false),
    Elf("Владение эльфийским языком",false),
    Abuss("Владение языком бездны",true),
    Deep("Владение глубинной речью",true),
    Dragon("Владение драконьим языком",true),
    Infernal("Владение инфернальным языком",true),
    Heaven("Владение небесным языком",true),
    Element("Владение первичным языком",true),
    Underworld("Владение подземным языком",true),
    Sylvan("Владение языком сильван",true);

    public String name;
    public boolean exotic;
    Languages(String name, boolean isExotic){
        this.name=name;
        this.exotic=isExotic;
    }
}

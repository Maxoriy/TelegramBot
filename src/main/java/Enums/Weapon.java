package Enums;

import Tools.ITool;

public enum Weapon implements ITool {
    QuaterStaff("Боевой посох","1к6 дробящий, универсальное(1d8)",true,true),
    Mace("Булава","1к6 дробящий",true,true),
    Club("Дубинка","1к4 дробящий, легкое",true,true),
    Dagger("Кинжал","1к4 колющий, легкое, метательное(20/60), фехтовальное",true,true),
    Spear("Копье","1к6 колющий, метательное(20/60), универсальное(1к8)",true,true),
    LightHammer("Легкий молот","1к4 дробящий, легкое, метательное(20/60)",true,true),
    ThrowingSpear("Метательное копье","1к6 колющий, метательное(30,120)",true,true),
    Sticks("Палица","1к8 дробящий, двуручное",true,true),
    HandAxe("Ручной топор","1к6 рубящий, легкое, метательное(20/60)",true,true),
    Sickle("Серп","1к4 рубящий, легкое",true,true),
    LightCrossBow("Арбалет, легкий","1к8 колющий, беприпас(80/320), двуручное, перезарядка",true,false),
    Dart("Дротик","1к4 колющий, метательное(20/60), фехтовальное",true,false),
    ShortBow("короткий лук","1к6 колющий, Боеприпас (дис. 80/320), двуручное",true,false),
    Sling("Праща","1к4 дробящий, Боеприпас (дис. 30/120)",true,false),
    Alebard("Алебарда","1к10 рубящий, Двуручное, досягаемость, тяжёлое",false,true),
    WarPick("Боевая кирка","1к8 колющий",false,true),
    WarHammer("Боевой молот","1к8 дробящий, Универсальное (1к10)",false,true),
    WarAxe("Боевой топор","1к8 рубящий, Универсальное (1к10)",false,true),
    Glave("Глефа","1к10 рубящий, Двуручное, досягаемость, тяжёлое",false,true),
    TwoHandSword("Двуручный меч","2к6 рубящий, Двуручное, тяжёлое",false,true),
    LongSpear("Длинное копье","1к12 колющий, Досягаемость, особое",false,true),
    LongSword("Длинный меч","1к8 рубящий, Универсальное (1к10)",false,true),
    Whip("Кнут","1к4 рубящий, Досягаемость, фехтовальное",false,true),
    ShordSword("Короткий меч","1к6 колющий, Лёгкое, фехтовальное",false,true),
    Hammer("Молот","2к6 дробящий, Двуручное, тяжёлое",false,true),
    MorgenStern("Моргенштерн","1к8 колющий",false,true),
    Pike("Пика","1к10 колющий, Двуручное, досягаемость, тяжёлое",false,true),
    Saber("Рапира","1к8 колющий, Фехтовальное",false,true),
    Serkir("Секира","1к12 рубящий, Двуручное, тяжёлое",false,true),
    Skimitar("Скимитар","1к6 рубящий, Лёгкое, фехтовальное",false,true),
    Trizubets("Трезубец","1к6 колющий, Метательное (дис. 20/60), Универсальное (1к8)",false,true),
    Tzep("Цеп","1к8 дробящий",false,true),
    HandCrossBow("Арбалет, ручной","1к6 колющий, Боеприпас (дис. 30/120), легкое, перезарядка",false,false),
    HeavyCrossBow("Арбалет, тяжелый","1к10 колющий, Боеприпас (дис. 100/400), двуручное, перезарядка, тяжёлое",false,false),
    LongBow("Длинный лук","1к8 колющий, Боеприпас (дис. 150/600), двуручное, тяжёлое",false,false),
    DuhPipe("Духовая трубка","1 колющий, Боеприпас (дис. 25/100), перезарядка",false,false),
    Net("Сеть","0, Метательное (дис. 5/15), особое",false,false);
    Weapon(String name,String descr,boolean isSimple,boolean isMelee){
        this.name=name;
        this.descr=descr;
        this.isMelee=isMelee;
        this.isSimple=isSimple;
    }

    public boolean isSimple;
    public boolean isMelee;
    public String name;
    public String descr;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return descr;
    }
}

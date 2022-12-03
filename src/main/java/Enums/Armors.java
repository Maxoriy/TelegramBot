package Enums;

import Tools.ITool;

import java.util.ArrayList;

public enum Armors implements ITool {
    Steg("Стеганый доспех","11 + модификатор ЛОВ, помеха на скрытность",true,false,false,false),
    Hide("Кожаный доспех","11 + модификатор ЛОВ",true,false,false,false),
    GoodHide("Проклепаный кожаный доспех","12 + модификатор ЛОВ",true,false,false,false),
    Bitch("Шкурный доспех","12 + модификатор ЛОВ (макс. 2)",false,true,false,false),
    KolchuznaiaRubaha("Кольчужная рубаха","13 + модификатор ЛОВ (макс. 2)",false,true,false,false),
    Scale("Чешуйчатый доспех","14 + модификатор ЛОВ (макс. 2), помеха на скрытность",false,true,false,false),
    Kirasa("Кираса","14 + модификатор ЛОВ (макс. 2)",false,true,false,false),
    HalfArmor("Полулаты","15 + модификатор ЛОВ (макс. 2), помеха на скрытность",false,true,false,false),
    Kolechni("Колечный доспех","14КД, помеха на скрытность",false,false,true,false),
    Kolchuga("Кольчуга","16КД, необходимая сила 13, помеха на скрытность",false,false,true,false),
    Naborni("Наборный доспех","17КД, необходимая сила 15, помеха на скрытность", false,false,true,false),
    Lati("Латы","18КД, необходимая сила: 15, помеха на скрытность",false,false,true,false),
    Shield("Щит","+2КД",false,false,false,true)
    ;

    Armors(String nme,String descr,boolean isLight, boolean isMedium, boolean isHeavy, boolean isShield  ) {
        this.isLight = isLight;
        this.isMedium = isMedium;
        this.isHeavy = isHeavy;
        this.isShield = isShield;
        this.nme = nme;
        this.descr = descr;
    }

    public boolean isLight;
    public boolean isMedium;
    public boolean isHeavy;
    public boolean isShield;
    private String nme;
    private String descr;
    @Override
    public String getName() {
        return nme;
    }

    @Override
    public String getDescription() {
        return descr;
    }
}

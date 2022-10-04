import interfaces.ITool;

import java.util.ArrayList;
import java.util.HashMap;

public class TestDataStorage implements DataStorage{
    private HashMap<String,ArrayList<ITool>> ClassItems;//
    private HashMap<String,ArrayList<ITool>> BackStoryItems;//

    private HashMap<String,ArrayList<ITool>> ClassAbilities;//
    private HashMap<String,ArrayList<ITool>> BackStoryAbilities;//
    private HashMap<String,ArrayList<ITool>> RaceAbilities;//

    private HashMap<String,ArrayList<String>> BackStoryProf;
    private HashMap<String,ArrayList<String>> ClassProf;
    private HashMap<String,ArrayList<String>> RaceProf;


    @Override
    public ArrayList<ITool> getAbilityList(String race, String clss, String backstory,int level) {
        ArrayList<ITool> ans = new ArrayList<>(RaceAbilities.get(race));
        ans.addAll(ClassAbilities.get(clss));
        ans.addAll(BackStoryAbilities.get(backstory));
        return ans;
    }

    @Override
    public ArrayList<ITool> getItemList(String race, String clss, String backstory) {
        ArrayList<ITool> ans = new ArrayList<>(ClassItems.get(clss));
        ans.addAll(BackStoryItems.get(backstory));
        return ans;
    }

    @Override
    public ArrayList<String> getProficiencies(String race, String clss, String backstory) {
        ArrayList<String> ans = new ArrayList<>(RaceProf.get(race));
        ans.addAll(ClassProf.get(clss));
        ans.addAll(BackStoryProf.get(backstory));
        return ans;
    }
    public TestDataStorage(){
        ArrayList<ITool> BarbarItems=new ArrayList<ITool>();
        BarbarItems.add(new Tool("Боевой топор","Наносит урон 1d8"));
        BarbarItems.add(new Tool("Щит","Прибавляет +2 к классу брони"));
        ArrayList<ITool> BarbarAbilities=new ArrayList<ITool>();
        BarbarAbilities.add(new Tool("Ярость","*Описание ярости*"));
        BarbarAbilities.add(new Tool("Защита без доспехов","твой класс брони равняется..."));
        ArrayList<ITool> HomelessItems=new ArrayList<ITool>();
        HomelessItems.add(new Tool("Снаряжение беспризорника","Маленький нож, карта города, в котором вы выросли, ручная мышь, безделушка в память о родителях, комплект обычной одежды, поясной кошель с 10 зм"));
        ArrayList<ITool> HomelessAbilities=new ArrayList<ITool>();
        HomelessAbilities.add(new Tool(" ГОРОДСКИЕ ТАЙНЫ","Вы знаете тайные лазы и проходы городских улиц, позволяющие пройти там, где другие не увидят пути. Вне боя вы (и ведомые вами союзники) можете перемещаться по городу вдвое быстрее обычного."));
        ArrayList<ITool> GoliaphAbilities=new ArrayList<ITool>();
        GoliaphAbilities.add(new Tool("Выносливость камня","Вы можете сосредоточиться, чтобы уменьшить полученные повреждения. При получении урона вы можете реакцией бросить к12 и прибавить к результату модификатор Телосложения, а после уменьшить полученный урон на итоговую сумму. Вы не сможете вновь воспользоваться этой особенностью, пока не окончите короткий или продолжительный отдых."));
        GoliaphAbilities.add(new Tool("Сильные руки","При определении вашей грузоподъёмности, а также веса, который вы можете толкать, тянуть и поднимать, вы считаетесь существом на один размер больше."));
        GoliaphAbilities.add(new Tool("Рождённый в горах","Вы получаете сопротивление урону холодом. Кроме того, вы акклиматизированы к большой высоте, включая высоту более 20 000 футов (6 километров)."));
        ArrayList<String> HomeLessProf=new ArrayList<String>();
        HomeLessProf.add("Ловкость рук");
        HomeLessProf.add("Скрытность");
        ArrayList<String> GoliaphProf=new ArrayList<String>();
        GoliaphProf.add("Атлетика");
        ArrayList<String> BarbarProf=new ArrayList<String>();
        BarbarProf.add("Восприятие");
        BarbarProf.add("Выживание");

        ClassItems=new HashMap<>();
        ClassItems.put("Варвар",BarbarItems);
        BackStoryItems=new HashMap<>();
        BackStoryItems.put("Беспризорник",HomelessItems);
        ClassAbilities=new HashMap<>();
        ClassAbilities.put("Варвар",BarbarAbilities);
        BackStoryAbilities=new HashMap<>();
        BackStoryAbilities.put("Беспризорник",HomelessAbilities);
        RaceAbilities=new HashMap<>();
        RaceAbilities.put("Голиаф",GoliaphAbilities);
        ClassProf=new HashMap<>();
        ClassProf.put("Варвар",BarbarProf);
        RaceProf=new HashMap<>();
        RaceProf.put("Голиаф", GoliaphProf);
        BackStoryProf=new HashMap<>();
        BackStoryProf.put("Беспризорник",HomeLessProf);

    }
}

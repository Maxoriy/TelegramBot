package PlayerManagement.questions;



import Enums.Weapon;
import Tools.DefaultTool;
import Tools.ITool;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

public class AdvancedWeaponQuestion implements UserQuestion{
    //todo end this class
    private String QuestionName;

    private Consumer<ITool> callback;
    private boolean isOver=false;
    private ArrayList<EquipmentOption> Options;
    public AdvancedWeaponQuestion(String description, ArrayList<EquipmentOption> options,Consumer<ITool>  imp ){
        this.QuestionName=description;
        this.Options=options;
        this.callback=imp;
    }
    @Override
    public String getQuestionName() {
        return  QuestionName;
    }

    @Override
    public ArrayList<String> getOptions() {
        ArrayList<String> ans=new ArrayList<>();
        for (var a :Options) {
            ans.add(a.getStr());
        }
        return ans;
    }

    @Override
    public boolean isAnswerCorrect(String message) {
        for (EquipmentOption a:Options) {
            if(Objects.equals(a.getStr(), message)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void SetAnswer(String ans) {
        for (var a: Options) {
            if(Objects.equals(a.getStr(), ans)){
                callback.accept(new DefaultTool(a.val.getName() + "(" + a.count + ")",a.val.getDescription()));
            }
        }
        isOver=true;
    }

    @Override
    public boolean isAnswerOver() {
        return isOver;
    }
}

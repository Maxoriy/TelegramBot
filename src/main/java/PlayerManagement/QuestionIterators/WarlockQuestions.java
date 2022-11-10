package PlayerManagement.QuestionIterators;

import PlayerManagement.QuestionIterators.ClassQuestions;
import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;
import Tools.DefaultTool;
import Tools.ITool;

import java.util.ArrayList;

public class WarlockQuestions extends ClassQuestions {
    ArrayList<ITool> pact_items;


    public void SetPactItem(String abil){
        data.addAbbility(new DefaultTool(abil,""));
        /*
        for(var e:pact_items){
            if(e.getName().equals(abil)){
                data.addAbbility(e);
                return;
            }
        }
        */
    }
    private UserQuestion createPactItemQuestion(){
        ArrayList<String> opts=new ArrayList<>();
        opts.add("Договор гримуара");
        opts.add("Договор клинка");
        opts.add("Договор цепи");
        String Qname="Выберите предмет договора";
        return new SingleEntryUserQuestion(Qname,opts,this::SetPactItem);

    }
    public WarlockQuestions(){
        super();
        this.questionQueue.add(createPactItemQuestion());
        pact_items=new ArrayList<>();

    }
}

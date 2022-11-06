package PlayerManagement;

import PlayerManagement.questions.SingleEntryUserQuestion;
import PlayerManagement.questions.UserQuestion;

import java.util.ArrayList;

public class WarlockQuestions extends ClassQuestions{
    private String pactItemName;
    public void SetPactItem(String a){pactItemName=a;}

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
        this.questionQueue.add(this::createPactItemQuestion);

    }
}

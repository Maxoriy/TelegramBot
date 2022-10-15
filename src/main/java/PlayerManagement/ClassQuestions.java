package PlayerManagement;

import java.util.ArrayList;

public class ClassQuestions implements PlayerQuestionIterator{
    ArrayList<String> QuestionNames;
    ArrayList<ArrayList<String>> qoptions;
    public ClassQuestions(){
        QuestionNames=new ArrayList<>();
        QuestionNames.add("ques1");
        QuestionNames.add("ques2");
        QuestionNames.add("ques3");
        qoptions=new ArrayList<>();
        ArrayList<String> inf=new ArrayList<>();
        inf.add("ques1option1");
        inf.add("ques1option2");
        inf.add("ques1option3");
        qoptions.add(inf);
        ArrayList<String> inf2=new ArrayList<>();
        inf2.add("ques2option1");
        inf2.add("ques2option2");
        inf2.add("ques2option3");
        qoptions.add(inf2);
        ArrayList<String> inf3=new ArrayList<>();
        inf3.add("ques3option1");
        inf3.add("ques3option2");
        inf3.add("ques3option3");
        qoptions.add(inf3);
    }
    int currentQuest=0;
    @Override
    public PlayerQuestion AskQuestion() {
        return new PlayerQuestion(QuestionNames.get(currentQuest),qoptions.get(currentQuest));
    }

    @Override
    public void NextQuestion() {
        currentQuest++;
    }

    @Override
    public boolean IsOver() {
        return currentQuest>=QuestionNames.size();
    }
}

package PlayerManagement;

import PlayerManagement.QuestionIterators.PlayerQuestionIterator;
import PlayerManagement.QuestionIterators.WarlockQuestions;
import PlayerManagement.SheetInfo.SheetInfoHolder;

public class QuestionQueuesBuilder {
    public static QuestionQueuesBuilder getInstance(){
    if(instance==null){
        instance=new QuestionQueuesBuilder();
        }
        return instance;
    }
    private static QuestionQueuesBuilder instance;

    public SelfStorageQuestionIterator CreateQueue(SheetInfoHolder hold){
        PlayerQuestionIterator clss;

        switch (hold.getClassName()){
            case "Колдун"->clss=warlockConstructor(hold);
            default -> throw new RuntimeException();
        }
        return new SelfStorageQuestionIterator(hold, clss,warlockConstructor(hold),warlockConstructor(hold));
    }
    private PlayerQuestionIterator warlockConstructor(SheetInfoHolder dat){
        return new WarlockQuestions(dat);
    }



}

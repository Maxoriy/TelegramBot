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
        return new SelfStorageQuestionIterator(hold, warlockConstructor(),warlockConstructor(),warlockConstructor());
    }
    private PlayerQuestionIterator warlockConstructor(){
        return new WarlockQuestions();
    }



}

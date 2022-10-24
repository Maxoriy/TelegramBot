package PlayerManagement;
import interfaces.UserAnswer;
import java.util.ArrayList;
import java.util.Objects;
    public class PlayerQuestionManager {
    PlayerQuestionIterator[] RaceClassAndBackStory;
    int currentStage=0;
    int maxStage=0;
    public PlayerQuestion GetCurrentQuestion(){
        return RaceClassAndBackStory[currentStage].AskQuestion();
    }
    public int HandleReaction(UserAnswer update){
       if(RaceClassAndBackStory[currentStage].AskQuestion().IsAnswerCorrect(update)){
           RaceClassAndBackStory[currentStage].NextQuestion();
           if(RaceClassAndBackStory[currentStage].IsOver()){
               currentStage++;
               if(currentStage>=maxStage){
                   return 0;
               }
           }
           return 1;
       }
       return -1;
    }
    public PlayerQuestionManager(){
        this.maxStage=1;
        RaceClassAndBackStory=new PlayerQuestionIterator[1];
        RaceClassAndBackStory[0]=new ClassQuestions();
    }



}
/*
* состояния: ожидание ввода(тип ввода)
* поле, знающее, какой тип нужно получить
* */
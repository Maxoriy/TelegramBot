package PlayerManagement;
import interfaces.UserAnswer;

public class PlayerQuestionManager {
    PlayerQuestionIterator[] RaceClassAndBackStory;
    int currentStage=0;
    int maxStage=0;
    public UserQuestion GetCurrentQuestion(){
        return RaceClassAndBackStory[currentStage].AskQuestion();
    }
    public int HandleReaction(UserAnswer update){
       if(RaceClassAndBackStory[currentStage].AskQuestion().isAnswerCorrect(update)){
           if(RaceClassAndBackStory[currentStage].AskQuestion().isAnswerOver()){
               RaceClassAndBackStory[currentStage].NextQuestion();
           }
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
package PlayerManagement;

import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.Objects;

public class PlayerQuestionManager {
    PlayerQuestionIterator[] RaceClassAndBackStory;
    int currentStage=0;
    int maxStage=0;
    public String GetQuestionToAskText(){
       return RaceClassAndBackStory[currentStage].AskQuestion().GetQuestionName();
   }
    public int HandleReaction(Update update){
       if(RaceClassAndBackStory[currentStage].AskQuestion().GetOptions().stream().anyMatch(x -> Objects.equals(x, update.getMessage().getText()))){
           System.out.println(RaceClassAndBackStory[currentStage].IsOver());
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
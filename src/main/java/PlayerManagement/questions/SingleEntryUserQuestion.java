package PlayerManagement.questions;

import java.util.ArrayList;
import java.util.function.Consumer;

public class SingleEntryUserQuestion implements UserQuestion {
    private String QuestionName;
    private Consumer<String> callback;
    private boolean isOver=false;
    private ArrayList<String> Options;
    public SingleEntryUserQuestion(String description, ArrayList<String> options, Consumer<String>  imp){
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
        return Options;
    }

    @Override
    public boolean isAnswerCorrect(String message) {
        return Options.contains(message);
    }

    @Override
    public void SetAnswer(String ans) {
        callback.accept(ans);
        isOver=true;
    }

    @Override
    public boolean isAnswerOver() {
        return isOver;
    }
}
/*
* Проблема: очень запутанная система итераторов
* решение: упростить систему
* итераторы сейчас: вопрос, класс, менеджер
*
* мне крайне не нравится что в вопросе лежит итератор.
* Но из альтернатив у меня только составить очередь и научить вопросы порождать вопросы
* В этом случае главной проблемой будет оставлять вопросы в нужном порядке, то есть использовать инсерт
* более того, чтобы вопрос мог поставить себя в очередь, нужна связность, передавать в вопрос еще и функцию конструктор
*
*
*
* */
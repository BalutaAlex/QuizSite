/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.quizsite.ejb;

import com.quiz.quizsite.entity.Question;
import com.site.quizsite.common.QuestionDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alex
 */
@Stateful
@SessionScoped
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 30)
public class MainQuizBean {
    
    private static final Logger LOG = Logger.getLogger(MainQuizBean.class.getName());

    @PersistenceContext
    private EntityManager em;
    
    private List<QuestionDetails> questions ;
    private int correctAnswers=0;
    private int currentQuestion=0;
    private int numberOfQuestions=0;
    
    public void initQuiz(){  
        questions = new ArrayList<>();
        questions = getAllQuestions();
        correctAnswers=0;
        currentQuestion=0;
        numberOfQuestions=questions.size();
    }
    
    public void correctChoice(){
        correctAnswers++;
        currentQuestion++;
    }
    
    public void wrongChoice(){
        currentQuestion++;
    }
    

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public List<QuestionDetails> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDetails> questions) {
        this.questions = questions;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
    
    

    private List<QuestionDetails> getAllQuestions()

    {
        try {
            List<Question> questionsList = (List<Question>) em.createQuery("SELECT q FROM Question q").getResultList();
            return copyQuestionsToDetails(questionsList);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<QuestionDetails> copyQuestionsToDetails(List<Question> questions){
        List<QuestionDetails> detailsList = new ArrayList<>();
        for(Question question : questions){
            QuestionDetails questionDetails = new QuestionDetails(question.getId(),
                    question.getQuestion(),
                    question.getChoice1(),
                    question.getChoice2(),
                    question.getChoice3(),
                    question.getChoice4(),
                    question.getAnswer());
            detailsList.add(questionDetails);
        }
        return detailsList;
    }
    
    @Remove
    public void remove(){
        questions=null;
    }
    
}

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
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alex
 */
@Stateless
public class ManageQuestionsBean {

    private static final Logger LOG = Logger.getLogger(MainQuizBean.class.getName());

    @PersistenceContext
    private EntityManager em;
    
    public void addQuestion(String newQuestion, String choice1, String choice2, String choice3, String choice4, Integer answer){
        Question question = new Question();
        question.setQuestion(newQuestion);
        question.setChoice1(choice1);
        question.setChoice2(choice2);
        question.setChoice3(choice3);
        question.setChoice4(choice4);
        question.setAnswer(answer);
        
        em.persist(question);
    }
    
    public void deteleQuestion(Integer questionId){
        
        Question question = em.find(Question.class, questionId);
        em.remove(question);
        
    }
    
    public QuestionDetails findById(Integer questionId){
        
        Question question = em.find(Question.class,questionId);
        
        return new QuestionDetails(question.getId(),question.getQuestion(),question.getChoice1(),question.getChoice2(),question.getChoice3(),question.getChoice4(),question.getAnswer());
    }
    
    public void editQuestion(Integer id, String question, String choice1, String choice2, String choice3, String choice4, Integer answer){
        
        Question editedQuestion = em.find(Question.class, id);
        
        editedQuestion.setQuestion(question);
        editedQuestion.setChoice1(choice1);
        editedQuestion.setChoice2(choice2);
        editedQuestion.setChoice3(choice3);
        editedQuestion.setChoice4(choice4);
        editedQuestion.setAnswer(answer);         
        
    }
    
    public List<QuestionDetails> getAllQuestions()
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
}

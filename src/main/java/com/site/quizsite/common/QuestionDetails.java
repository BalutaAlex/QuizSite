/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site.quizsite.common;

/**
 *
 * @author Alex
 */
public class QuestionDetails {
    private Integer id;
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private int answer;

    public QuestionDetails(Integer id, String question, String choice1, String choice2, String choice3, String choice4, int answer) {
        this.id = id;
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public int getAnswer() {
        return answer;
    }
    
    
}

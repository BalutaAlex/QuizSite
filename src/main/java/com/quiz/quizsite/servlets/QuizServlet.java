/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.quizsite.servlets;

import com.quiz.quizsite.ejb.MainQuizBean;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@WebServlet(name = "QuizServlet", urlPatterns = {"/QuizServlet"})
public class QuizServlet extends HttpServlet {

    @Inject
    MainQuizBean mainQuizBean;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        request.setAttribute("question", mainQuizBean.getQuestions().get(mainQuizBean.getCurrentQuestion()));
        request.setAttribute("currentQuestion", mainQuizBean.getCurrentQuestion());
        request.setAttribute("numberOfQuestions", mainQuizBean.getNumberOfQuestions());
        request.setAttribute("score", mainQuizBean.getCorrectAnswers());
        request.getRequestDispatcher("/WEB-INF/pages/quiz.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("answer1Btn") != null) {

            int answer = Integer.parseInt(request.getParameter("answer1Btn"));
            if(answer == mainQuizBean.getQuestions().get(mainQuizBean.getCurrentQuestion()).getAnswer()){
                mainQuizBean.correctChoice();
            }
            else mainQuizBean.wrongChoice();
        }

        if (request.getParameter("answer2Btn") != null) {
            int answer = Integer.parseInt(request.getParameter("answer2Btn"));
            if(answer == mainQuizBean.getQuestions().get(mainQuizBean.getCurrentQuestion()).getAnswer()){
                mainQuizBean.correctChoice();
            }
            else mainQuizBean.wrongChoice();
        }
        
        if (request.getParameter("answer3Btn") != null) {
            int answer = Integer.parseInt(request.getParameter("answer3Btn"));
            if(answer == mainQuizBean.getQuestions().get(mainQuizBean.getCurrentQuestion()).getAnswer()){
                mainQuizBean.correctChoice();
            }
            else mainQuizBean.wrongChoice();
        }
        
        if (request.getParameter("answer4Btn") != null) {
            int answer = Integer.parseInt(request.getParameter("answer4Btn"));
            if(answer == mainQuizBean.getQuestions().get(mainQuizBean.getCurrentQuestion()).getAnswer()){
                mainQuizBean.correctChoice();
            }
            else mainQuizBean.wrongChoice();
        }
        
        if(mainQuizBean.getCurrentQuestion()==mainQuizBean.getNumberOfQuestions()){
            response.sendRedirect(request.getContextPath() + "/EndQuizServlet");
        }
        else response.sendRedirect(request.getContextPath() + "/QuizServlet");
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for answer processing";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.quizsite.servlets;

import com.quiz.quizsite.ejb.ManageQuestionsBean;
import com.site.quizsite.common.QuestionDetails;
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
@WebServlet(name = "EditQuestionFormServlet", urlPatterns = {"/EditQuestionFormServlet"})
public class EditQuestionFormServlet extends HttpServlet {

    @Inject
    ManageQuestionsBean manageQuestionBean;

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
        
        int questionId=Integer.parseInt(request.getParameter("id"));
        QuestionDetails question = manageQuestionBean.findById(questionId);
        request.setAttribute("question", question);
        
        request.getRequestDispatcher("/WEB-INF/pages/editQuestionForm.jsp").forward(request, response);
        
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
        
        String question = request.getParameter("question");
        String choice1 = request.getParameter("answer1");
        String choice2 = request.getParameter("answer2");
        String choice3 = request.getParameter("answer3");
        String choice4 = request.getParameter("answer4");
        int answer = Integer.parseInt(request.getParameter("answer"));
        int question_id=Integer.parseInt(request.getParameter("question_id"));
        
        manageQuestionBean.editQuestion(question_id, question, choice1, choice2, choice3, choice4, answer);
        
        response.sendRedirect(request.getContextPath() + "/ListQuestionsToEditServlet");
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

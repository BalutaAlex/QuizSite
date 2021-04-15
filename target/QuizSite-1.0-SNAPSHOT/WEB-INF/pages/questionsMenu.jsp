<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Manage Quiz">
    <div class="container">
        <div class="flex-column flex-center">                                
            <a href="${pageContext.request.contextPath}/AddNewQuestionServlet" class="btn">Adauga o intrebare noua</a>         
            <a href="${pageContext.request.contextPath}/ListQuestionsToEditServlet" class="btn">Editeaza o intrebare</a>
            <a href="${pageContext.request.contextPath}/DeleteQuestionServlet" class="btn">Sterge o intrebare</a>
            <a href="${pageContext.request.contextPath}" class="btn">Pagina principala</a>
        </div>
    </div>
</t:pageTemplate>
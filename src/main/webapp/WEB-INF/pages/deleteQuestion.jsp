<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Stergere Intrebare">

    <div class="container">          
        <div id="deleteQuestion" class=" flex-column flex-center">
            
            <a href="${pageContext.request.contextPath}/QuestionsOperationsMenuServlet" class="btn-back">Înapoi</a>
            <div class="margin-bottom"></div>
            
            <form method="POST" action="${pageContext.request.contextPath}/DeleteQuestionServlet">
                <c:forEach var="question" items="${questions}" varStatus="status">
                    <div class="flex-row">
                        <button class="btn-delete" type="submit" name="deleteQuestionBtn" value="${question.id}">Sterge</button>  
                        <p class="padding-left">${question.question}</p>  
                    </div>
                </c:forEach>

            </form> 
        </div>

    </div>
</t:pageTemplate>

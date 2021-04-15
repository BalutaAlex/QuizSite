<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Score">
    <div class="container">
        <div id="end" class="flex-column flex-center">           
            <h1>Scor: ${finalScore}/${numberOfQuestions}</h1>
            <!-- aici mesaj in functie de ce scor are /// de implementat-->            
            <a href="${pageContext.request.contextPath}/NewQuizServlet" class="btn">Încă o rundă</a>
            <a href="index.jsp" class="btn">Pagina Principală</a>
            
        </div>
    </div>
</t:pageTemplate>

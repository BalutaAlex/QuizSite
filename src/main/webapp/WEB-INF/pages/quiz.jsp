<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="Quiz">
<form method="POST" action="${pageContext.request.contextPath}/QuizServlet">
    <div class="container">
        <div id="game" class="justify-center flex-column">
            <div id="hud">
                <div class="hud-item">
                    <p id="progressText" class="hud-prefix">
                        Question ${currentQuestion}/${numberOfQuestions}
                    </p>
                    <div id="progressBar">
                        <div id="progressBarFull"></div>
                    </div>
                </div>
                <div class="hud-item">
                    <p class="hud-prefix">
                        Raspunsuri Corecte
                    </p>
                    <h1 class="hud-main-text" id="score">
                        ${score}
                    </h1>
                </div>
            </div>
            <h1 id="question">${question.question}</h1>
            <button class="choice-container choice-text" type="submit" name="answer1Btn" value="1">A.  ${question.choice1}</button>
            <button class="choice-container choice-text" type="submit" name="answer2Btn" value="2">B.  ${question.choice2}</button>
            <button class="choice-container choice-text" type="submit" name="answer3Btn" value="3">C.  ${question.choice3}</button>
            <button class="choice-container choice-text" type="submit" name="answer4Btn" value="4">D.  ${question.choice4}</button>
        </div>
    </div>
</form>

</t:pageTemplate>

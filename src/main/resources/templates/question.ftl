<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${questionPage.title}}</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2 class="text-center text-info">Spring Boot Freemarker Tutorial</h2><hr/>


               <form action="/freemarker/question/DetailsFlow" method="post">
                    <div><h4>${questionPage.questionText}</h4></div>
                     <input type="hidden" name="question" value="${questionPage.questionText}">
                     <input type="hidden" name="questionId" value="${questionPage.id}">
                    <#if questionPage.questionType?hasContent &&  questionPage.questionType == "dropdown">
                        <select name="answer">
                        <#list questionPage.options as key, value>
                        <option value="${key}">${value}</option>
                        </#list>
                        </select>
                     <#else>
                    <input type="text" name="answer" value="${(answer.answer)!""}""/>
                    </#if>
                    <br/><br/>
                    <input type="submit" value="Submit"/>
                </form>
                </div>

</body>
</html>
<%--
  ~ The MIT License (MIT)
  ~
  ~ Copyright (c) 2013 Jude Pereira
  ~
  ~ Permission is hereby granted, free of charge, to any person obtaining a copy of
  ~ this software and associated documentation files (the "Software"), to deal in
  ~ the Software without restriction, including without limitation the rights to
  ~ use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
  ~ the Software, and to permit persons to whom the Software is furnished to do so,
  ~ subject to the following conditions:
  ~
  ~ The above copyright notice and this permission notice shall be included in all
  ~ copies or substantial portions of the Software.
  ~
  ~ THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  ~ IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
  ~ FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
  ~ COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
  ~ IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
  ~ CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Jude Pereira
  Date: 10/11/13
  Time: 9:24 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questionnaire</title>
</head>
<body>
<h1>Questionnaire</h1>

<form action="servlets/check" method="get">
    <label>What language are servlets written in?</label><br>
    <input type="radio" name="lang" value="java">Java<br>
    <input type="radio" name="lang" value="py">Python<br>
    <input type="radio" name="lang" value="c">C<br>
    <input type="radio" name="lang" value="pl">Perl<br>
    <br><br>
    <label>What type of content do servlets produce?</label><br>
    <input type="radio" name="type" value="static">Static<br>
    <input type="radio" name="type" value="dynamic">Dynamic<br>
    <input type="radio" name="type" value="all">Both of the above<br>
    <input type="radio" name="type" value="none">Neither of the above<br>
    <br><br>
    <label>Which of the following is not a servlet container?</label><br>
    <input type="radio" name="cont" value="tc">Apache Tomcat<br>
    <input type="radio" name="cont" value="resin">Caucho Resin<br>
    <input type="radio" name="cont" value="jb">JBoss<br>
    <input type="radio" name="cont" value="nginx">Nginx<br>
    <br><br>
    <input type="submit" value="Check answers">
</form>
</body>
</html>
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
  Time: 10:19 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>

<form action="servlets/calc" method="post">
    First number: <input type="text" name="n1"><br>
    Second number: <input type="text" name="n2"><br>
    <input type="radio" name="op" value="+">+
    <input type="radio" name="op" value="-">-
    <input type="radio" name="op" value="/">/
    <input type="radio" name="op" value="*">*
    <input type="radio" name="op" value="%">%
    <br>
    <input type="submit" value="Calculate">
</form>
</body>
</html>
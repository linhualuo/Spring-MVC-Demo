<%--
  Created by IntelliJ IDEA.
  User: Joseph
  Date: 2017/9/11
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Page</title>
</head>
<body>
    <div class="upload">
        <form action="upload" enctype="multipart/form-data" method="post">
            <input type="file" name="file" /><br/>
            <input type="submit" value="上传" /><br/>
        </form>
    </div>
</body>
</html>

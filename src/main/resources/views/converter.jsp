<%--
  Created by IntelliJ IDEA.
  User: Joseph
  Date: 2017/9/11
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HttpMessageConverter Demo</title>
</head>
<body>
    <div id="resp"></div>
        <input type="button" onclick="req();" value="请求" />

    <script src="assets/js/jquery.js" type="text/javascript"></script>
    <script>
        function req() {
            $.ajax({
                url:"convert",
                data:"1-hualuo",
                type:"POST",
                contentType:"application/x-hualuo",
                success: function (data) {
                    $("#resp").html(data);
                }
            });
        }
    </script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Joseph
  Date: 2017/9/11
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>servlet async support</title>
</head>
<body>
    <script src="assets/js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">

        deferred();
        function deferred() {
            $.get('defer', function (data) {
                console.log(data);
                deferred();
            });
        }
    </script>
</body>
</html>

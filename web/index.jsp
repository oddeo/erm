<%-- 
    Document   : index
    Created on : Mar 4, 2014, 12:03:43 AM
    Author     : danieljones
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERM RESTful Web Service</title>
        <style>
            table, td { border: 1px #999 dotted; width: 600px; }
        </style> 
    </head>
    <body>
        <h1>ERM RESTful Web Service</h1>
        <a href="/erm/rest/application.wadl">Application WADL</a>
        <br />
        <br />
        <strong>Employee XML Example</strong>: The id is only required when 
        updating an existing employee
        <br />
        &lt;employee&gt;<br />
        &nbsp;&nbsp;&lt;firstName&gt;dan&lt;/firstName&gt;<br />
        &nbsp;&nbsp;&lt;lastName&gt;jones&lt;/lastName&gt;<br />
        &nbsp;&nbsp;&lt;manager&gt;bob&lt;/manager&gt;<br />
        &nbsp;&nbsp;&lt;id&gt;1&lt;/id&gt;<br />
        &lt;/employee&gt;
    </body>
</html>

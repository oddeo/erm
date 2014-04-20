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
        &nbsp;&nbsp;&lt;id&gt;1&lt;/id&gt;<br />
        &lt;/employee&gt;
        <br />
        <br />
        <strong>Comment XML Example</strong>
        <br />
        &lt;comment&gt;<br />
        &nbsp;&nbsp;&lt;text&gt;comment text&lt;/text&gt;<br />
        &nbsp;&nbsp;&lt;employeeId&gt;1&lt;/employeeId&gt;<br />
        &nbsp;&nbsp;&lt;authorId&gt;1&lt;/authorId&gt;<br />
        &lt;/comment&gt;
        <br />
        <br />
        <strong>Author XML Example</strong>: The id is only required when 
        updating an existing author
        <br />
        &lt;author&gt;<br />
        &nbsp;&nbsp;&lt;firstName&gt;bill&lt;/firstName&gt;<br />
        &nbsp;&nbsp;&lt;lastName&gt;plimpton&lt;/lastName&gt;<br />
        &nbsp;&nbsp;&lt;id&gt;1&lt;/id&gt;<br />
        &lt;/author&gt;
        <br />
        <br />       
    </body>
</html>

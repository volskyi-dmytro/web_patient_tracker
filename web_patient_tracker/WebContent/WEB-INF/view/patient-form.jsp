<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
   <title>Save Patient </title>
   
   <link type="text/css"
         rel="stylesheet"
         href="${pageContext.request.contextPath}/resources/css/style.css"> 
   
   <link type="text/css"
         rel="stylesheet"
         href="${pageContext.request.contextPath}/resources/css/add-patient-style.css"> 
   
</head>

<body>

     <div id="wrapper">
        <div id="header">
              <h2>PRM - Patient Relationship Manager</h2>        
        
        </div>
     
     </div>
        
         <div id="container">
            <h3>Save Patient</h3>
         
            <form:form action="savePatient" modelAttribute="patient" method="POST"> 
            
           
            
            <table>
               <tbody>
                  <tr>
                    <td><label>First name:</label></td>
                    <td><form:input path="firstName"/><td>                                    
                  </tr>
                  
                  <tr>
                    <td><label>Last name:</label></td>
                    <td><form:input path="lastName"/><td>                                    
                  </tr>
                  
                  <tr>
                    <td><label>Phone number:</label></td>
                    <td><form:input path="phoneNumber"/><td>                                    
                  </tr>
                  
                  <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email"/><td>                                    
                  </tr>
                  
                  <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"/><td>                                    
                  </tr>
               
               
               </tbody>
            
            
            </table>
            </form:form>
            
            <div style="clear; both;"></div>
            <p>
               <a href="${pageContext.request.contextPath}/patient/list">Back to list</a>
            
            </p>
            
         </div>

</body>


</html>
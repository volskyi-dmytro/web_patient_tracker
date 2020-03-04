<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
     <title>List of the Patients </title>
     <!-- reference style sheet -->
     
     <link type="text/css"
           rel="stylesheet"
           href="${pageContext.request.contextPath}/resources/css/style.css" /> 
      
      
      
</head>

<body>

   <div id="wrapper">
      <div id="header" >
          <h2>PRM - Patient Relationship Manager </h2>
      
      </div>    
   </div>
   
   <div id="container">
        <div id="content">
            
               <input type="button" value="Add Patient" 
                   onclick="window.location.href='showFormForAdd';return false;"
                   class="add-button"
               />
            
              
                <table>
                   <tr>
                       <th>First Name</th>
                       <th>Last Name</th>
                       <th>Phone number</th>
                       <th>Email</th>
                        
                    </tr>
                    
                    <c:forEach var="tempPatient" items="${patients}"> 
                           
                           <tr>
                               <td>${tempPatient.firstName} </td>
                               <td>${tempPatient.lastName} </td>
                               <td>${tempPatient.phoneNumber} </td>
                               <td>${tempPatient.email} </td>
                           
                           </tr>
                    
                    </c:forEach>
                    
                    
                                    
                </table>
        
        </div>
   
   </div>

</body>


</html>
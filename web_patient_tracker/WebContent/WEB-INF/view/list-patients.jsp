<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
          
          <a href="${pageContext.request.contextPath}/patient/list"><h2>PRM - Patient Relationship Manager </h2></a>
      
      </div>    
   </div>
   
   <div id="container">
        <div id="content">
            
               <form:form action="search" method="GET">
                Search patient: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
               
               <input type="button" value="Add Patient" 
                   onclick="window.location.href='showFormForAdd';return false;"
                   class="add-button"
               />
               
               <div class="map-responsive">
               <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2524.7868788814735!2d24.15547771595164!3d50.742441574162875!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4724f393fcd2e67f%3A0xb56b8ef46a052eab!2sDental%20office%2032%20Pearls!5e0!3m2!1sru!2sua!4v1583431368584!5m2!1sru!2sua" width="200" height="200" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
               </div>
               
            
              
                <table>
                   <tr>
                       <th>First Name</th>
                       <th>Last Name</th>
                       <th>Phone number</th>
                       <th>Email</th>
                       <th>Action</th>
                        
                    </tr>
                    
                    <c:forEach var="tempPatient" items="${patients}"> 
                          
                          <!-- creating variable with update-link for each patient
                           -->
                          <c:url var="updateLink" value="/patient/showFormForUpdate">
                             <c:param name="patientId" value="${tempPatient.id}"/>
                          </c:url>
                          
                          <!-- creating variable with delete-link for each patient
                           -->
                          <c:url var="deleteLink" value="/patient/delete">                                                
                             <c:param name="patientId" value="${tempPatient.id}"/>
                          </c:url>
                           
                           <tr>
                               <td>${tempPatient.firstName} </td>
                               <td>${tempPatient.lastName} </td>
                               <td>${tempPatient.phoneNumber} </td>
                               <td>${tempPatient.email} </td>
                               <td>
                                 <a href="${updateLink}">Update</a> 
                                 |
                                 <a href="${deleteLink}"
                                 onclick="if(!(confirm('Are you sure to delete this patient?'))) return false">Delete</a>
                               </td>
                           
                           </tr>
                    
                    </c:forEach>
                    
                    
                                    
                </table>
        
        </div>
   
   </div>

</body>


</html>
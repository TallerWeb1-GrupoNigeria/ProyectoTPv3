<%@ include file="_headerLogin.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


		<div class = "container">
			<div class="row justify-content-md-center">
			<div id="loginbox" style="margin-top:50px;" class="col-md-6  col-sm-8">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
					<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
				<form:form action="validar-login" method="POST" modelAttribute="usuario">
			    	<h3 class="form-signin-heading">Taller Web I</h3>
					<hr class="colorgraph"><br>

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<p>Email: </p>
					<form:input path="email" id="email" type="email" class="form-control" />
					<br/>
					<p>Contrase�a</p>
					<form:input path="password" type="password" id="password" class="form-control"/>     		  
					<br/>
					<button class="btn btn-lg btn-primary btn-block" Type="Submit">Login</button>
				</form:form>

				<%--Bloque que es visible si el elemento error no está vacío	--%>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
			</div>
		</div>
  <%@ include file="_footer.jsp" %>

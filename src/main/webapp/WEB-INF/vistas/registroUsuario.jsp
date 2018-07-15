<<<<<<< HEAD
<%@ include file="_header.jsp" %> 
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKsOyLppGoYEHhTvwny8xDgKj96ZzSIFU&libraries=places&callback=initAutocomplete" async defer></script>
<script src="js/mapas2.js"></script>

<div class="container" id="contenedor_form">		
		<div class="form-group" align="center"> <p class="subtitulo"><h4>Formulario de Registro </p></h4> </div>
		<hr id="hr">
		<c:if test="${not empty error}">
		<div class="alert alert-warning ">
		    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		    <strong>Warning!</strong> <span> ${error}</span> 
		  </div>
		  </c:if>
		 		  
		<form:form modelAttribute="usuarioRegistro" class="" method="POST" action="registrovalidar">
   			
   			<div class="form-group">
				<label for="nombre">Nombre: </label>
				<form:input type="text" path="nombre" class="input form-control"/>
			</div>

			<div class="form-group">
				<label for="e-mail">E-mail: </label>
				<form:input type="text" path="email" class="input form-control"/>
			</div>
			
			<div class="form-group">
				<label for="contraseña">Password: </label>
				<form:input type="password" path="password" class="input form-control"/>
			</div>

			
			<div class="form-group">
				<label for="nombre">rol: </label>
				<form:input type="text" path="rol" class="input form-control"/>
			</div>

			<div class="form-group botones">
				<button class="btn btn-primary boton" type="submit">Aceptar</button>
				<button class="btn btn-primary boton" type="reset">Cancelar</button>
			</div>
				
			</form:form>
			
    </div>
   
	<!-- FIN FORMULARIO -->
	 <%@ include file="_footer.jsp" %>
=======

<%@ include file="_header.jsp" %>



<div class="container" id="contenedor_form">    
	 
	  <br />
	<div class="row">

	 <div class="col-md-12">

	  <form:form action="registrovalidar" method="POST" modelAttribute="usuarioRegistro">
	
	   <div class="form-group">
	    <label>Nombre:</label>
	       <form:input path="nombre" type="text" id="nombre" class="input form-control" />
	       <small class="form-text text-muted">Nombre</small>
	   </div>
	   
	   <div class="form-group">
	    <label>Email:</label>
	       <form:input path="email" type="text" id="email" class="input form-control"/>
	   </div>
	
	   <div class="form-group">
	    <label>Contraseña:</label>
	    <form:input path="password" type="password" id="password" class="input form-control" />
	   </div>
	   
	  <%--  <c:if test="${ not empty user } "> --%>
	   		<div class="form-group">
	    		<label>Rol:</label>
	       		<form:select path="rol" id="rol" class="input form-control">
			    	<form:option value="user">Usuario</form:option>
			    </form:select>
	   		</div>	   
<%-- 	   </c:if> --%>
	   
	   <c:if test="${ not empty admin } ">
	   		<div class="form-group">
			    <label>Rol:</label>
			    <form:select path="rol" id="rol" class="input form-control">
			    	<form:option value="user">Usuario</form:option>
			      	<form:option value="admin">Administrador</form:option>
			    </form:select>
			 </div>
	   
	   </c:if>
	   
	   
	   
	   
	    <div class="form-group">
		    <label>Foto:
		    	<small class="form-text text-muted">(Importante!) Seleccione una foto que esten dentro de la carpeta img/</small>
		    </label><br/>
	        <form:input path="foto" type="file" accept=".jpg,.jpeg,.png" id="foto" name="foto" class=""/>
	    </div>	
	    
		<br />
	   <div class="form-group botones">
	    <button class="btn btn-primary boton" type="submit">Crear</button>&nbsp;&nbsp;
	    <button class="btn btn-danger boton" type="reset">Reset</button>
	   </div>
	
	  </form:form>
    </div>
    
    
   </div>
 </div>

<br />
 
<%@ include file="_footer.jsp" %>
 
 
 
 
 
 
 
 
>>>>>>> branch 'master' of https://github.com/TallerWeb1-GrupoNigeria/ProyectoTPv3.git

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
				<label for="repetircontraseña">Repetir Password: </label>
				<form:input type="password" path="repassword" class="input form-control"/>
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
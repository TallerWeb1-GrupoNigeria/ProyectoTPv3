
<%@ include file="_header.jsp" %>
<%@ include file="menuUsuario.jsp" %>


 <div class="container" id="contenedor_form">    
			
			<!-- SE AGREGO LA FUNCION IF DE 'SI' PARA MOSTRAR Y 'NO' PARA NO MOSTRAR EL EVENTO -->
			 <div class="col-md-2">
			 
			   <div class="card">
			     <img class="card-img-top" src="img/${foto}" alt="Card image cap">
			   </div>
			 </div>
	  <br />
	  <form:form action="validarActualizarUsuario" method="POST" modelAttribute="keyUsuario">
	
	   <form:input path="id" type="hidden" id="id" class="input form-control" placeholder="${ usuario.getId() }"/>
	
	   <div class="form-group">
	    <label>Nombre del Usuario:</label>
	       <form:input path="nombre" type="text" id="nombre" class="input form-control" placeholder="${ usuario.getNombre() }"/>
	   </div>

	   <div class="form-group">
	    <label>Email:</label>
	       <form:input path="email" type="text" id="email" class="input form-control" placeholder="${ usuario.getEmail() }"/>
	   </div>   
	    <div class="form-group">
	    <label>Contraseña:</label>
	       <form:input path="password" type="password" id="password" class="input form-control" placeholder="${ usuario.getPassword }"/>
	   </div>
	   
	   <div class="form-group">
	    <label>Rol</label>
	       <form:input path="rol" type="text" id="rol" class="input form-control" placeholder="${ usuario.getRol() }"/>
	   </div>
	    <div class="form-group">
		    <label>Foto:
		    	<small class="form-text text-muted">(Importante!) Seleccione imagenes que esten dentro de la carpeta img/</small>
		    </label><br/>
	    </div>
	     <form:input path="foto" type="file" accept=".jpg,.jpeg,.png" id="foto" name="foto" class="" value="${usuario.getFoto}" />
		<br />
	   <div class="form-group botones">
	    <button class="btn btn-primary boton" type="submit">Modificar Perfil</button>&nbsp;&nbsp;
	    <a href="homeUsuario" class="btn btn-danger boton">Cancelar</a>
	   </div>
	
	  </form:form>
<br />
</div>
 
<%@ include file="_footer.jsp" %>
 
 
 
 
 
 
 
 
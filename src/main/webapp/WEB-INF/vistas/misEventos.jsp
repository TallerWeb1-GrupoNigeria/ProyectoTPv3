
<%@ include file="_header.jsp" %>
<%-- <%@ include file="_menuAdmin.jsp" %> --%>

  
  <div class="py-2">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <table class="table">
           
            <thead>
              <tr>
              	<th>Portada</th>
                <th>Nombre Del Evento</th>
                <th>Fecha</th>
                <th>HoraDeInicio</th>
                <th>HoraDeFin</th>
                <th>Acciones</th>
                

              </tr>
            </thead>
            
            <tbody>
            	<c:forEach items="${ keyListadoEventos }" var="carrito">
            		<tr>
		            	<td class="align-middle">
            				<a href="#" class="thumbnail"><img src="img/${ carrito.evento.getImagen1() }" alt="miniMagen" width="75" height="auto"></a>
    					</td>
		                <td class="align-middle">${ carrito.evento.getNombre() }</td>
		                <td class="align-middle">${ carrito.evento.getFecha() }</td>
		                <td class="align-middle">${ carrito.evento.getHoraInicio() }</td>
		                <td class="align-middle">${ carrito.evento.getHoraFin() }</td>
		                <td class="align-middle">
		                	<a href="#">Detalle</a>
		                	<a href="eliminarEventoDeCarrito?id=${ carrito.getId() }">Quitar </a>|
		                </td>
	                </tr>
            	</c:forEach>
            </tbody>
            
          </table>
          <a href="vaciarCarrito?id=1">Vaciar Carrito</a>
          
        </div>
      </div>
    </div>
  </div>

  

   <%@ include file="_footer.jsp" %>
 
 
<%@ include file="_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/bootstrap-select.min.css">
<link rel="stylesheet" href="css/estilo-mapa.css" type="text/css">

<script src="js/bootstrap-select.min.js" defer></script>
<script src="js/mapas.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKsOyLppGoYEHhTvwny8xDgKj96ZzSIFU&libraries=places&callback=initAutocomplete"> </script>


	<div class="py-2">
    	<div class="container">
			<div class="row">

				<!-- CARROUSEL -->

				<div class="col-md-8">
					<div id="carousel" class="carousel slide" data-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img class="d-block img-fluid w-100" src="img/carousel-img1.jpg">
								<div class="carousel-caption">
									<h3>First slide label</h3>
									<p>Duerme todo el día, ve de fiesta toda la noche, nunca envejezcas, nunca mueras.</p>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid w-100" src="img/carousel-img2.jpg">
								<div class="carousel-caption">
									<h3>Second slide label</h3>
									<p>Las aventuras comienzan cuando estás dispuesto a celebrar.</p>
								</div>
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid w-100" src="img/carousel-img3.jpg">
								<div class="carousel-caption">
									<h3>Second slide label</h3>
									<p>Las aventuras comienzan cuando estás dispuesto a celebrar.</p>
								</div>
							</div>
						</div>
						<a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev"> 
							<span class="carousel-control-prev-icon"></span>
							<span class="sr-only">Anterior</span>
						</a> 
						<a class="carousel-control-next" href="#carousel" role="button" data-slide="next"> 
							<span class="carousel-control-next-icon"></span>
							<span class="sr-only">Siguente</span>
						</a>
					</div>
				</div>

				<!-- BANNER LADO DERECHO -->
				<div class="col-md-4">
				<!-- MAPA  -->
					<h3>Dónde vas a salir hoy <span>${nombre}?</span></h3>
					<input id="pac-input" class="controls" type="text" placeholder="Buscar...">
					<div id="map"></div>
					<div id="resultados"></div>
					<!--div class="blockquote">
						<p class="mb-0">Blockquoute</p>
						<div class="blockquote-footer">Someone famous in My memories</div>
					</div>
					<div class="blockquote">
						<p class="mb-0">Blockquoute</p>
						<div class="blockquote-footer">Someone famous in My memories</div>
					</div>
					<div class="blockquote">
						<p class="mb-0">Blockquoute</p>
						<div class="blockquote-footer">Someone famous in My memories</div>
					</div-->
				</div>
				
			</div>
	

	<!-- BUSCADOR -->
	<div class="row py-2">
		<div class="col-md-12">
			<form:form action="filtros-Busqueda" method="POST" modelAttribute="evento">
		    	<p>Buscar Evento por nombre</p>
				<form:input path="nombre" type="text" id="nomb" class="form-control"/>     		  
				<br/>
				<button class="btn btn-lg btn-primary btn-block" Type="Submit">Buscar</button>
		    </form:form>
		</div>
    </div>

	<!-- 2 CARDS -->
	<!-- LISTA DE EVENTOS  -->
      <div class="row py-2">
      	<c:forEach items="${keyListarEventos}" var="evento">
			
			<!-- SE AGREGO LA FUNCION IF DE 'SI' PARA MOSTRAR Y 'NO' PARA NO MOSTRAR EL EVENTO -->
			<c:if test="${ evento.getMostrar() eq 'si' }">
			 <div class="col-md-4">
			 
			   <div class="card">
			     <img class="card-img-top" src="img/${evento.getImagen1()}" alt="Card image cap">
			     <div class="card-body">
			       <h5 class="card-title">${ evento.getNombre() }</h5>
			       <p class="card-text">${ evento.getDescripcion() }</p>
			       <a href="#" class="btn btn-primary">+ Detalles </a>&nbsp;&nbsp;&nbsp;&nbsp;
			       <a href="agregarEventoAlCarrito?id=${ evento.getId() }" class="btn btn-success">Agregar</a>
			     </div>
			   </div>
			 </div>
			</c:if>
			
		</c:forEach>
        
      </div>
      
      <div class="row">
        <div class="col-md-12">
          <ul class="pagination">
            <li class="page-item">
              <a class="page-link" href="#">
                <span>«</span>
                <span class="sr-only">Previous</span>
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">1</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">2</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">3</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">4</a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                <span>»</span>
                <span class="sr-only">Next</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
      
    </div>
  </div>
  <script>
</script>
  
  <%@ include file="_footer.jsp" %>
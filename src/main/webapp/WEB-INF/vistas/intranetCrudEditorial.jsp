<jsp:include page="intranetValida.jsp" />
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Cache-Control" content="private" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/global.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>

<title>Intranet</title>
</head>
<body>
<jsp:include page="intranetCabecera.jsp" />
<div class="container" style="margin-top: 4%"><h4>CRUD Editorial</h4></div>

<div class="container" style="margin-top: 1%">
<!-- Agregar aquí -->
	
	 <div class="row" style="height: 70px">
						<div class="col-md-2" >
								<input class="form-control" id="id_ruc_filtro"  name="filtro" placeholder="Ingrese el Ruc" type="text" maxlength="30"/>
						</div>
						
						<div class="col-md-2" >
							<button type="button" class="btn btn-primary" id="id_btn_filtrar" style="width: 150px">FILTRA</button>
						</div>
						
						<div class="col-md-2">
							<button type="button" data-toggle='modal'  data-target="#id_div_modal_registra"  class='btn btn-success' style="width: 150px">REGISTRA</button>
						</div>
					</div>
					<div class="row" > 
						<div class="col-md-12">
								<div class="content" >
						
									<table id="id_table" class="table table-striped table-bordered" >
										<thead>
											<tr>
												<th style="width: 5%" >ID</th>
												<th style="width: 25%">Raz&oacute;n Social</th>
												<th style="width: 8%">Direcci&oacute;n</th>
												<th style="width: 8%">Ruc</th>
											    <th style="width: 8%">Fecha Registro</th>
												<th style="width: 8%">Id Pa&iacute;s</th>
												<th style="width: 10%">Actualiza</th>
												<th style="width: 10%">Elimina</th>
											</tr>
										</thead>
											<tbody>
											</tbody>
										</table>
								</div>	
						</div>
					</div>



	
	
	
</div>

<script type="text/javascript">
<!-- Agregar aquí -->
function agregarGrilla(Editorial){
	 $('#id_table').DataTable().clear();
	 $('#id_table').DataTable().destroy();
	 $('#id_table').DataTable({
			data: Editorial,
			searching: false,
			ordering: true,
			processing: true,
			pageLength: 5,
			lengthChange: false,
			columns:[
				{data: "idEditorial"},
				{data: "razonSocial"},
				{data: "direccion"},
				{data: "ruc"},
				{data: "fechaCreacion"},
				{data: "pais.nombre"},
				{data: "estado"},
				{data: "estado"},
																
			]                                     
	    });
}



$("#id_btn_filtrar").click(function(){
	var fil=$("#id_ruc_filtro").val();
	$.getJSON("consultaCrudEditorial",{"filtro":fil}, function (Editorial){
		agregarGrilla(Editorial);
	});
});

</script>   		
</body>
</html>
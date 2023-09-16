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
<link rel="stRegistro Pruebaylesheet" href="css/bootstrapValidator.css"/>

<title>Intranet</title>
</head>
<body>
<jsp:include page="intranetCabecera.jsp" />
<div class="container" style="margin-top: 4%"><h4>Registro Tesis</h4></div>

<div class="container" style="margin-top: 1%">
	<form  id="id_form" method="post"> 
	 <div class="col-md-12" style="margin-top: 2%">
			<div class="row">
				<div class="form-group col-md-9">
					<label class="control-label" for="id_titulo">Tìtulo</label>
					<input class="form-control" type="text" id="id_titulo" name="titulo" placeholder="Ingrese la descripción">
				</div>
				<div class="form-group col-md-9">
					<label class="control-label" for="id_tema">Tema</label>
					<input class="form-control" type="text" id="id_descripcion" name="descripcion" placeholder="Ingrese la descripción">
				</div>
				<div class="form-group  col-sm-6">
				<div class="col-sm-4">
					<label class="control-label" for="id_fechaCreacion">Fecha de Creaciòn</label>
				</div>
				<div class="col-sm-6">
					<input class="form-control" type="date" id="id_fechaInicio" name="fechaInicio" placeholder="Ingrese la fecha Inicio" maxlength="100">
		 		</div>
			</div>
				<div class="form-group col-md-3">
					<label class="control-label" for="id_pais">Alumno</label>
					<select id="id_pais" name="pais.idPais" class='form-control'>
						<option value=" ">[Seleccione]</option>    
					</select>
			    </div>
			</div>
		    <div class="row">
				<div class="form-group col-md-12" align="center">
					<button id="id_registrar" type="button" class="btn btn-primary" >Registra</button>
				</div>
			</div>
	</div>
	</form>
</div>

<script type="text/javascript">
<!-- Agregar aquí -->


</script>   		
</body>
</html>
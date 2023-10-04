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
<div class="container" style="margin-top: 4%"><h4>CRUD Tesis</h4></div>

<div class="container" style="margin-top: 1%">
<div class="row" style="height: 70px">
						<div class="col-md-2" >
								<input class="form-control" id="id_txt_filtro"  name="filtro" placeholder="Ingrese el nombre" type="text" maxlength="30"/>
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
												<th style="width: 5%" >Código</th>
												<th style="width: 17%">Título</th>
												<th style="width: 18%">Tema</th>
												<th style="width: 10%">Fecha Creación</th>
												<th style="width: 17%">Alumno</th>
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


<!-- REGISTRAR TESIS-->
		<div class="modal fade" id="id_div_modal_registra">
			<div class="modal-dialog" style="width: 60%">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="padding: 35px 50px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-ok-sign"></span> Registro de
							Tesis
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_registra" accept-charset="UTF-8"
							action="registraActualizaCrudTesis" class="form-horizontal"
							method="post">
							<div class="panel-group" id="steps">
								<!-- Step 1 -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne">Datos de Modalidad</a>
										</h4>
									</div>
									<div id="stepOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_reg_titulo">Título</label>
												<div class="col-lg-8">
													<input class="form-control" id="id_reg_titulo"
														name="titulo" placeholder="Ingrese el título" type="text"
														maxlength="20" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_reg_tema">Tema</label>
												<div class="col-lg-8">
													<input class="form-control" id="id_reg_tema"
														name="tema" placeholder="Ingrese el tema" type="text"
														maxlength="20" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_reg_fechaCreacion">Fecha de Creación</label> 
													<div class="col-lg-8">
												<input class="form-control" type="date" id="id_reg_fechaCreacion" name="fechaCreacion"
												placeholder="Ingrese la fecha de creación" maxlength="100">
												</div>
												</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_reg_alumno">Alumno</label>
												<div class="col-lg-8">
													<select id="id_reg_alumno" name="alumno" class='form-control'>
														<option value=" ">[Seleccione]</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<div class="col-lg-9 col-lg-offset-3">
													<button type="button" class="btn btn-primary"
														id="id_btn_registra">REGISTRAR</button>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</form>
					</div>
					</div>
					</div>
				</div>




<script type="text/javascript">
$("#id_btn_filtrar").click(function(){
	var fil=$("#id_txt_filtro").val();
	$.getJSON("consultaCrudTesis",{"filtro":fil}, function (lista){
		agregarGrilla(lista);
	});
});

$.getJSON("listaAlumno", {}, function(data) {
	$.each(data, function(index, item) {
		// Se crea una variable que combina los campos "nombres" y "apellidos" para formar el nombre completo
		var nombreCompleto = item.nombres + " " + item.apellidos;
		$("#id_reg_alumno").append(
				"<option value=" + item.idAlumno + ">" + nombreCompleto
						+ "</option>");
	});
});


function agregarGrilla(lista){
	 $('#id_table').DataTable().clear();
	 $('#id_table').DataTable().destroy();
	 $('#id_table').DataTable({
			data: lista,
			searching: false,
			ordering: true,
			processing: true,
			pageLength: 5,
			lengthChange: false,
			columns:[
				{data: "idTesis"},
				{data: "titulo"},
				{data: "tema"},
				{data: "fechaCreacion"},
				{data: "alumno.apellidos"},	
				{data: "estado"},	
				{data: "estado"},	
			]                                     
	    });
}



</script> 

<!-- <script type="text/javascript">

$("#id_form_registra").click(function() {
	var validator = $('#id_form').data('bootstrapValidator');
	validator.validate();

	if (validator.isValid()) {
		$.ajax({
			type : "POST",
			url : "registraCrudTesis",
			data : $('#id_form').serialize(),
			success : function(data) {
				mostrarMensaje(data.MENSAJE);
				validator.resetForm();
				limpiarFormulario();
			},
			error : function() {
				mostrarMensaje(MSG_ERROR);
			}
		});
	}
});


function limpiarFormulario() {
	$('#id_titulo').val(' ');
	$('#id_tema').val(' ');
	$('#id_fechaCreacion').val(' ');
	$('#id_alumno').val(' ');
}


$('#id_form').bootstrapValidator({
	message : 'This value is not valid',
	feedbackIcons : {
		valid : 'glyphicon glyphicon-ok',
		invalid : 'glyphicon glyphicon-remove',
		validating : 'glyphicon glyphicon-refresh'
	},
	fields : {
		titulo : {
			selector : '#id_reg_titulo',
			validators : {
				notEmpty : {
					message : 'El título es un campo obligatorio'
				},
				stringLength : {
					message : 'El título es de 2 a 40 caracteres',
					min : 2,
					max : 40
				},
				remote :{
            	    delay: 1000,
            	 	url: 'buscaPorTituloOrTemaTesis',
            	 	message: 'El Título ya existe'
             	}
            }
        },
		tema : {
			selector : '#id_reg_tema',
			validators : {
				notEmpty : {
					message : 'El tema es un campo obligatorio'
				},
				stringLength : {
					message : 'El tema es de 2 a 40 caracteres',
					min : 2,
					max : 40
				},
                remote :{
            	    delay: 1000,
            	 	url: 'buscaPorTituloOrTemaTesis',
            	 	message: 'El Tema ya existe'
             	}
            }
        },
		fechaCreacion : {
			selector : "#id_reg_fechaCreacion",
			validators : {
				notEmpty : {
					message : 'La fecha de creación es obligatorio'
				}
			}
		},
		alumno : {
			selector : '#id_reg_alumno',
			validators : {
				notEmpty : {
					message : 'Alumno es un campo obligatorio'
				},
			}
		},
	}
}); 
</script>-->
  		
</body>
</html>
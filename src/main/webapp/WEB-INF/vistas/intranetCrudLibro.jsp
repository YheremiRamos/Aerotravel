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


<div class="container" style="margin-top: 4%"><h4>CRUD Libro</h4></div>

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
												<th style="width: 10%" >ID</th>
												<th style="width: 15%">Titulo</th>
												<th style="width: 10%">A&ntildeo</th>
												<th style="width: 15%">Serie</th>
											    <th style="width: 15%">Categoria</th>
												<th style="width: 15%">Tipo</th>
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


<div class="modal fade" id="id_div_modal_registra" >
	<div class="modal-dialog" style="width: 60%">

		<!-- Modal content-->
		<div class="modal-content">
		<div class="modal-header" style="padding: 35px 50px">
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4><span class="glyphicon glyphicon-ok-sign"></span> Registro de Libro</h4>
		</div>
		<div class="modal-body" style="padding: 20px 10px;">
			<form id="id_form_registra" accept-charset="UTF-8" action="registraActualizaCrudLibro" class="form-horizontal"     method="post">
                   <div class="panel-group" id="steps">
                       <!-- Step 1 -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos de Libro</a></h4>
                            </div>
                            <div id="stepOne" class="panel-collapse collapse in">
                                <div class="panel-body">
                                     <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_reg_titulo">Titulo</label>
                                        <div class="col-lg-6">
											<input class="form-control" id="id_reg_titulo" name="titulo" placeholder="Ingrese el titulo" type="text" maxlength="40"/>
                                        </div>
                                    </div>
                             
                                 	<div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_reg_anio">Año</label>
                                        <div class="col-lg-4">
											<input class="form-control" id="id_reg_anio" name="anio" type="date"/>
                                        </div>
                                    </div>	
                             
                             
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_reg_serie">Serie</label>
                                        <div class="col-lg-6">
											<input class="form-control" id="id_reg_serie" name="serie" placeholder="Ingrese la serie" type="text" maxlength="9"/>
                                        </div>
                                    </div>
             
                        	   
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_reg_categoria">Categoria</label>
                                        <div class="col-lg-4">
											 <select id="id_reg_categoria" name="categoria" class='form-control'>
					                            	<option value=" ">[Seleccione]</option>    
					                         </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_reg_tipo">Tipo</label>
                                        <div class="col-lg-4">
											 <select id="id_reg_tipo" name="tipo" class='form-control'>
					                            	<option value=" ">[Seleccione]</option>    
					                         </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-9 col-lg-offset-3">
                                        	<button type="button" class="btn btn-primary" id="id_btn_registra">REGISTRA</button>
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

<div class="modal fade" id="id_div_modal_actualiza" >
			<div class="modal-dialog" style="width: 60%">
		
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Actualiza Libro</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_actualiza" accept-charset="UTF-8"  action="registraActualizaLibro" class="form-horizontal"     method="post">
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos del Libro</a></h4>
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_ID">ID</label>
		                                        <div class="col-lg-6">
		                                           <input class="form-control" id="id_ID" readonly="readonly" name="idLibro" type="text" maxlength="8"/>
		                                        </div>
		                                     </div>
		                                     <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_titulo">Titulo</label>
		                                        <div class="col-lg-6">
													<input class="form-control" id="id_act_titulo" name="titulo" placeholder="Ingrese el Titulo" type="text" maxlength="20"/>
		                                        </div>
		                                    </div>
		                                     <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_anio">Año</label>
		                                        <div class="col-lg-4">
													<input class="form-control" id="id_act_anio" name="anio" placeholder="Ingrese el Año" type="date" maxlength="100"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
	                                        <label class="col-lg-3 control-label" for="id_serie">Serie</label>
	                                        <div class="col-lg-6">
												<input class="form-control" id="id_act_serie" name="serie" placeholder="Ingrese la serie" type="text" maxlength="9"/>
	                                        </div>
		                                    </div>    
		                                  
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_act_categoria">Categoria</label>
		                                        <div class="col-lg-4">
													<select id="id_act_categoria" name="categoria" class='form-control'>
							                            	<option value=" ">[Seleccione]</option>    
							                         </select>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_act_tipo">Tipo</label>
                                        <div class="col-lg-4">
											 <select id="id_act_tipo" name="tipo" class='form-control'>
					                            	<option value=" ">[Seleccione]</option>    
					                         </select>
                                        </div>
                                    </div>
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button type="button" class="btn btn-primary" id="id_btn_actualiza">ACTUALIZA</button>
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
	$.getJSON("consultaCrudLibro",{"filtro":fil}, function (lista){
		agregarGrilla(lista);
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
				{data: "idLibro"},
				{data: "titulo"},
				{data: "anio"},
				{data: "serie"},
				{data: "categoriaLibro.idDataCatalogo"},
				{data: "tipoLibro.idDataCatalogo"},
				{data: function(row, type, val, meta){
					var salida='<button type="button" style="width: 90px" class="btn btn-info btn-sm" onclick="editar(\''+row.idLibro + '\',\'' + row.titulo +'\',\'' + row.anio +'\',\''+ row.serie +'\',\''+ row.categoriaLibro.idDataCatalogo +'\',\'' + row.tipoLibro.idDataCatalogo +'\',\'')">Editar</button>';
					return salida;
				},className:'text-center'},	
				{data: function(row, type, val, meta){
				    var salida='<button type="button" style="width: 90px" class="btn btn-warning btn-sm" onclick="accionEliminar(\'' + row.idLibro + '\')">'+ (row.estado == 1? 'Activo':'Inactvo') +  '</button>';
					return salida;
				},className:'text-center'},
			]                                     
	    });
}






</script>   		
</body>
</html>
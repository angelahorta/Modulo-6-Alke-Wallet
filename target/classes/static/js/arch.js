
function fechaActual(){
    var fecha = new Date();
    var dia = fecha.getDate();
    var mes = fecha.getMonth();
    var annio = fecha.getFullYear();
    
    if(dia < 10){
        dia = '0' + dia;
    } 

    if(mes < 10){
        mes = '0' + mes;
    }

    var datetime = dia + "-" + mes  + "-"  + annio
    $('#dateNow').text('Fecha: '+ datetime);
}

fechaActual();

$('#depositoForm').submit(function(event) {
    event.preventDefault();
    $('#contenedor-mensajeDepo').text('Deposito realizado con exito!');
});

$('#envioDineroForm').submit(function(event) {
  event.preventDefault();
  $('#contenedor-mensajeEnvioDinero').text('Deposito realizado con exito!');
});

validate_user = () => {
    // Obtener la URL actual
    var urlParams = new URLSearchParams(window.location.search);

    // Obtener el valor del parámetro 'error'
    var error = urlParams.get('error');

    // Verificar si 'error' es '1' y mostrar el mensaje correspondiente
    if (error !== null && error === 'true') {
        $("#contenedor-mensaje").html("Datos de acceso no válidos. <a class=\"alert-link\" href=\"#\">Favor verificar!</a>");
        $("#contenedor-mensaje").show(50);
    }
}


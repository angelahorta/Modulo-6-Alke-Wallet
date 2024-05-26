// borrar
// credenciales validas

const usuarioValido="1"
const claveValida="1"

const inputUsuario = document.getElementById("usuario");
//var/let - const inputUsuario = $('#usuario').val()
const inputClave = document.getElementById("clave");
const divMensajeContenedor= document.querySelector("#contenedor-mensaje");

function validar(){

 document.getElementById('contenedor-mensaje').innerHTML = '';
 const usuarioIngresado = inputUsuario.value;
 const claveIngresada = inputClave.value;

 const pMensaje = document.createElement('p');

 if(usuarioIngresado == usuarioValido && claveIngresada == claveValida){
     //pMensaje.innerHTML="Bienvenido";
     pMensaje.className="valido";
     location.replace("menu")
 } else{
     pMensaje.innerHTML= "usuario/contraseña incorrecta";
     pMensaje.className="invalido";
 }

 divMensajeContenedor.appendChild(pMensaje);

}
// borrar

$('#loginForm').submit(function(event) {
    event.preventDefault();
    var username = $('#username').val();
    var password = $('#password').val();

    // Verificar las credenciales
    if (username === 'ahorta' && password === '12345') {
      // Credenciales válidas, redirigir a la pantalla de wallet
      window.location.href = 'menu';
    } else {
      // Credenciales inválidas, mostrar mensaje de error
      //alert('Usuario o contraseña invalido. Inténtalo de nuevo.');
      $('#contenedor-mensaje').text('Correo o contraseña invalido. Inténtalo de nuevo.');
    }
  });

      


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
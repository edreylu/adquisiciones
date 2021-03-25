'use strict'
function mensajeActivarInactivar(id,idestatus) {
let modulo = document.getElementById("nombreModulo").value;
console.log(idestatus);
    Swal
        .fire({
            title: idestatus==0?"Activar":"Inactivar",
            text: "¿Desea "+(idestatus==0?"Activar":"Inactivar")+" "+modulo+"?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: "Si",
            cancelButtonText: "No",
        })
        .then(resultado => {
            if (resultado.value) {
                // Hicieron click en "Sí"
          let enabled=idestatus==0?1:0;
          window.location = modulo+"/eliminar/"+id+"/"+enabled;
                
            } else {
                // Dijeron que no
                console.log("*NO se cerro*");
            }
        });
}

function mensajeAltaAnio(anio) {
	let modulo = document.getElementById("nombreModulo").value;
	console.log(anio);
	    Swal
	        .fire({
	            title: "Alta de nuevo año",
	            text: "¿Desea dar de alta el nuevo año? Se desactivará el año anterior",
	            icon: 'warning',
	            showCancelButton: true,
	            confirmButtonText: "Si",
	            cancelButtonText: "No",
	        })
	        .then(resultado => {
	            if (resultado.value) {
	                // Hicieron click en "Sí"
	                window.location = modulo+"/add/"+anio;
	            } else {
	                // Dijeron que no
	                console.log("*NO se cerro*");
	            }
	        });
	}

function mensajeEliminar(id) {
let modulo = document.getElementById("nombreModulo").value;
console.log(id);
    Swal
        .fire({
            title: "Eliminar",
            text: "¿Desea Eliminar "+modulo+" ?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: "Si",
            cancelButtonText: "No",
        })
        .then(resultado => {
            if (resultado.value) {
                // Hicieron click en "Sí"
                window.location = modulo+"/eliminar/"+id;
            } else {
                // Dijeron que no
                console.log("*NO se cerro*");
            }
        });
}

function mensajeEliminarRequisicion(id, idSolicitud) {
let modulo = document.getElementById("nombreModulo").value;
console.log(id);
    Swal
        .fire({
            title: "Eliminar",
            text: "¿Desea Eliminar "+modulo+" ?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: "Si",
            cancelButtonText: "No",
        })
        .then(resultado => {
            if (resultado.value) {
                // Hicieron click en "Sí"
                window.location = "../"+modulo+"/eliminar/"+id+"/"+idSolicitud;
            } else {
                // Dijeron que no
                console.log("*NO se cerro*");
            }
        });
}

function mensajeEliminarDocumento(id, idReq) {
let modulo = document.getElementById("nombreModulo").value;
console.log(id);
    Swal
        .fire({
            title: "Eliminar",
            text: "¿Desea Eliminar "+modulo+" ?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: "Si",
            cancelButtonText: "No",
        })
        .then(resultado => {
            if (resultado.value) {
                // Hicieron click en "Sí"
                window.location = "../"+modulo+"/eliminar/"+id+"/"+idReq;
            } else {
                // Dijeron que no
                console.log("*NO se cerro*");
            }
        });
}

function mensajeEliminarDetalle(id, idReq) {
let modulo = document.getElementById("nombreModulo").value;
console.log(id);
    Swal
        .fire({
            title: "Eliminar",
            text: "¿Desea Eliminar "+modulo+" ?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: "Si",
            cancelButtonText: "No",
        })
        .then(resultado => {
            if (resultado.value) {
                // Hicieron click en "Sí"
                window.location = "../"+modulo+"/eliminar/"+id+"/"+idReq;
            } else {
                // Dijeron que no
                console.log("*NO se cerro*");
            }
        });
}

function mensajeCancelar(id) {
let modulo = document.getElementById("nombreModulo").value;
console.log(id);
    Swal
        .fire({
            title: "Cancelar "+modulo,
            text: "¿Desea Cancelar "+modulo+"?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: "Si",
            cancelButtonText: "No",
        })
        .then(resultado => {
            if (resultado.value) {
                // Hicieron click en "Sí"
          window.location = modulo+"/eliminar/"+id;

            } else {
                // Dijeron que no
                console.log("*NO se cerro*");
            }
        });
}

function mensajeReiniciar(id) {
console.log(id);
    Swal
        .fire({
            title: "Reiniciar",
            text: "¿Desea Reiniciar Usuario?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: "Si",
            cancelButtonText: "No",
        })
        .then(resultado => {
            if (resultado.value) {
                // Hicieron click en "Sí"
                window.location = "updatePassword/"+id;
            } else {
                // Dijeron que no
                console.log("*NO se cerro*");
            }
        });
}

function mensajeCerrarSesion(){
    var URLdomain = window.location.host;
    
    Swal
        .fire({
            title: "Cerrar Sesión",
            text: "¿Desea cerrar sesión?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: "Si",
            cancelButtonText: "No",
        })
        .then(resultado => {
            if (resultado.value) {
                // Hicieron click en "Sí"
                window.location.replace("http://"+URLdomain+"/SIRSR/logout");
            } else {
                // Dijeron que no
                console.log("*NO se cerro*");
            }
        });
}
  
  
  

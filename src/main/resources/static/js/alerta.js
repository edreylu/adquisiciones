
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
          enabled=idestatus==0?1:0;
          window.location = modulo+"/eliminar/"+id+"/"+enabled;
                
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
                window.location = "../eliminarDocumento/"+id+"/"+idReq;
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
  
  
  

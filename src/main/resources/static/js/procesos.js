'use strict'

function checkPasswordMatch(fieldConfirmPassword) {
    if (fieldConfirmPassword.value != document.getElementById("password").value) {
        fieldConfirmPassword.setCustomValidity("Passwords no coinciden!");
    } else {
        fieldConfirmPassword.setCustomValidity("");
    }
}

function getXhr() {
    if (window.XMLHttpRequest) {
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function editarPerfil() {
    var URLdomain = "http://" + window.location.host;
    let xhr = getXhr();
    var userNamePerfil = document.getElementById("userNamePerfil").value;
    xhr.open("GET", URLdomain + "/adquisiciones/usuario/editarPerfil/" + userNamePerfil, true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let data = xhr.responseText;
            console.log(data);
            document.getElementById("perfilModalHolder").innerHTML = data;
            $("#perfilModal").modal();
        }
    }
    xhr.send(null);
}

function showAsignarPersonal(){
    $("#asignarPersonalModal").modal();
}

function searchPersonal() {
    var noPersonal = document.getElementById("noPersonal").value;
    var noUsuario = document.getElementById("noUsuario").value;
    console.log("../../usuarios/searchPersonal/" + noPersonal + "/"+noUsuario);
    if (noPersonal != "" && noUsuario != 0) {
        var xhr = getXhr();
        xhr.open("GET", "../../usuarios/searchPersonal/" + noPersonal + "/"+noUsuario, true);
        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 200) {
                let data = xhr.responseText;
                console.log(data);
                document.getElementById("datosPersonal").innerHTML = data;
            }
        }
        xhr.send(null);
    }
}


 function detalleRequisicion(id) {
     console.log("../../solicitudes/searchDetallesRequisicion/" + id );
         var xhr = getXhr();
         xhr.open("GET", "../../solicitudes/searchDetallesRequisicion/" + id , true);
         xhr.onreadystatechange = () => {
             if (xhr.readyState === 4 && xhr.status === 200) {
                 let data = xhr.responseText;
                 console.log(data);
                 document.getElementById("detallesModalHolder").innerHTML = data;
                 $("#detallesModal").modal();
             }
         }
         xhr.send(null);
}


 function observaciones(id) {
     console.log("../../solicitudes/searchObservaciones/" + id );
         var xhr = getXhr();
         xhr.open("GET", "../../solicitudes/searchObservaciones/" + id , true);
         xhr.onreadystatechange = () => {
             if (xhr.readyState === 4 && xhr.status === 200) {
                 let data = xhr.responseText;
                 console.log(data);
                 document.getElementById("observacionesModalHolder").innerHTML = data;
                 $("#observacionesModal").modal();
             }
         }
         xhr.send(null);
}
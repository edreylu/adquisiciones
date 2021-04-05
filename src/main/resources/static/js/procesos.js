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
    xhr.open("GET", URLdomain + "/SIRSR/usuario/editarPerfil/" + userNamePerfil, true);
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
    let listPersonal = document.getElementById("listPersonal");
    if(listPersonal!=null){
    listPersonal.innerHTML = "";
     }
    $("#asignarPersonalModal").modal();
}

function searchPersonal(tipo) {
    let root = tipo == 1 ? "" : "../";
    var nombrePersonal = document.getElementById("nombrePersonal").value;
    console.log(root+"../usuarios/searchPersonal/" + nombrePersonal );
    if (nombrePersonal != "" && nombrePersonal != null) {
        var xhr = getXhr();
        xhr.open("GET",root+"../usuarios/searchPersonal/" + nombrePersonal, true);
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

function updateNoPersonal(id) {
   document.getElementById("noPersonal").value = id;
   $('#asignarPersonalModal').modal('hide');
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

function updateObjetoGasto() {
let id = document.getElementById("clavePresupuestaria").value;
console.log("../../requisiciones/updateObjetoGasto/" + id );
         var xhr = getXhr();
         xhr.open("GET", "../../requisiciones/updateObjetoGasto/" + id , true);
         xhr.onreadystatechange = () => {
             if (xhr.readyState === 4 && xhr.status === 200) {
                 let data = xhr.responseText;
                 console.log(data);
                 $("#idObjetoGasto").replaceWith(data);
             }
         }
         xhr.send(null);
}


function updateProducto() {
let id = document.getElementById("productos").value;
console.log("../../detalles/updateProducto/" + id );
         var xhr = getXhr();
         xhr.open("GET", "../../detalles/updateProducto/" + id , true);
         xhr.onreadystatechange = () => {
             if (xhr.readyState === 4 && xhr.status === 200) {
                 let data = xhr.responseText;
                 console.log(data);
                 $("#idProducto").replaceWith(data);
             }
         }
         xhr.send(null);
}

function documento(id) {
console.log("../documentos/addDocumento/" + id );
         var xhr = getXhr();
         xhr.open("GET", "../documentos/addDocumento/" + id , true);
         xhr.onreadystatechange = () => {
             if (xhr.readyState === 4 && xhr.status === 200) {
                 let data = xhr.responseText;
                 console.log(data);
                 document.getElementById("documentoModalHolder").innerHTML = data;
                 $("#subirDocumentoModal").modal();
             }
         }
         xhr.send(null);
}

function areThereProductsSuggestions() {
var URLdomain = "http://" + window.location.host;
console.log(URLdomain+"/SIRSR/admonadq/productos/areThereProductsSuggestions" );
         var xhr = getXhr();
         xhr.open("GET", URLdomain+"/SIRSR/admonadq/productos/areThereProductsSuggestions", true);
         xhr.onreadystatechange = () => {
             if (xhr.readyState === 4 && xhr.status === 200) {
                 let data = xhr.responseText;
                 console.log(data);
                 if(data==="S"){
                     alertaProductos();
                 }
             }
         }
    xhr.send(null);
}
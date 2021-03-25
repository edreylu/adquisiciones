
(() => {
    'use strict';
    window.addEventListener('load', () => {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, (form) => {
            form.addEventListener('submit', (event) => {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();

$(() => {
  $('[data-toggle="tooltip"]').tooltip();

  $('.date').datepicker({
  			autoclose : true
  		});

  		$('.close-button').unbind();

  		$('.close-button').click(function() {
  			if ($('.datepicker').is(":visible")) {
  				$('.date').datepicker('hide');
  			} else {
  				$('.date').datepicker('show');
  			}
  		});
})

//$(document).ready
$(() => {
    $('.chosen-select').chosen({
        width: '200px',
        disable_search: false});
    $('#unidadResponsable').chosen({
        width: '200px',
        disable_search: false});
    $('#claveEspecifica').chosen({
        width: '200px',
        disable_search: false});
    $('#clavePresupuestaria').chosen({
        width: '100px',
        disable_search: false});
    $('#productos').chosen({
            width: '100px',
            disable_search: false});

        // inicializar datatable de jquery

$('#tablaDatos').DataTable({
                scrollY: "230px",
                scrollCollapse: false,
                paging: true,
                searching: true,
                info: true,
                ordering: true
            });
            $('#tablaDetallesRequisicion').DataTable({
                            scrollY: "230px",
                            scrollCollapse: false,
                            paging: true,
                            searching: true,
                            info: true,
                            ordering: true
                        });
            $('#tablaSolicitudes').DataTable({
                            scrollY: "230px",
                            scrollCollapse: false,
                            paging: true,
                            searching: true,
                            info: true,
                            ordering: true,
                            order: [[ 0, "desc" ]]
                        });
$('#tablaRequisiciones').DataTable({
                    scrollY: "230px",
                    scrollCollapse: false,
                    paging: false,
                    searching: false,
                    info: true,
                    ordering: false
            });

$('#tablaRequisicionesDir').DataTable({
                            scrollY: "130px",
                            scrollCollapse: false,
                            paging: false,
                            searching: false,
                            info: false,
                            ordering: false
             });

$('#tablaDetalles').DataTable({
                            scrollY: "230px",
                            scrollCollapse: false,
                            paging: false,
                            searching: false,
                            info: true,
                            ordering: false
             });
$('#tablaDocumentos').DataTable({
                                     scrollY: "130px",
                                     scrollCollapse: false,
                                     paging: false,
                                     searching: false,
                                     info: false,
                                     ordering: false
            });

            $('#tablaAnioRequisicion').DataTable({
                scrollY: "230px",
                scrollCollapse: false,
                paging: true,
                searching: true,
                info: true,
                ordering: true,
                order: [[ 0, "desc" ]]
            });

});


function mostrarPassword() {
    var pass = document.getElementById("password");
    if (pass.type == "password") {
        pass.type = "text";
        $('.icon').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
    } else {
        pass.type = "password";
        $('.icon').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
    }
}

function mostrarPassword1() {
    var pass = document.getElementById("password1");
    if (pass.type == "password") {
        pass.type = "text";
        $('.icon1').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
    } else {
        pass.type = "password";
        $('.icon1').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
    }
}
function mostrarPassword2() {
    var pass = document.getElementById("password2");
    if (pass.type == "password") {
        pass.type = "text";
        $('.icon2').removeClass('fa fa-eye-slash').addClass('fa fa-eye');
    } else {
        pass.type = "password";
        $('.icon2').removeClass('fa fa-eye').addClass('fa fa-eye-slash');
    }
}

function nobackbutton() {
    window.location.hash = "no-back-button";
    window.location.hash = "Again-No-back-button" //chrome
    window.onhashchange = function () {
        window.location.hash = "no-back-button";
    }
}


function LoadingSpinner(form, spinnerHTML) {
    form = form || document
    var button
    var spinner = document.createElement('div')
    spinner.innerHTML = spinnerHTML
    spinner = spinner.firstChild
    form.addEventListener('click', start)
    form.addEventListener('invalid', stop, true)
    function start(event) {
        if (button)
            stop()
        button = event.target
        if (button.type === 'submit') {
            LoadingSpinner.start(button, spinner)
        }
    }

    function stop() {
        LoadingSpinner.stop(button, spinner)
    }

    function destroy() {
        stop()
        form.removeEventListener('click', start)
        form.removeEventListener('invalid', stop, true)
    }
    return {start: start, stop: stop, destroy: destroy}
}

LoadingSpinner.start = function (element, spinner) {
    element.classList.add('loading')
    return element.appendChild(spinner)
}

LoadingSpinner.stop = function (element, spinner) {
    element.classList.remove('loading')
    return spinner.remove()
}

let loginForm = document.getElementById('loginForm');
let loginLoader = new LoadingSpinner(loginForm, 'Cargando...');

// capcha
function enabledSubmit() {
    var botonSubmit = document.getElementById("submit");
    botonSubmit.disabled = false;
}



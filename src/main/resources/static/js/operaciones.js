


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

});


// valida numericos

function validaNumericos(event) {
    if (event.charCode >= 48 && event.charCode <= 57) {
        return true;
    }
    return false;
}



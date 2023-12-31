window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_turno_form');
    formulario.addEventListener('submit', (e) => {
        e.preventDefault();
        const formData = {
            pacienteId: document.querySelector('#paciente_id').value,
            odontologoId: document.querySelector('#odontologo_id').value,
            fecha: document.querySelector('#fecha').value
        };

        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {

                let successAlert = '<div class="alert alert-success alert-dismissible fade show" role="alert">' +
                '<div> <p>Se agregó correctamente el turno</p> </div>' +
                '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();

            })
            .catch(error => {

                let errorAlert = '<div class="alert alert-warning alert-dismissible fade show" role="alert">' +
                '<div> <p>No se pudo guardar el turno. </p></div>' +
                '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })
    });


    const resetUploadForm = () => {
        document.querySelector('#id_paciente').value;
        document.querySelector('#id_odontologo').value;
        document.querySelector('#fecha').value;
    }

});
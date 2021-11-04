import { inputs } from "./EvDisableInputsZp.js";


function PutModelo(){

    let historicoID = localStorage.getItem("historicoID")

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({

        "nome_modelo": inputs.nomeModelo.value,
    });

    var requestOptions = {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };
    if (inputs.nomeModelo.value != '') {
        fetch(`http://localhost:8080/alterarNomeModelo/${historicoID}`, requestOptions)
            .then(response => response.json())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
    }
}

export{PutModelo}
import { inputs } from "./EvDisableInputsZp.js";

function PutZeroPeca() {
    let idZeroPeca = localStorage.getItem("idZPAlterar")

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({

        "zp_posiX": inputs.zeropecaX.value,
        "zp_posiY": inputs.zeropecaY.value,
        "zp_posiZ": inputs.zeropecaZ.value,
        "zp_posiR": inputs.zeropecaR.value

    });

    var requestOptions = {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };
    if (inputs.zeropecaX.value != '') {
        fetch(`http://localhost:8080/zeropeca/${idZeroPeca}`, requestOptions)
            .then(response => response.json())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
    }

}

export {PutZeroPeca}
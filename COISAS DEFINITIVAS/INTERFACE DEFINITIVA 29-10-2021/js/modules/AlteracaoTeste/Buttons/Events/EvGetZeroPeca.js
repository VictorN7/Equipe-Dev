import { disabledInputsPosi, disabledInputsModelo } from "./EvDisableInputsZp.js";

function getZeroPeca(id) {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };

    fetch(`http://localhost:8080/zeropeca/${id}`, requestOptions)
        .then(response => response.json())
        .then(colocaInputsZP)
        .catch(error => console.log('error', error));
}
function colocaInputsZP(ZeroPeca) {

    console.log(ZeroPeca)
    const inputs = {
        zeropecaX: document.getElementById("zp-x"),
        zeropecaY: document.getElementById("zp-y"),
        zeropecaZ: document.getElementById("zp-z"),
        zeropecaR: document.getElementById("zp-r")
    }
    inputs.zeropecaX.value=ZeroPeca.zp_posiX
    inputs.zeropecaY.value=ZeroPeca.zp_posiY
    inputs.zeropecaZ.value=ZeroPeca.zp_posiZ
    inputs.zeropecaR.value=ZeroPeca.zp_posiR
    localStorage.setItem('idZPAlterar',ZeroPeca.id_zeropeca)

    disabledInputsPosi()
    disabledInputsModelo()
}

export { getZeroPeca }
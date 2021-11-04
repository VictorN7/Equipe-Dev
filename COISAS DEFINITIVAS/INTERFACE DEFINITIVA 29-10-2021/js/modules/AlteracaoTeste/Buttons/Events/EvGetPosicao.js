import { disabledInputsZP, disabledInputsModelo } from "./EvDisableInputsZp.js";


function getPosicao(id) {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };

    fetch(`http://localhost:8080/posicoes/${id}`, requestOptions)
        .then(response => response.json())
        .then(colocaInputs)
        .catch(error => console.log('error', error));
}

function colocaInputs(Posicoes) {

    const inptPosi = {
        PosiX: document.getElementById("altera-posicao-x"),
        PosiY: document.getElementById("altera-posicao-y"),
        PosiZ: document.getElementById("altera-posicao-z"),
        PosiR: document.getElementById("altera-posicao-r"),
        PosiT:document.getElementById("altera-posicao-t"),
    }

    inptPosi.PosiX.value = Posicoes.posiX
    inptPosi.PosiY.value = Posicoes.posiY
    inptPosi.PosiZ.value = Posicoes.posiZ
    inptPosi.PosiR.value = Posicoes.posiR
    inptPosi.PosiT.value = Posicoes.posiT

    disabledInputsZP()
    disabledInputsModelo()

    console.log(Posicoes)
    
}
export { getPosicao }
const btnAddPosicoes = document.getElementById("btn-add-posicao");

const inputPosicoes = {
    posiX: document.getElementById("posicao-x"),
    posiY: document.getElementById("posicao-y"),
    posiZ: document.getElementById("posicao-z"),
    posiR: document.getElementById("posicao-r"),
    posiTime: document.getElementById("posicao-time")
}

function disabledInputs(){
    btnAddPosicoes.addEventListener("click" ,() =>{
        inputPosicoes.posiX.disabled = true;
        inputPosicoes.posiY.disabled = true;
        inputPosicoes.posiZ.disabled = true;
        inputPosicoes.posiR.disabled = true;
        inputPosicoes.posiTime.disabled = true;
    })
}
export {disabledInputs}

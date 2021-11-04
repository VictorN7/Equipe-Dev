const inputs = {
    zeropecaX: document.getElementById("zp-x"),
    zeropecaY: document.getElementById("zp-y"),
    zeropecaZ: document.getElementById("zp-z"),
    zeropecaR: document.getElementById("zp-r"),
    nomeModelo: document.getElementById("input-altera-nome"),
    PosiX: document.getElementById("altera-posicao-x"),
    PosiY: document.getElementById("altera-posicao-y"),
    PosiZ: document.getElementById("altera-posicao-z"),
    PosiR: document.getElementById("altera-posicao-r"),
    PosiT: document.getElementById("altera-posicao-t"),
}

function disabledInputsZP() {
    inputs.zeropecaX.disabled = true
    inputs.zeropecaY.disabled = true
    inputs.zeropecaZ.disabled = true
    inputs.zeropecaR.disabled = true
}

function disabledInputsModelo() {
    inputs.nomeModelo.disabled = true
}

function disabledInputsPosi() {
    inputs.PosiX.disabled = true
    inputs.PosiY.disabled = true
    inputs.PosiZ.disabled = true
    inputs.PosiR.disabled = true
    inputs.PosiT.disabled = true
}



export { disabledInputsZP, disabledInputsModelo,disabledInputsPosi,inputs }
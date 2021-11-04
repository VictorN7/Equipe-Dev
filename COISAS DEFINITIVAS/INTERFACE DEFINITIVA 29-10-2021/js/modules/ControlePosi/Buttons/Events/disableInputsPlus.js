function disableButtonPlus() {
    
    const valuePosi = {
        posiX: document.querySelector('.posi0'),
        posiY: document.querySelector('.posi1'),
        posiZ: document.querySelector('.posi2'),
        posiR: document.querySelector('.posi3'),
        posiT: document.querySelector('.posi4')
    }

    //#region Disabilitar Inputs
    valuePosi.posiX.disabled = true
    valuePosi.posiY.disabled = true
    valuePosi.posiZ.disabled = true
    valuePosi.posiR.disabled = true
    valuePosi.posiT.disabled = true
    //#endregion
}
export { disableButtonPlus }




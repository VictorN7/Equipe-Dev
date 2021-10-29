function removeClass() {
    const valuePosi = {
        posiX: document.querySelector('.posi0'),
        posiY: document.querySelector('.posi1'),
        posiZ: document.querySelector('.posi2'),
        posiR: document.querySelector('.posi3'),
        posiT: document.querySelector('.posi4')
    }

    valuePosi.posiX.classList.remove('posi0')
    valuePosi.posiY.classList.remove('posi1')
    valuePosi.posiZ.classList.remove('posi2')
    valuePosi.posiR.classList.remove('posi3')
    valuePosi.posiT.classList.remove('posi4')
}

export { removeClass }
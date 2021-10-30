function criarBtnModelo() {
    let corpoModelo = document.querySelector('.corpo-modelo');
    let btnAlterarModelo = document.createElement('button');
    btnAlterarModelo.classList.add("alterar-modelo");
    btnAlterarModelo.textContent = "ALTERAR";

    corpoModelo.appendChild(btnAlterarModelo);
}

export {criarBtnModelo}
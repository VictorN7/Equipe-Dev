function criarBtnZp () {
    let corpoZp = document.querySelector('.corpo-zero-peca');
    let btnAlterarZp = document.createElement('button');
    btnAlterarZp.classList.add("alterar-zp");
    btnAlterarZp.textContent = "ALTERAR";

    corpoZp.appendChild(btnAlterarZp);
}

export {criarBtnZp}
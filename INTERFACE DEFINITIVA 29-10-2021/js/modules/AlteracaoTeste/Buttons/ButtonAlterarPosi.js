import { fetchBtnPosicao } from "../Buttons/Fetch.js";

function criarBtnAlterarPosi (Posicao) {
    let corpoPosicoes = document.querySelector('.corpo-posicoes');
    let btnAlterarPosi = document.createElement('button');
    btnAlterarPosi.classList.add("alterar-posicoes");
    btnAlterarPosi.textContent = "ALTERAR";

    corpoPosicoes.appendChild(btnAlterarPosi);

    console.log(Posicao);

}

    
fetchBtnPosicao(criarBtnAlterarPosi);

export {criarBtnAlterarPosi}
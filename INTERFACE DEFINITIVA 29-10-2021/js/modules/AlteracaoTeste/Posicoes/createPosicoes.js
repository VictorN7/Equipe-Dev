import { criarBtnAlterarPosi } from "../Buttons/ButtonAlterarPosi.js";

function Posicoes() {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };

    let historicoID = localStorage.getItem("historicoID")

    fetch(`http://localhost:8080/listarTestePorId/${historicoID}`, requestOptions)
        .then(response => response.json())
        .then(criarPosicoes)
        .catch(error => console.log('error', error));
}

function criarPosicoes(Teste) {

    let contador = 0;

        Teste.posicao.forEach(posicao => {
            console.log(posicao)

            let corpoPosicoes = document.querySelector('.corpo-posicoes');
            let createDivSemNome = document.createElement('div');
            createDivSemNome.classList.add("div-posicoes");
    
            let pPosicoes = document.createElement('p');
            pPosicoes.classList.add("p-posicoes");
    
            pPosicoes.textContent = `${++contador}) X: ${posicao.posiX}; Y: ${posicao.posiY}; Z: ${posicao.posiZ}; R: ${posicao.posiR}`
            let btnAlterarPosicoes = document.createElement('button')
            
            corpoPosicoes.appendChild(createDivSemNome);
            createDivSemNome.appendChild(pPosicoes);

            criarBtnAlterarPosi();
        });
}

export { Posicoes }

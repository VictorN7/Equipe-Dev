import { getPosicao } from "../Buttons/Events/EvGetPosicao.js";

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
console.log(Teste)
        for (const iterator of Teste.posicao) {
           
            

            let corpoPosicoes = document.querySelector('.corpo-posicoes');
            let createDivSemNome = document.createElement('div');
            createDivSemNome.classList.add("div-posicoes");
    
            let pPosicoes = document.createElement('p');
            pPosicoes.classList.add("p-posicoes");
    
            pPosicoes.textContent = `${++contador}) X: ${iterator.posiX}; Y: ${iterator.posiY}; Z: ${iterator.posiZ}; R: ${iterator.posiR}; T: ${iterator.posiT}`

            let btnAlterarPosi = document.createElement('button');
            btnAlterarPosi.classList.add("alterar-posicoes");
            btnAlterarPosi.textContent = "ALTERAR";
            btnAlterarPosi.addEventListener('click' ,()=>{
                getPosicao(iterator.id_posicao)
                localStorage.setItem('IdposiAlterar',iterator.id_posicao)
            } )
            
            corpoPosicoes.appendChild(createDivSemNome);
            createDivSemNome.appendChild(pPosicoes);
            createDivSemNome.appendChild(btnAlterarPosi) 
        } 
        
}

export { Posicoes }

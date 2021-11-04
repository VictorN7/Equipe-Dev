import { criarBtnZp } from "../Buttons/ButtonAlterarZp.js";
import { criarBtnModelo } from "../Buttons/ButtonAlterarModelo.js";


function tagsEstaticas () {
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
    .then(geraTags)
    .catch(error => console.log('error', error));
}

function geraTags (Teste) {

    let h3Alteracao = document.querySelector('.h3-alteracao');
    h3Alteracao.textContent = `TESTE Nº ${Teste.id_teste}`

    let pResumoModelo = document.querySelector('.resumo-modelo');
    pResumoModelo.textContent = `Modelo: ${Teste.nome_modelo}`

    let pResumoZeroPeca = document.querySelector('.resumo-zero-peca');
    pResumoZeroPeca.textContent = `Zero Peça: X: ${Teste.zeropeca.zp_posiX}; 
    Y: ${Teste.zeropeca.zp_posiY}; Z:  ${Teste.zeropeca.zp_posiZ}; R:  ${Teste.zeropeca.zp_posiR}`

    console.log()

    criarBtnModelo(Teste.nome_modelo);
    criarBtnZp(Teste.zeropeca.id_zeropeca);
}

export {tagsEstaticas}

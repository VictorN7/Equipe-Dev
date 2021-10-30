import { createSelect } from "./Actions/createSelect.js";
import { buttonAlterar } from "../Buttons/ButtonAlterar.js";
import { buttonExcluir } from "../Buttons/ButtonExcluir.js";

function Span() {

    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch("http://localhost:8080/listarTodosTeste", requestOptions)
        .then(response => response.json())
        .then(criaSpan)
        .catch(error => console.log('error', error));
}

function criaSpan(Teste) {
    console.log(Teste)

    for (const key in Teste) {
        let idTeste = Teste[key].id_teste
        let nome_modelo = Teste[key].nome_modelo
        let zp_posiR = Teste[key].zeropeca.zp_posiR
        let zp_posiX = Teste[key].zeropeca.zp_posiX
        let zp_posiY = Teste[key].zeropeca.zp_posiY
        let zp_posiZ = Teste[key].zeropeca.zp_posiZ

        let divItemTeste = document.getElementsByClassName('item-teste')

        let aLinkTeste = document.createElement('a')
        aLinkTeste.classList.add('link-teste')

        let spanIdTeste = document.createElement('span')
        spanIdTeste.classList.add('id-teste')
        spanIdTeste.textContent = `${idTeste}`

        let spanDataColeta = document.createElement('span')
        spanDataColeta.classList.add('data-coleta')
        spanDataColeta.textContent = 'DATA: 19/10/2021 12:00:00'

        let spanModeloTeste = document.createElement('span')
        spanModeloTeste.classList.add('modelo-teste')
        spanModeloTeste.textContent = `MODELO: ${nome_modelo} |`

        let spanZeroPecaTeste = document.createElement('span')
        spanZeroPecaTeste.classList.add("zero-peca-teste")
        spanZeroPecaTeste.textContent = `ZERO PEÇA: X:${zp_posiX}; Y:${zp_posiY}; Z:${zp_posiZ}; R:${zp_posiR}`

        let spanPosicoesTeste = document.createElement('span')
        spanPosicoesTeste.classList.add('posicoes-teste')

        divItemTeste[key].appendChild(aLinkTeste)
        aLinkTeste.appendChild(spanIdTeste)
        aLinkTeste.appendChild(spanDataColeta)
        aLinkTeste.appendChild(spanModeloTeste)
        aLinkTeste.appendChild(spanZeroPecaTeste)
        aLinkTeste.appendChild(spanPosicoesTeste)

    }
    createSelect()
    buttonAlterar()
    buttonExcluir()
}
export { Span }

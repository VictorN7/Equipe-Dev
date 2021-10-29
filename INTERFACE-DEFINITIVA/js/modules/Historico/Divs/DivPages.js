import { buttonsPages } from "../Buttons/ButtonsPages.js";
function divPages(){
    let DivLista = document.querySelector('.lista-testes')
    let createDivButtonPage = document.createElement('div')
    createDivButtonPage.classList.add("buttons-back-next")
    DivLista.appendChild(createDivButtonPage)
    buttonsPages()
}
export{divPages}
import { disableButtonPlus } from "./Events/disableInputsPlus.js";
import { addPosi } from "./Events/FetchAddPosi.js";
import { removeClass } from "./Events/removeClass.js";

const btnGravar = document.querySelector('#btn-salvar')
function btnSalvar(){
    btnGravar.addEventListener('click', () => {
        addPosi()
        disableButtonPlus()
        removeClass()
    })
}

export {btnSalvar}
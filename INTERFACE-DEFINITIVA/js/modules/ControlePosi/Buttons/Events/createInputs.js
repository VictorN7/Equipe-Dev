import { removeClass } from "./removeClass.js"
import { disableButtonPlus } from "./disableInputsPlus.js";
import { addPosi } from "./FetchAddPosi.js";

const btnAddPosicoes = document.getElementById("btn-add-posicao");

let inputs = document.querySelector(".inputs")

function createInputs() {
    btnAddPosicoes.addEventListener('click', (ev) => {
        if (ev.button == 0) {

            function inputsInfinityTimWeb() {
                for (let index = 0; index < 5; index++) {

                    let createLabels = document.createElement('label')
                    createLabels.setAttribute("for", "posicao-x")

                    let nomeLabel = ["X", "Y", "Z", "R", "T"]
                    createLabels.textContent = nomeLabel[index]

                    createInputs = document.createElement('input')
                    createInputs.classList.add('posi' + index)
                    createInputs.setAttribute("type", "number")

                    inputs.appendChild(createLabels)
                    inputs.appendChild(createInputs)

                }

                let btnPlusPosicao = document.createElement('button')
                btnPlusPosicao.classList.add('btn-add-posicao')
                btnPlusPosicao.setAttribute("id", "btn-mais-posicoes")
                btnPlusPosicao.textContent = "+1";
                btnPlusPosicao.addEventListener('click', (Ev) => {

                    inputsInfinityTimWeb()
                    addPosi()
                    disableButtonPlus()
                    removeClass()
                    inputs.removeChild(btnPlusPosicao)
                    
                })
                inputs.appendChild(btnPlusPosicao)

            }
            inputsInfinityTimWeb()
        }
    })

}



export { createInputs }
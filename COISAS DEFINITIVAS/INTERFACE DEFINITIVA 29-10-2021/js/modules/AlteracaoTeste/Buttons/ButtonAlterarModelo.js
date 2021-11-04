import { inputs,disabledInputsPosi,disabledInputsZP } from "./Events/EvDisableInputsZp.js";


function criarBtnModelo(modelo) {
    let corpoModelo = document.querySelector('.corpo-modelo');
    let btnAlterarModelo = document.createElement('button');
    btnAlterarModelo.classList.add("alterar-modelo");
    btnAlterarModelo.textContent = "ALTERAR";
    btnAlterarModelo.addEventListener('click',()=>{


    inputs.nomeModelo.value = modelo
    disabledInputsPosi()
    disabledInputsZP()
        
    })

    corpoModelo.appendChild(btnAlterarModelo);
}

export {criarBtnModelo}
import { getZeroPeca } from "./Events/EvGetZeroPeca.js";
function criarBtnZp (id) {
    let corpoZp = document.querySelector('.corpo-zero-peca');
    let btnAlterarZp = document.createElement('button');
    btnAlterarZp.classList.add("alterar-zp");
    btnAlterarZp.textContent = "ALTERAR";
    btnAlterarZp.addEventListener('click',()=>{
        alert("Foi Aqui Bora Alterar ZP") 
        getZeroPeca(id)
    })

    corpoZp.appendChild(btnAlterarZp);
}

export {criarBtnZp}
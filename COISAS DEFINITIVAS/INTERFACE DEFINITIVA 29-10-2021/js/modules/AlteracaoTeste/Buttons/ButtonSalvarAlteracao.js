import { PutModelo } from "./Events/EvPutModelo.js";
import { PutPosi } from "./Events/EvPutPosicaoFetch.js";
import { PutZeroPeca } from "./Events/EvPutZeroPeca.js";



function buttonSalvar(){
    let salvarAlterar = document.getElementById('btn-salvar-alteracao')
    salvarAlterar.addEventListener('click',()=>{

        
        PutPosi()
        PutZeroPeca()
        PutModelo()
        
        location.reload()
        location.assign("alteracao-teste.html")
    })
}

export{ buttonSalvar}
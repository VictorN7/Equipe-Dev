import { createOptions } from "./createOptions.js";
function createSelect(){
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch("http://localhost:8080/listarTodosTeste", requestOptions)
        .then(response => response.json())
        .then(setSelect)
        .catch(error => console.log('error', error));
}


function setSelect(Teste){
    for (const key in Teste) {
        let spanPosicoesTeste = document.getElementsByClassName('posicoes-teste')

    let selectPosiDropDown = document.createElement('select')
    selectPosiDropDown.classList.add('posicoes-dropdown')
    selectPosiDropDown.setAttribute('id',"posicoes-dropdown")
    selectPosiDropDown.setAttribute('name',"posicoes-dropdown")
    spanPosicoesTeste[key].appendChild(selectPosiDropDown)
    }
    
    createOptions()
}
export {createSelect}
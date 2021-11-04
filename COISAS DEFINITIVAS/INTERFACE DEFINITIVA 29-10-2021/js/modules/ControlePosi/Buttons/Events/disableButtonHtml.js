const inputsHtml =  document.querySelector('.inputs')
const btnAddPosicoes = document.getElementById("btn-add-posicao");

function disableButtonHtml(){
    btnAddPosicoes.addEventListener('click',()=>{inputsHtml.removeChild(btnAddPosicoes)})
}
export {disableButtonHtml}

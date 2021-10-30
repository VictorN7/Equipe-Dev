function buttonExcluir(){

    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
      };
    
      fetch("http://localhost:8080/listarTodosTeste", requestOptions)
        .then(response => response.json())
        .then(criaButtonExcluir)

}
function criaButtonExcluir(Teste){
    for (const key in Teste) {
    let divItemTeste = document.getElementsByClassName("item-teste")

    let btnExcluir = document.createElement('button')
    btnExcluir.classList.add('btn-excluir')
    btnExcluir.textContent = 'Excluir'

    divItemTeste[key].appendChild(btnExcluir)
}
}

export {buttonExcluir}
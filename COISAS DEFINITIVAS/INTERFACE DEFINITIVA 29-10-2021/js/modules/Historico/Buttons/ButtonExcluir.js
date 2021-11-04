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
    btnExcluir.addEventListener('click',()=>{
      var requestOptions = {
        method: 'DELETE',
        redirect: 'follow'
      };
      fetch(`http://localhost:8080/deletarTeste/${Teste[key].id_teste}`, requestOptions)
        .then(response => response.json())
        location.reload()
        location.assign("historico.html")
    })


    divItemTeste[key].appendChild(btnExcluir)
}
}



export {buttonExcluir}
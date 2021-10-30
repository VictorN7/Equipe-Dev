function buttonAlterar(){
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
      };
    
      fetch("http://localhost:8080/listarTodosTeste", requestOptions)
        .then(response => response.json())
        .then(criaButtonAlterar)
}

function criaButtonAlterar(Teste){
    for (const key in Teste) {
        let divItemTeste = document.getElementsByClassName("item-teste")

        let btnAlterar = document.createElement('button')
        btnAlterar.classList.add('btn-alterar')
        btnAlterar.textContent = "Alterar"
    
        btnAlterar.addEventListener('click', () => {
            
            localStorage.setItem("historicoID", Teste[key].id_teste)
            window.location.href = "../pages/alteracao-teste.html"
        })
        divItemTeste[key].appendChild(btnAlterar)

    }
}
export{buttonAlterar}
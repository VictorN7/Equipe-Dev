import { Span } from "../Spans/Span.js";

function divLista() {

  var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };

  fetch("http://localhost:8080/listarTodosTeste", requestOptions)
    .then(response => response.json())
    .then(criaDiv)
}

function criaDiv(Teste) {
  console.log(Teste)
  
  for (const {} in Teste) {
    let DivLista = document.querySelector('.lista-testes')
    let createDivItemTeste = document.createElement('div')
    createDivItemTeste.classList.add("item-teste")
    DivLista.appendChild(createDivItemTeste)
  }
  Span()
}
export { divLista }


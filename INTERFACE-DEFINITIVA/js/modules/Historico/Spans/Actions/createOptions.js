function createOptions() {
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch("http://localhost:8080/listarTodosTeste", requestOptions)
        .then(response => response.json())
        .then(setOptions)
        .catch(error => console.log('error', error));


}

function setOptions(Teste) {

    let select = document.getElementsByClassName('posicoes-dropdown')

    //#region Faz a Adição dos Options Dentro dos Selects

    for (const key in Teste) {

        let posicao = Teste[key].posicao

        //#region Pega Length do Posições e Itera
        for (const iterator of posicao) {

            //#region Iterator(Objeto 1 a 1 de Posições)

            let posiR = iterator.posiR
            let posiX = iterator.posiX
            let posiY = iterator.posiY
            let posiZ = iterator.posiZ
            //#endregion

            //#region Criação dos OPTIONS



            let options = document.createElement('option')
            options.classList.add('posi-lista')
            options.textContent = `X:${posiX}; Y:${posiY}; Z:${posiZ}; R:${posiR}`

            select[key].appendChild(options)
            //#endregion
        }
        //#endregion
    }

    //#endregion
}

export { createOptions }
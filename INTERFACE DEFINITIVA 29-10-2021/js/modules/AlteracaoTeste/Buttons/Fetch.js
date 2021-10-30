function fetchBtnPosicao(param) {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };

    let historicoID = localStorage.getItem("historicoID")

    fetch(`http://localhost:8080/listarTestePorId/${historicoID}`, requestOptions)
        .then(response => response.json())
        .then(param)
        .catch(error => console.log('error', error));
}

export { fetchBtnPosicao }
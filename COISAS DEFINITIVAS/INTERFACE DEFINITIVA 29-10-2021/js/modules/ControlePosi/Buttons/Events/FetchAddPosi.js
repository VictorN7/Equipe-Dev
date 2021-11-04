function addPosi() {

    const valuePosi = {
        posiX: document.querySelector('.posi0'),
        posiY: document.querySelector('.posi1'),
        posiZ: document.querySelector('.posi2'),
        posiR: document.querySelector('.posi3'),
        posiT: document.querySelector('.posi4')
    }

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "posiX": valuePosi.posiX.value,
        "posiY": valuePosi.posiY.value,
        "posiZ": valuePosi.posiZ.value,
        "posiR": valuePosi.posiR.value,
        "id_teste": localStorage.getItem("Chave")
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/posicoes", requestOptions)
        .then(response => response.json())
        .then(result => console.log(result))
}

export { addPosi }


function PutPosi() {

    let historicoID = localStorage.getItem("historicoID")
    let idPosi = localStorage.getItem("IdposiAlterar")

    const inptPosi = {
        posiX: document.getElementById("altera-posicao-x"),
        posiY: document.getElementById("altera-posicao-y"),
        posiZ: document.getElementById("altera-posicao-z"),
        posiR: document.getElementById("altera-posicao-r"),
        posiT: document.getElementById("altera-posicao-t"),
    }

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "posiX": inptPosi.posiX.value,
        "posiY": inptPosi.posiY.value,
        "posiZ": inptPosi.posiZ.value,
        "posiR": inptPosi.posiR.value,
        "posiT":inptPosi.posiT.value,
        "id_teste": historicoID
    });

    var requestOptions = {
        method: 'PUT',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };
    if(inptPosi.posiX.value != ''){
        fetch(`http://localhost:8080/posicoes/${idPosi}`, requestOptions)
        .then(response => response.json())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
    }
    
}


export{PutPosi}
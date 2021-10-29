const btnAddPosicoes = document.getElementById("btn-add-posicao");
const inputPosicoes = {
    posiX: document.getElementById("posicao-x"),
    posiY: document.getElementById("posicao-y"),
    posiZ: document.getElementById("posicao-z"),
    posiR: document.getElementById("posicao-r"),
    posiTime: document.getElementById("posicao-time")
}
function htmlInputsAdd(){

    btnAddPosicoes.addEventListener('click',()=>{
        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        var raw = JSON.stringify({
            "posiX": inputPosicoes.posiX.value,
            "posiY": inputPosicoes.posiY.value,
            "posiZ": inputPosicoes.posiZ.value,
            "posiR": inputPosicoes.posiR.value,
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
    })
}

export{htmlInputsAdd}
const divSPai = {
    divModeloZeroPeca: document.querySelector(".modelo-e-zero-peca"),
    divPosicoes: document.querySelector(".posicoes"),
    divBtnSubmit: document.querySelector(".btn-submit")
}
const inptsModelZp = {
    nomeModelo: document.getElementById('modelo'),
    zpX: document.getElementById("zp-x"),
    zpY: document.getElementById("zp-y"),
    zpZ: document.getElementById("zp-z"),
    zpR: document.getElementById("zp-r")
}

function gravarModelZp() {

    divSPai.divPosicoes.style = `display:none`
    divSPai.divBtnSubmit.style = `display:none`

    let BtnSalvarModelZeroPeca = document.createElement('button')
    BtnSalvarModelZeroPeca.classList.add("btnSalvarZpModel")
    BtnSalvarModelZeroPeca.classList.add("btn-gravar")
    BtnSalvarModelZeroPeca.textContent = "Gravar"

    BtnSalvarModelZeroPeca.addEventListener("click", () => {

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        var raw = JSON.stringify({
            "zeropeca": {
                "zp_posiX": inptsModelZp.zpX.value,
                "zp_posiY": inptsModelZp.zpY.value,
                "zp_posiZ": inptsModelZp.zpZ.value,
                "zp_posiR": inptsModelZp.zpR.value
            },
            "nome_modelo": inptsModelZp.nomeModelo.value

        });

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };

        fetch("http://localhost:8080/adicionarTesteEZeroPeca", requestOptions)
            .then(response => response.json())
            .then(chave);

        function chave(id) {
            alert(id.id_teste)
            console.log(id)

            localStorage.setItem("Chave", id.id_teste);
        }


        divSPai.divModeloZeroPeca.style = `display:none`
        divSPai.divPosicoes.style = ``
        divSPai.divBtnSubmit.style = ``

    })
    divSPai.divModeloZeroPeca.append(BtnSalvarModelZeroPeca)
}
export { gravarModelZp }
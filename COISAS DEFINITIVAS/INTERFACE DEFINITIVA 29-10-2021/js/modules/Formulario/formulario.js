function pegarDadosRelatorio(){
    let inputs = document.querySelectorAll('.inputs-formulario')
    for (let i = 0; i < inputs.length; i++) {
        
        switch (inputs[i].id)  {
           
            case "executante":
                const nome_executante = inputs[i].value 
                localStorage.setItem("nome_executante", nome_executante)
                console.log('nome_executante: ' + nome_executante)
                continue;

            case "data":
                const data = inputs[i].value 
                localStorage.setItem('data', data)
                console.log('data: ' + data)
                continue;

            case "local":
                const local = inputs[i].value 
                localStorage.setItem('local', local)
                console.log('local: ' + local)
                continue;

            case "tipo":
                const tipo = inputs[i].value 
                localStorage.setItem('tipo',tipo)
                console.log('tipo: ' + tipo)
                continue;
                
            case "especificar":
                const especificar = inputs[i].value 
                localStorage.setItem('especificar', especificar)
                console.log('especificar: ' + especificar)
                continue;
                
            case "fabricacao":
                const fabricacao = inputs[i].value 
                localStorage.setItem("fabricacao", fabricacao)
                console.log('fabricacao: ' + fabricacao)
                continue;

            case "modelo-placa":
                const modelo_placa = inputs[i].value 
                localStorage.setItem('modelo_placa', modelo_placa)
                console.log('modelo-placa: ' + modelo_placa)
                continue;

            case "frequencia":
                const frequencia = inputs[i].value 
                localStorage.setItem("frequencia", frequencia)
                console.log('frequencia: ' + frequencia)
                continue;
                
            case "fabricante":
                const fabricante = inputs[i].value 
                localStorage.setItem('fabricante',fabricante)
                console.log('fabricante: ' + fabricante)
                continue;
                
            case "nome-comercial":
                const nome_comercial = inputs[i].value 
                localStorage.setItem("nome_comercial", nome_comercial)
                console.log('nome_comercial: ' + nome_comercial)
                continue;
                
            case "tensao-placa":
                const tensao_placa = inputs[i].value 
                localStorage.setItem('tensao_placa',tensao_placa)
                console.log('tensao_placa: ' + tensao_placa)
                continue;

            case "potencia":
                const potencia = inputs[i].value 
                localStorage.setItem("potencia", potencia)
                console.log('potencia: ' + potencia)
               break;

            default:
                console.log('erro')
                break;
        }                
    }
    adicionarNoLocalStorage() 
}
var reader
var listaImagens = [];

    document.getElementById('imagem').addEventListener('change', e =>{
        if (e.target.files.length > 2 || listaImagens.length > 1) {
            alert('Limite máximo de duas imagens')
        }
        else{
            for(i = 0; i < e.target.files.length; i++){
                reader = new FileReader()
                reader.readAsDataURL(e.target.files[i])
                reader.addEventListener('load', (e) =>{
                    var imagens = e.target
                    selecionarImagens(imagens)
                })
            }
        }
    })

    function selecionarImagens(imagens) {
        console.log(imagens)
        console.log(imagens.result)
                
        if (checarImagemDuplicada(imagens)) {
        listaImagens.push({
            "name" : imagens.name,
            "url" : imagens.result,
            "file" : imagens,
        })
        } else 
        {
            alert(imagens.name + "já existe");
        }
      document.getElementById('container').innerHTML = exibirImagens();
    }

    function adicionarNoLocalStorage(){
        const keys = ['imagem1', 'imagem2']
        for(i = 0; i < keys.length; i++){
            localStorage.setItem(keys[i], listaImagens[i].url)
        }
    }

    function gerarDataIMG(img){
        var imgCanvas = document.createElement("canvas"),
        imgContext = imgCanvas.getContext("2d");

    imgCanvas.width = img.width;
    imgCanvas.height = img.height;

    imgContext.drawImage(img, 0, 0, img.width, img.height);

    var imgAsDataURL = imgCanvas.toDataURL("image/png");
    return imgAsDataURL
    }

    function exibirImagens() {
        var imagem = "";
        listaImagens.forEach((i) => {
            imagem += `<div class="image_container d-flex justify-content-center position-relative">
                <img src="`+ i.url +`" alt="Image">
                <span class="position-absolute" onclick="removerImagem(`+ listaImagens.indexOf(i) +`)">&times;</span>
            </div>`;
        })
        return imagem;
    }

         
    function removerImagem(e) {
        listaImagens.splice(e, 1);
        document.getElementById('container').innerHTML = exibirImagens();
    }

    function checarImagemDuplicada(name) {
    var naoDuplicada = true;
    if (listaImagens.length > 0) {
        for (e = 0; e < listaImagens.length; e++) {
            if (name == listaImagens[e].name) {
                naoDuplicada = false;
                break;
            }
        }
    }
    return naoDuplicada;
}

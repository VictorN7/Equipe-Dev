window.onload = function () {
    document.getElementById("download")
        .addEventListener("click", () => {
            const invoice = this.document.getElementById("main");
            console.log(invoice);
            console.log(window);
            var opt = {
                margin: 1,
                filename: 'relatorio.pdf',
                image: { type: 'jpeg', quality: 1 },
                html2canvas: { scale: 2 },
                jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' }
            };
            html2pdf().from(invoice).set(opt).save();
        })
}

function dados_formulario() {
    const nome_executante = localStorage.getItem('nome_executante')
    const data = localStorage.getItem('data').split('-').reverse().join('/')
    const local = localStorage.getItem('local')
    const tipo = localStorage.getItem('tipo')
    const especificar = localStorage.getItem('especificar')
    const fabricacao = localStorage.getItem('fabricacao')
    const modelo_placa = localStorage.getItem('modelo_placa')
    const frequencia = localStorage.getItem('frequencia')
    const fabricante = localStorage.getItem('fabricante')
    const nome_comercial = localStorage.getItem('nome_comercial')
    const tensao_placa = localStorage.getItem('tensao_placa')
    const potencia = localStorage.getItem('potencia')
    const imagem1 = localStorage.getItem('imagem1')
    const imagem2 = localStorage.getItem('imagem2')
    
   const dados = {
        nome_executante,
        data,
        local,
        tipo,
        especificar,
        fabricacao,
        modelo_placa,
        frequencia,
        fabricante,
        nome_comercial,
        tensao_placa,
        potencia,
        imagem1,
        imagem2
    }
    return dados;
  }


function exibirDados(){
    const dados =  dados_formulario()
    const valores1 = document.getElementById('valores1').children
    const valores2 = document.getElementById('valores2').children
    const valores3 = document.getElementById('valores3').children
    const imagens = document.getElementById('imagemID').children
    console.log(imagens)

    valores1[0].textContent = dados.tipo
    valores1[1].textContent = dados.especificar

    valores2[0].textContent = dados.fabricante
    valores2[1].textContent = dados.modelo_placa
    valores2[2].textContent = dados.frequencia
    valores2[3].textContent = dados.fabricacao

    valores3[0].textContent = dados.nome_comercial
    valores3[1].textContent = dados.tensao_placa
    valores3[2].textContent = dados.potencia
    
    imagens[0].src = dados.imagem1
    imagens[1].src = dados.imagem2
}

exibirDados()

function gerarHeader() {
    const header = document.querySelectorAll('.header')

    for(i = 0; i < header.length; i++){
        let logo = new Image()
        logo.src = '../img/taiff.png'
        logo.className = 'logo'
    
    
        let title_header = document.createElement('div')
        title_header.className = 'title-header'
    
        let texto1 = document.createElement('h5')
        let texto2 = document.createElement('h5')
    
        texto1.textContent = 'FIT 002-19-01'
        texto2.textContent = 'TEMPERATURA ENTREGUE POR SECADOR - MÉTODO 1 - 25,4 MM'
        title_header.appendChild(texto1)
        title_header.appendChild(texto2)

        header[i].appendChild(logo)
        header[i].appendChild(title_header)
        header[i].appendChild(criarTabelaHeader())
    }
}

function criarTabelaHeader() {
    const tabelaHeader = document.createElement('table');
    tabelaHeader.className = 'tabela-header'

    const dados = dados_formulario()

    const titulosTabela = ['EXECUTANTE', 'DATA', 'LOCAL']
    
    const dadosTabela = [dados.nome_executante, dados.data, dados.local]

    for (var i = 0; i < 2; i++) {
        var tr = document.createElement('tr');
        if (i == 0){
            for (var j = 0; j < 3; j++) {
                var th= document.createElement('th');
                th.appendChild(document.createTextNode(titulosTabela[j]))
                tr.appendChild(th)
            }
        }
        else if (i == 1) {
            for (var j = 0; j < 3; j++) {
                var td = document.createElement('td');
                td.appendChild(document.createTextNode(dadosTabela[j]))
                tr.appendChild(td)
            }
        }
        tabelaHeader.appendChild(tr)
    }
    return tabelaHeader
}


gerarHeader()


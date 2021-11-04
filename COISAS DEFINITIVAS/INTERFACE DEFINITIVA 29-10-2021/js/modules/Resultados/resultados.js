
    



const api = {
    url: "http://localhost:8080/listarTemps"
}
/*FECHT COM VARIAS REQUISIÇÕES*/
function pegarTemp() {
    Promise.all([

        fetch(`${api.url}`).then(temp6 => temp6.json())
    ]).then(Grafs)
    
}


function Grafs(temp) {

    
   
    const lengthTemp1 = temp[0].length

    const j1Termo1 = Array.from({
        length: lengthTemp1
    }, (item, i) => {
        return temp[0][i].termopar1

    });
    var cont = 0
    const contador = Array.from({
        length: lengthTemp1
    }, (item, i) => {
        
        return cont++

    });


    const j1Termo2 = Array.from({
        length: lengthTemp1
    }, (item, i) => {
        return temp[0][i].termopar2
    });

    const j1Termo3 = Array.from({
        length: lengthTemp1
    }, (item, i) => {
        return temp[0][i].termopar3

    });

    const j1TermoAmb = Array.from({
        length: lengthTemp1
    }, (item, i) => {
        return temp[0][i].tempAmb

    });

    const data = {
        labels: contador,
        datasets: [
            {
                label: 'Termopar 1',
                data: j1Termo1,
                backgroundColor: 'rgba(54, 162, 235, 0.5)',
                borderColor: 'rgb(54, 162, 235)',
                cubicInterpolationMode: 'monotone',
            },
            {   
                label: 'Termopar 2',
                data: j1Termo2,
                backgroundColor: 'rgba(226,135,67, 0.5)',
                borderColor: 'rgb(226,135,67)',
                color:'#666',
                cubicInterpolationMode: 'monotone',
            },
            {
                label: 'Termopar 3',
                data: j1Termo3,
                backgroundColor: 'rgba(50, 151, 43, 0.5)',
                borderColor: 'rgb(50, 151, 43)',
                cubicInterpolationMode: 'monotone',
            },
            {
                label: 'Termopar Ambiente',
                data: j1TermoAmb,
                backgroundColor: 'rgba(244, 230, 15, 0.5)',
                borderColor: 'rgb(244, 230, 15)',
                cubicInterpolationMode: 'monotone',
            }


        ]

        

    }
    const config = {
        type: 'line',
        data: data,
}   
   
    let grafico_estatico = document.querySelector(".grafico-estatico")
    let canvas = document.createElement("canvas")
    canvas.classList.add("Mychart")
    grafico_estatico.appendChild(canvas)
        
    let graf = document.querySelector(".Mychart").getContext("2d")
    let myChart = new Chart(graf, config)

}

pegarTemp()

function gerarCSV() {
     const url = {
         get: "http://localhost:8080/downloadCSV"
     }

     fetch(url.get)
     .then(csv => csv.text())
     window.location.href = url.get
     
}

document.querySelector('.btn-download-csv').addEventListener('click', gerarCSV)




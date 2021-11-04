/*Parte do Grafico*/
let graf = document.querySelector(".mychart").getContext("2d")

const config = {
    type: 'line',
    data: {
        datasets: [
            {
                label: 'TermoPar1',
                backgroundColor: 'rgba(54, 162, 235, 0.5)',
                borderColor: 'rgb(54, 162, 235)',
                cubicInterpolationMode: 'monotone',
                data: []
            },
            {
                label: 'TermoPar2',
                backgroundColor: 'rgba(255, 51, 73, 0.5)',
                borderColor: 'rgb(255, 51, 73)',
                cubicInterpolationMode: 'monotone',
                data: []
            },
            {
                label: 'TermoPar3',
                backgroundColor: 'rgba(50, 151, 43, 0.5)',
                borderColor: 'rgb(50, 151, 43)',
                cubicInterpolationMode: 'monotone',
                data: []
            },
            {
                label: 'TermoPar4',
                backgroundColor: 'rgba(244, 230, 15, 0.5)',
                borderColor: 'rgb(244, 230, 15)',
                cubicInterpolationMode: 'monotone',
                data: []
            }
        ]
    },
    options: {
        scales: {
            x: {
                type: 'realtime',
                realtime: {
                    duration: 30000,
                    refresh: 1000,//Velocidade de Variação da Linha
                    delay: 500,//Pontos de Marcação a Cada 3 Segundos
                    pause: !true,
                    onRefresh: chart => {
                        chart.data.datasets.forEach(dataset => {
                            dataset.data.push({
                                x: Date.now(),
                                y: Math.random() * 30
                            })
                        });
                    }
                }
            }
        }
    }
}

var myChart = new Chart(graf, config)






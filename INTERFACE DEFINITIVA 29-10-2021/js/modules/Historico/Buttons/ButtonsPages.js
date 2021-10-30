function buttonsPages(){

    let ButtonsPages = document.querySelector('.buttons-back-next')


    let btnBack = document.createElement('button')
    btnBack.classList.add('back')

    let emLeft = document.createElement('em')
    emLeft.classList.add('bx')
    emLeft.classList.add('bx-chevron-left')

    btnBack.appendChild(emLeft)

    let btnNext = document.createElement('button')
    btnNext.classList.add('next')


    let emRight = document.createElement('em')
    emRight.classList.add('bx')
    emRight.classList.add('bx-chevron-right')

    btnNext.appendChild(emRight)


    ButtonsPages.appendChild(btnBack)
    ButtonsPages.appendChild(btnNext)
    
}

export{buttonsPages}
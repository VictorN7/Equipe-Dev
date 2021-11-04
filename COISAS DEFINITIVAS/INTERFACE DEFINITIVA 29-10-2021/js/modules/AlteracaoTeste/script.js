import { tagsEstaticas } from "./Estatico/TagsEstaticas.js";
import { Posicoes } from "./Posicoes/createPosicoes.js";
import { buttonSalvar } from "./Buttons/ButtonSalvarAlteracao.js";

function App (){
    
    tagsEstaticas();
    Posicoes();
    buttonSalvar();
}

App()
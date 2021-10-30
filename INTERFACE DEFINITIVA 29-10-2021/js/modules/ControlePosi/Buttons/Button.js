import { disabledInputs } from "./Events/disableInputs.js";
import { htmlInputsAdd } from "./Events/InputFetchHtml.js";
import { disableButtonHtml } from "./Events/disableButtonHtml.js";
import { createInputs } from "./Events/createInputs.js";


function button() {

   disabledInputs()
   htmlInputsAdd()
   disableButtonHtml()
   createInputs()
  
}

export { button }
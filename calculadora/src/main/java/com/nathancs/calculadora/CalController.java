package com.nathancs.calculadora;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CalController {
    @GetMapping("/calculadora")
    public String calculadora(@RequestParam(name = "operando1",required = false ,defaultValue = "0")String operando1,
                              @RequestParam(name ="operando2" ,required = false,defaultValue = "0")String operando2,
                              @RequestParam(name = "operacao",required = false,defaultValue = "Soma")String operacao,Model model){



    double num1 = Double.parseDouble(operando1);
    double num2 = Double.parseDouble(operando2);

    switch (operacao){
        case "soma":
            model.addAttribute("resultado",num1+num2);
            break;
        case "subtracao":
            model.addAttribute("resultado",num1-num2);
            break;
        case "multiplicacao":
            model.addAttribute("resultado",num1*num2);
            break;
        case "divisao":
            if(num2 !=0){
            model.addAttribute("resultado",num1/num2);}
            break;
    }
    return "calculadora";


    }
}

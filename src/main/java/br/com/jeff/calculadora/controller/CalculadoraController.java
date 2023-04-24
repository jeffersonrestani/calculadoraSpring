package br.com.jeff.calculadora.controller;

import br.com.jeff.calculadora.exceptions.InvalidNumberOperationException;
import br.com.jeff.calculadora.exceptions.isNullOperationException;
import br.com.jeff.calculadora.model.Calculadora;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CalculadoraController {

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public float sum(@RequestParam("n1") String n1, @RequestParam("n2") String n2) {
        if(isNull(n1) || isNull(n2)){
            throw new isNullOperationException("Por favor, colocar todos os números!");
        }
        if(!isNumeric(n1)||!isNumeric(n2)){
            throw new InvalidNumberOperationException("Por favor, colocar números válidos");
        }
        return Calculadora.sum(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = "/sub/{n1}/{n2}", method = RequestMethod.GET)
    public float sub(@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
        if(isNull(n1) || isNull(n2)){
            throw new isNullOperationException("Por favor, colocar todos os números!");
        }
        if(!isNumeric(n1)||!isNumeric(n2)){
            throw new InvalidNumberOperationException("Por favor, colocar números válidos");
        }
        return Calculadora.sub(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = "/mult/{n1}/{n2}", method = RequestMethod.GET)
    public float mult(@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
        if(isNull(n1) || isNull(n2)){
            throw new isNullOperationException("Por favor, colocar todos os números!");
        }
        if(!isNumeric(n1)||!isNumeric(n2)){
            throw new InvalidNumberOperationException("Por favor, colocar números válidos");
        }
        return Calculadora.mult(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = "/div/{n1}/{n2}", method = RequestMethod.GET)
    public float div(@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
        if(isNull(n1) || isNull(n2)){
            throw new isNullOperationException("Por favor, colocar todos os números!");
        }
        if(!isNumeric(n1)||!isNumeric(n2)){
            throw new InvalidNumberOperationException("Por favor, colocar números válidos");
        }
        return Calculadora.div(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    public boolean isNumeric(String value){
        try{
            Float.parseFloat(value);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isNull(String value) {
        if (value.isBlank()) {
            return true;
        }else{
            return false;
        }
    }
}

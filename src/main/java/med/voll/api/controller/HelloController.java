package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //anotação usada para api rest
@RequestMapping("/hello")  //qual é a url que esse controller vai responder
public class HelloController {

    @GetMapping //de qual método do protocolo http é para chamar esse método olaMundo(), método GET
    public String olaMundo(){
        return "Olá Mundo Spring!";
    }



}

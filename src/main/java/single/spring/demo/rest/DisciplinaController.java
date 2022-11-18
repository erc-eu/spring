package single.spring.demo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import single.spring.demo.model.Disciplina;
import single.spring.demo.service.DisciplinaRepository;



@Controller
@RequestMapping("/api/disciplina")
public class DisciplinaController {
    
    @Autowired
    DisciplinaRepository disciplinaRepository;

    @GetMapping
    public @ResponseBody Iterable<Disciplina> getAllUsers(){
        return disciplinaRepository.findAll();
    }

    @PostMapping
    public @ResponseBody String addNewTurma(@RequestBody Disciplina disciplina) {
    disciplinaRepository.save(disciplina);    
    return "Saved";
    }


    
}

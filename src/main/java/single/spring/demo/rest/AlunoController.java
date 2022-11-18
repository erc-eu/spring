package single.spring.demo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import single.spring.demo.model.Aluno;
import single.spring.demo.service.AlunoRepository;

@Controller
@RequestMapping("/api/aluno")
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping
    public @ResponseBody Iterable<Aluno> getAllUsers(){
        return alunoRepository.findAll();
    }

    @PostMapping
    public @ResponseBody String addNewTurma(@RequestBody Aluno aluno) {
    alunoRepository.save(aluno);    
    return "Saved";
    }
}

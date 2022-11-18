package single.spring.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import single.spring.demo.model.Turma;
import single.spring.demo.service.AlunoRepository;
import single.spring.demo.service.TurmaRepository;

import single.spring.demo.model.Aluno;


@Controller
@RequestMapping("/api/turma")
public class TurmaController {
    
    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    AlunoRepository alunoRepository;
    @GetMapping
    public @ResponseBody Iterable<Turma> getAllUsers(){
    return turmaRepository.findAll();
    }

    @GetMapping(path = {"/{codigo}"})
    public ResponseEntity<Turma> findById(@PathVariable Integer codigo)
    {
        return turmaRepository.findById(codigo)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = {"/{codigo}/aluno"})
    public ResponseEntity<Object> criarAluno(@PathVariable Integer codigo, @RequestBody Aluno aluno){
      Optional<Turma> turmaOptional = turmaRepository.findById(codigo);
      List<Aluno> al =  new ArrayList<>();
      al.add(aluno);
      if(turmaOptional.isPresent()){
        Turma t = turmaOptional.get();
        t.setAluno(al);
        System.out.println(al);
        return new ResponseEntity<>(turmaRepository.save(t), HttpStatus.OK);

      }
      return null;
    }    
    


    @PutMapping(path ="/{codigo}")
    public ResponseEntity<Turma> updateTutorial(@PathVariable Integer codigo, @RequestBody Turma newTurma) {
        Optional<Turma> tutorialData = turmaRepository.findById(codigo);
    
        if (tutorialData.isPresent()) {
          Turma _tutorial = tutorialData.get();
          _tutorial.setSemestre(newTurma.getSemestre());
          return new ResponseEntity<>(turmaRepository.save(_tutorial), HttpStatus.OK);
        } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      }
      

    @PostMapping
        public @ResponseBody String addNewTurma(@RequestBody Turma turma) {
        turmaRepository.save(turma);    
        return "Saved";
    }
  
  @DeleteMapping(path ="/{codigo}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable Integer codigo) {
    try {
      turmaRepository.deleteById(codigo);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}

package single.spring.demo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import single.spring.demo.model.Turma;
import single.spring.demo.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaRestController {
    @Autowired 
    TurmaService TurmaService;
    
    @GetMapping
    List<Turma> getTurmas(@RequestParam Map<String, String> params){
        String buscaNome = null;
        if(params.get("nome") != null){
            buscaNome = params.get("nome");
        }
        return TurmaService.getTurmas(buscaNome);
    }

    @GetMapping(path = "/{codigo}")
    Turma getTurma(@PathVariable String codigo){
        return TurmaService.getTurma(Integer.parseInt(codigo));
    }

    @PostMapping
    void addTurmas(@RequestBody Turma turma){
        TurmaService.addTurma(turma);
    }

    @PutMapping(path = "/{codigo}")
    void updateTurma(@PathVariable String codigo, @RequestBody Turma turma){
        TurmaService.updateTurma(Integer.parseInt(codigo), turma);
    }

    @DeleteMapping(path = "/{codigo}")
    Turma deleteTurma(@PathVariable String codigo){
        return TurmaService.deleteTurma(Integer.parseInt(codigo));
    }
}   

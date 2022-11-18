package single.spring.demo.service;

import org.springframework.data.repository.CrudRepository;
import single.spring.demo.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno,Integer> {
    
}

package single.spring.demo.service;

import org.springframework.data.repository.CrudRepository;

import single.spring.demo.model.Disciplina;

public interface DisciplinaRepository  extends CrudRepository<Disciplina, Integer>{
    
}

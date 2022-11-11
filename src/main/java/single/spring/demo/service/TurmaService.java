package single.spring.demo.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import single.spring.demo.model.Turma;

@Service
public class TurmaService {
    
    private List<Turma> turmas = new ArrayList<Turma>();

    public TurmaService() {
        turmas.addAll(Arrays.asList(new Turma( 1, "Matematica",2,1,"eric","ericgtxh@Hotmail.com")));
	}

    public List<Turma> getTurmas(String buscaNome) {
        if(buscaNome != null){
            List<Turma> buscaTurmas = new ArrayList<Turma>();
            for (Turma turma : turmas) {
                if(turma.getNome().toUpperCase().contains(buscaNome.toUpperCase()))
                    buscaTurmas.add(turma);
            }
            return buscaTurmas;
        } else return turmas;
	}


    public void addTurma(Turma turma) {
		turmas.add(turma);
	}

    public Turma getTurma(int codigo) {
        for (Turma turma : turmas) {
            if(turma.getCodigo() == codigo)
                return turma;
        }
        return null;
    }
}

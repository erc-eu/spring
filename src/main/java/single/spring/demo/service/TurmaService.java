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
        turmas.addAll(Arrays.asList(new Turma( 1, "eric","ericgtxh@hotmail.com",1,"WEB",1)));
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

    public Turma updateTurma(int codigo, Turma novo) {
        for (Turma turma : turmas) {
            if(turma.getCodigo() == codigo)
            {
                turma.setDisciplina(novo.getDisciplina());
                turma.setSemestre(novo.getSemestre());
                turma.setMatricula(novo.getMatricula());
                turma.setNome(novo.getNome());
                turma.setEmail(novo.getEmail());
                return turma;
            }
        }
        return null;
    }

    public Turma deleteTurma(int codigo) {
        for (int i = 0; i < turmas.size(); i++) {
            Turma t = turmas.get(i);
            if(t.getCodigo() == codigo){
                turmas.remove(t);
                return t;
            }
        }
        return null;
    }

}

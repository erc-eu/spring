package single.spring.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    @ManyToOne
    private Disciplina disciplina;
    private int semestre;
    @ManyToMany
    private List<Aluno> aluno;
    @ElementCollection
    private List<Date> horarios;

    
    public Turma() {
    }


    public Turma(int codigo, Disciplina disciplina, int semestre, List<Aluno> aluno, List<Date> horarios) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.aluno = aluno;
        this.horarios = horarios;
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public Disciplina getDisciplina() {
        return disciplina;
    }


    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }


    public int getSemestre() {
        return semestre;
    }


    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }


    public List<Aluno> getAluno() {
        return aluno;
    }


    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }


    public List<Date> getHorarios() {
        return horarios;
    }


    public void setHorarios(List<Date> horarios) {
        this.horarios = horarios;
    }


    
    
   
}

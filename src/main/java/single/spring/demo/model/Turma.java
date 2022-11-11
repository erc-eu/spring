package single.spring.demo.model;

public class Turma extends Aluno{
    private int codigo;
    private String disciplina;
    private int semestre;

    public Turma(int matricula, String nome, String email, int codigo, String disciplina, int semestre) {
        super(matricula, nome, email);
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.semestre = semestre;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

}

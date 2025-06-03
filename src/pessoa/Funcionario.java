package pessoa;

public class Funcionario extends Pessoa {
    private int matricula;


    public Funcionario(String nome, int dataNasc, String cpf, int matricula) {
        super(nome, dataNasc, cpf);
        this.setMatricula(matricula);

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n--- Dados do Técnico ---" +
                "\n Matrícula: " + this.matricula ;
    }
}


package pessoa;

public abstract class Pessoa {

    private String nome;
    private int dataNasc;
    private String cpf;

    public Pessoa (String nome, int dataNasc, String cpf){
        this.setNome(nome);
        this.setDataNasc(dataNasc);
        this.setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(int dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Seus dados: " +
                "\n Nome: " + nome +
                "\n Data de nascimento: " + dataNasc +
                "\n Cpf: " + cpf;
    }
}





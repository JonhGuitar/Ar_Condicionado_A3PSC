package pessoa;

public class Pessoa {

    private String nome;
    private int nasc;
    private String cpf;

    public Pessoa(String nome, int nasc, String cpf){
        this.nome = nome;
        this.nasc = nasc;
        this.cpf = cpf;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public int getNasc() {return nasc;}

    public void setNasc(int nasc) {this.nasc = nasc;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public String toString() {
        return "Seus Dados:" +
                "\nNome: " + nome +
                "\nData de Nascimento: " + nasc +
                "\nCPF: " + cpf;
    }
}





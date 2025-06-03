package pessoa;

public class Cliente extends Pessoa{
    private String telefone;

    public Cliente(String nome, int dataNasc, String cpf, String telefone) {
        super(nome, dataNasc, cpf);
        this.setTelefone(telefone);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Telefone de contato com cliente: " + this.telefone;
    }
}

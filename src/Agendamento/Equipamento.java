package Agendamento;

public class Equipamento {

    private String nome;   // Ex: "Ar Condicionado Split"
    private String marca;  // Ex: "Samsung"

    public Equipamento(String nome, String marca) {
        this.nome = nome;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Equipamento:" +
                "\n  Nome: " + nome +
                "\n  Marca/Modelo: " + marca;
    }
}
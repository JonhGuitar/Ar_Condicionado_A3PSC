package Agendamento;

public class Servico {
    private String tipo;  // Ex: "Instalação", "Limpeza", "Deseintalação"
    private double valor;

    public Servico(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        // Formata o valor para aparecer como moeda
        return "Tipo de Serviço: " + tipo + " | Valor: R$ " + valor;
    }
}


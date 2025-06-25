package Agendamento;


public class Servico {
    private String tipo;
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
        return "Tipo de Serviço: " + tipo + " | Valor: R$ " + String.format("%.2f", valor);
    }
}





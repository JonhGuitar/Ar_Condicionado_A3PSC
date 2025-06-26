package Agendamento;

public class Pagamento {
    private double valorPago;
    private String metodoDePagamento;
    private Agendamento agendamentoReferencia;

    public Pagamento(double valorPago, String metodoDePagamento, Agendamento agendamentoReferencia) {
        this.valorPago = valorPago;
        this.metodoDePagamento = metodoDePagamento;
        this.agendamentoReferencia = agendamentoReferencia;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getMetodoDePagamento() {
        return metodoDePagamento;
    }

    public void setMetodoDePagamento(String metodoDePagamento) {
        this.metodoDePagamento = metodoDePagamento;
    }

    public Agendamento getAgendamentoReferencia() {
        return agendamentoReferencia;
    }

    public void setAgendamentoReferencia(Agendamento agendamentoReferencia) {
        this.agendamentoReferencia = agendamentoReferencia;
    }

    @Override
    public String toString() {
        return "--- Recibo de Pagamento ---\n" +
                "Valor Pago: R$ " + String.format("%.2f", valorPago) + "\n" +
                "Método: " + metodoDePagamento + "\n" +
                "Referente ao serviço para: " + agendamentoReferencia.getCliente().getNome();
    }
}

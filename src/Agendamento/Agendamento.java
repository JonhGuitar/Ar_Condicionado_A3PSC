package Agendamento;

import pessoa.Cliente;
import pessoa.Funcionario;

public class Agendamento implements Processavel {
    private Endereco endereco;
    private int data;
    private int hora;
    private Cliente cliente;
    private Funcionario funcionario;
    private Servico servico;
    private StatusAgendamento statusAgendamento;
    private String statusPagamento;

    public Agendamento(Cliente cliente, Funcionario funcionario, Servico servico, Endereco endereco, int data, int hora, StatusAgendamento statusAgendamento) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.endereco = endereco;
        this.data = data;
        this.hora = hora;
        this.statusAgendamento = statusAgendamento;
        this.statusPagamento = "Pendente";
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getTecnico() {
        return funcionario;
    }

    public void setTecnico(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public double getValorAPagar() {
        return this.servico.getValor();
    }

    @Override
    public void processarPagamento() {
        System.out.println("Validando pagamento de R$ " + getValorAPagar() + "...");
        this.statusPagamento = "Pago";
        System.out.println("Pagamento processado e aprovado com sucesso!");
    }

    @Override
    public String getStatusPagamento() {
        return this.statusPagamento;
    }

    @Override
    public String toString() {
        // Agora chama o toString() do objeto Endereco
        return "--- DETALHES DO AGENDAMENTO ---\n" +
                "Status: " + statusAgendamento + " | Pagamento: " + statusPagamento + "\n" +
                "Data: " + data + " | Hora: " + hora + "h\n" +
                "Endereço do Serviço: " + endereco.toString() + "\n" +
                "\n-- Cliente --\n " + cliente.getNome() + "\n" +
                "\n-- Funcionário Responsável --\n " + funcionario.getNome() + "\n" +
                "\n-- Detalhes do Trabalho --\n" +
                " " + servico.toString();
    }
}



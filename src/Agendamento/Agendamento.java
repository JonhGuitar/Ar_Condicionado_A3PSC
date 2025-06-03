package Agendamento;

import pessoa.Cliente;
import pessoa.Funcionario;

public class Agendamento {
    private String endereco;
    private int data;
    private int hora;
    private Cliente cliente;
    private Funcionario funcionario;
    private Servico servico;
    private StatusAgendamento statusAgendamento;

    public Agendamento(Cliente cliente, Funcionario funcionario, Servico servico, String endereco, int data, int hora, StatusAgendamento statusAgendamento) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.endereco = endereco;
        this.data = data;
        this.hora = hora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    @Override
    public String toString() {
        return "--- DETALHES DO AGENDAMENTO ---\n" +
                "Data: " + data + " | Hora: " + hora + "h\n" +
                "Endereço: " + endereco + "\n" +
                "\n-- Cliente --\n " + cliente.getNome() + "\n" +
                "\n-- Técnico Responsável --\n " + funcionario.getNome() + "\n" +
                "\n-- Detalhes do Trabalho --\n" +
                " " + servico.toString();
    }
}

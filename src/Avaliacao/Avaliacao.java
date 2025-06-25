package Avaliacao;

import Agendamento.Agendamento;

public class Avaliacao {

    private int nota; // Nota de 0 a 10, por exemplo
    private String comentario;
    private Agendamento agendamento; // A referência para o agendamento que foi avaliado

    public Avaliacao(int nota, String comentario, Agendamento agendamento) {
    this.nota = nota;
    this.comentario = comentario;
    this.agendamento = agendamento;
    }


    public int getNota() { return nota; }
    public String getComentario() { return comentario; }
    public Agendamento getAgendamento() { return agendamento; }

    @Override
    public String toString() {
    return "Avaliação do Serviço: " + agendamento.getServico().getTipo() + "\n" +
            "\tCliente: " + agendamento.getCliente().getNome() + "\n" +
            "\tNota: " + nota + "\n" +
            "\tComentário: '" + comentario + "'";
    }
}


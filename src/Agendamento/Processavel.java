package Agendamento;

public interface Processavel {

    double getValorAPagar();

    void processarPagamento();

    String getStatusPagamento();
}

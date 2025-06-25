package pessoa;

import Agendamento.Agendamento;
import Agendamento.Servico;
import Agendamento.StatusAgendamento;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void realizarAgendamento(ArrayList<Funcionario> listaDeFuncionarios, ArrayList<Servico> listaDeServicos, ArrayList<Agendamento> listaDeAgendamentos) {
        Scanner ler = new Scanner(System.in);
        System.out.println("\nOlá, " + this.getNome() + "! Vamos iniciar seu agendamento.");
        if (listaDeFuncionarios.isEmpty() || listaDeServicos.isEmpty()) { //isEmpty() vazio
            System.out.println("ERRO: Não há funcionários ou serviços disponíveis no momento. Contate o administrador.");
            return;
        }
        System.out.println("\nEscolha o serviço desejado:");
        for (int i = 0; i < listaDeServicos.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaDeServicos.get(i));
        }
        System.out.print("Opção de serviço: ");
        int escolhaServico = ler.nextInt();
        ler.nextLine();
        Servico servicoEscolhido = listaDeServicos.get(escolhaServico - 1);

        System.out.println("\nEscolha o funcionário para o atendimento:");
        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaDeFuncionarios.get(i).getNome());
        }
        System.out.print("Opção de funcionário: ");
        int escolhaFunc = ler.nextInt();
        ler.nextLine();
        Funcionario funcionarioDesignado = listaDeFuncionarios.get(escolhaFunc - 1);

        System.out.print("Digite o endereço completo para o serviço: ");
        String endereco = ler.nextLine();
        System.out.print("Digite a data (formato DDMMAAAA): ");
        int data = ler.nextInt();
        ler.nextLine();
        System.out.print("Digite a hora (formato HHMM): ");
        int hora = ler.nextInt();
        ler.nextLine();

        Agendamento novoAgendamento = new Agendamento(this, funcionarioDesignado, servicoEscolhido, endereco, data, hora, StatusAgendamento.AGENDADO);
        listaDeAgendamentos.add(novoAgendamento);

        System.out.println("\n>> AGENDAMENTO REALIZADO COM SUCESSO! <<");
        System.out.println("--- Resumo do Agendamento ---");
        System.out.println(novoAgendamento);
    }
}


package pessoa;

import Agendamento.Agendamento;
import Agendamento.Equipamento;
import Agendamento.Servico;
import Agendamento.StatusAgendamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    private int matricula;

    public Funcionario(String nome, int dataNasc, String cpf, int matricula) {
        super(nome, dataNasc, cpf);
        this.setMatricula(matricula);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n--- Dados do Técnico ---" +
                "\n Matrícula: " + this.matricula;
    }

    public void cadastrarEquipamento(ArrayList<Equipamento> listaDeEquipamentos) {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Cadastro de Novo Equipamento ---");
        System.out.print("Digite o nome do equipamento (ex: Ar Condicionado Split): ");
        String nome = ler.nextLine();
        System.out.print("Digite a marca do equipamento (ex: Samsung): ");
        String marca = ler.nextLine();
        Equipamento novoEquipamento = new Equipamento(nome, marca);
        listaDeEquipamentos.add(novoEquipamento);
        System.out.println("\n>> Equipamento '" + nome + "' cadastrado com sucesso por " + this.getNome() + "! <<");
    }

    public void cadastrarServico(ArrayList<Servico> listaDeServicos) {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Cadastro de Novo Serviço ---");
        System.out.print("Digite o tipo do serviço (ex: Limpeza, Instalação): ");
        String tipo = ler.nextLine();
        System.out.print("Digite o valor do serviço (ex: 150.50): ");
        double valor = ler.nextDouble();
        ler.nextLine();
        Servico novoServico = new Servico(tipo, valor);
        listaDeServicos.add(novoServico);
        System.out.println("\n>> Serviço '" + tipo + "' cadastrado com sucesso por " + this.getNome() + "! <<");
    }

    public void atualizarStatusAgendamento(ArrayList<Agendamento> listaDeAgendamentos) {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Atualizar Status de Agendamento ---");

        if (listaDeAgendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento no sistema para atualizar.");
            return;
        }

        System.out.println("Qual agendamento você deseja atualizar?");
        for (int i = 0; i < listaDeAgendamentos.size(); i++) {
            Agendamento ag = listaDeAgendamentos.get(i);
            System.out.println("\n[" + (i + 1) + "] Cliente: " + ag.getCliente().getNome() +
                    " | Data: " + ag.getData() +
                    " | Status Atual: " + ag.getStatusAgendamento());
        }
        System.out.print("\nDigite o número do agendamento (ou 0 para cancelar): ");
        int escolha = ler.nextInt();
        ler.nextLine();

        if (escolha > 0 && escolha <= listaDeAgendamentos.size()) {
            Agendamento agendamentoParaAtualizar = listaDeAgendamentos.get(escolha - 1);
            System.out.println("Escolha o novo status:");
            System.out.println("[1] " + StatusAgendamento.EM_ANDAMENTO);
            System.out.println("[2] " + StatusAgendamento.CONCLUIDO);
            System.out.println("[3] " + StatusAgendamento.CANCELADO);
            System.out.print("Opção: ");
            int opcaoStatus = ler.nextInt();
            ler.nextLine();

            StatusAgendamento novoStatus = null;
            if (opcaoStatus == 1) novoStatus = StatusAgendamento.EM_ANDAMENTO;
            else if (opcaoStatus == 2) novoStatus = StatusAgendamento.CONCLUIDO;
            else if (opcaoStatus == 3) novoStatus = StatusAgendamento.CANCELADO;

            if (novoStatus != null) {
                agendamentoParaAtualizar.setStatusAgendamento(novoStatus);
                System.out.println(">> Status do agendamento atualizado com sucesso por " + this.getNome() + "! <<");
            } else {
                System.out.println("Opção de status inválida.");
            }
        }
    }
}






package pessoa;
import Agendamento.Endereco;
import Agendamento.Agendamento;
import Agendamento.Servico;
import Agendamento.StatusAgendamento;
import Avaliacao.Avaliacao;

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

        System.out.println("\n--- Endereço do Serviço ---");
        System.out.print("Rua: ");
        String rua = ler.nextLine();
        System.out.print("Número: ");
        String numero = ler.nextLine();
        System.out.print("Bairro: ");
        String bairro = ler.nextLine();
        System.out.print("Cidade: ");
        String cidade = ler.nextLine();
        System.out.print("CEP: ");
        String cep = ler.nextLine();

        Endereco enderecoDoServico = new Endereco(rua, numero, bairro, cidade, cep);
        System.out.print("Digite a data (formato DDMMAAAA): ");
        int data = ler.nextInt();
        ler.nextLine();
        System.out.print("Digite a hora (formato HHMM): ");
        int hora = ler.nextInt();
        ler.nextLine();

        Agendamento novoAgendamento = new Agendamento(this, funcionarioDesignado, servicoEscolhido, enderecoDoServico, data, hora, StatusAgendamento.AGENDADO);
        listaDeAgendamentos.add(novoAgendamento);

        System.out.println("\n>> AGENDAMENTO REALIZADO COM SUCESSO! <<");
        System.out.println("--- Resumo do Agendamento ---");
        System.out.println(novoAgendamento);
    }

    public void avaliarAgendamento(ArrayList<Agendamento> listaDeAgendamentos, ArrayList<Avaliacao> listaDeAvaliacoes) {
        Scanner ler = new Scanner(System.in);
        System.out.println("\n--- Avaliar um Serviço ---");

        ArrayList<Agendamento> meusAgendamentos = new ArrayList<>();
        for (Agendamento ag : listaDeAgendamentos) {
            if (ag.getCliente() == this) {
                meusAgendamentos.add(ag);
            }
        }
        if (meusAgendamentos.isEmpty()) {
            System.out.println("Você não possui nenhum agendamento para avaliar.");
            return;
        }
        System.out.println("Selecione o agendamento que você deseja avaliar:");
        for (int i = 0; i < meusAgendamentos.size(); i++) {
            Agendamento ag = meusAgendamentos.get(i);
            System.out.println("[" + (i + 1) + "] Serviço: " + ag.getServico().getTipo() +
                    " | Status: " + ag.getStatusAgendamento());
        }
        System.out.print("\nDigite o número do serviço (ou 0 para cancelar): ");
        int escolha = ler.nextInt();
        ler.nextLine();
        if (escolha > 0 && escolha <= meusAgendamentos.size()) {
            Agendamento agendamentoAvaliado = meusAgendamentos.get(escolha - 1);
            System.out.print("Digite sua nota (de 0 a 10): ");
            int nota = ler.nextInt();
            ler.nextLine();
            System.out.print("Digite seu comentário: ");
            String comentario = ler.nextLine();
            Avaliacao novaAvaliacao = new Avaliacao(nota, comentario, agendamentoAvaliado);
            listaDeAvaliacoes.add(novaAvaliacao);
            System.out.println("\n>> Avaliação registrada com sucesso! Obrigado! <<");
        } else {
            System.out.println("Operação cancelada.");
        }
    }
}



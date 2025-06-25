package pessoa;

import Agendamento.Equipamento;
import Agendamento.Servico;

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
                "\n Matrícula: " + this.matricula ;
    }

    public void cadastrarEquipamento( ArrayList<Equipamento> listaDeEquipamentos) {
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
}





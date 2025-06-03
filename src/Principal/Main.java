package Principal;

import Agendamento.Equipamento;
import pessoa.Cliente;
import pessoa.Funcionario; // Nome atualizado, como você mencionou.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        ArrayList<Cliente> listaDeClientes = new ArrayList<>();
        ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();
        ArrayList<Equipamento> listaDeEquipamento = new ArrayList<>();

        int operacao = -1;

        while (operacao != 0) {
            System.out.println("\n-------------------------------------------------------------------");
            System.out.println("Sistema de Gerenciamento de Serviços de Ar-condicionado");
            System.out.println("[1] Gerenciar Clientes");
            System.out.println("[2] Gerenciar Funcionários");
            System.out.println("[3] Gerenciar Catálogo");
            System.out.println("[0] Sair do Sistema");
            System.out.print("Escolha uma operação: ");
            operacao = ler.nextInt();
            ler.nextLine(); // Limpando o "bug"

            if (operacao == 1) {
                System.out.println("\n--- Gerenciamento de Clientes ---");
                System.out.println("[1] Cadastrar Novo Cliente");
                System.out.println("[2] Listar Clientes Cadastrados");
                System.out.println("[3] Editar Cliente");
                System.out.println("[4] Excluir Cliente");
                System.out.println("[0] Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");
                int opcaoCliente = ler.nextInt();
                ler.nextLine();

                if (opcaoCliente == 1) {
                    System.out.println("\n--- Cadastro de Novo Cliente ---");
                    System.out.print("Digite o nome completo: ");
                    String nome = ler.nextLine();
                    System.out.print("Digite o ano de nascimento: ");
                    int dataNasc = ler.nextInt();
                    ler.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = ler.nextLine();
                    System.out.print("Digite seu telefone para contato: ");
                    String telefone = ler.nextLine();
                    Cliente novoCliente = new Cliente(nome, dataNasc, cpf, telefone);
                    listaDeClientes.add(novoCliente);
                    System.out.println("\n>> Cliente '" + nome + "' cadastrado com sucesso! <<");
                } else if (opcaoCliente == 2) {
                    System.out.println("\n--- Lista de Clientes Cadastrados ---");
                    if (listaDeClientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado ainda.");
                    } else {
                        for (Cliente cliente : listaDeClientes) {
                            System.out.println(cliente);
                            System.out.println("--------------------");
                        }
                    }
                } else if (opcaoCliente == 3) {
                    System.out.println("\n--- Editar Cliente ---");
                    if (listaDeClientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado para editar.");
                    } else {
                        System.out.println("Qual cliente você deseja editar?");
                        for (int i = 0; i < listaDeClientes.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + listaDeClientes.get(i).getNome());
                        }
                        System.out.print("\nDigite o número do cliente (ou 0 para cancelar): ");
                        int escolhaUsuario = ler.nextInt();
                        ler.nextLine();

                        if (escolhaUsuario > 0 && escolhaUsuario <= listaDeClientes.size()) {
                            Cliente clienteParaEditar = listaDeClientes.get(escolhaUsuario - 1);
                            int opcaoEdicao = -1;
                            while (opcaoEdicao != 0) {
                                System.out.println("\nEditando cliente: " + clienteParaEditar.getNome());
                                System.out.println("[1] Editar CPF");
                                System.out.println("[2] Editar Ano de Nascimento");
                                System.out.println("[3] Editar Telefone");
                                System.out.println("[0] Concluir Edição");
                                System.out.print("Escolha uma opção: ");
                                opcaoEdicao = ler.nextInt();
                                ler.nextLine();

                                if (opcaoEdicao == 1) {
                                    System.out.print("Digite o novo cpf: ");
                                    String novoCpf = ler.nextLine();
                                    clienteParaEditar.setCpf(novoCpf);
                                    System.out.println("CPF alterado com sucesso!");
                                } else if (opcaoEdicao == 2) {
                                    System.out.print("Digite o novo ano de nascimento: ");
                                    int novoAnoNasc = ler.nextInt();
                                    ler.nextLine();
                                    clienteParaEditar.setDataNasc(novoAnoNasc);
                                    System.out.println("Ano de nascimento alterado com sucesso!");
                                } else if (opcaoEdicao == 3) {
                                    System.out.print("Digite o novo telefone: ");
                                    String novoTelefone = ler.nextLine();
                                    clienteParaEditar.setTelefone(novoTelefone);
                                    System.out.println("Telefone alterado com sucesso!");
                                }
                            }
                        }
                    }
                } else if (opcaoCliente == 4) {
                    System.out.println("\n--- Excluir Cliente ---");
                    if (listaDeClientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado para excluir.");
                    } else {
                        System.out.println("Qual cliente você deseja excluir?");
                        for (int i = 0; i < listaDeClientes.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + listaDeClientes.get(i).getNome());
                        }
                        System.out.print("\nDigite o número do cliente (ou 0 para cancelar): ");
                        int escolhaUsuario = ler.nextInt();
                        ler.nextLine();
                        if (escolhaUsuario > 0 && escolhaUsuario <= listaDeClientes.size()) {
                            Cliente clienteParaExcluir = listaDeClientes.get(escolhaUsuario - 1);
                            System.out.println("\nVOCÊ TEM CERTEZA QUE DESEJA EXCLUIR O CLIENTE ABAIXO?");
                            System.out.println("--------------------------------------------------");
                            System.out.println(clienteParaExcluir);
                            System.out.println("--------------------------------------------------");
                            System.out.print("Digite 'Sim' para confirmar ou qualquer outra tecla para cancelar: ");
                            String confirmacao = ler.nextLine();
                            if (confirmacao.equalsIgnoreCase("Sim")) {
                                listaDeClientes.remove(clienteParaExcluir);
                                System.out.println("\n>> Cliente excluído com sucesso! <<");
                            } else {
                                System.out.println("\nOperação de exclusão cancelada.");
                            }
                        } else if (escolhaUsuario == 0) {
                            System.out.println("Operação de exclusão cancelada.");
                        } else {
                            System.out.println("Opção inválida! Nenhum cliente com esse número.");
                        }
                    }
                } else if (opcaoCliente != 0) {
                    System.out.println("Opção inválida! Voltando ao menu principal.");
                }

            } else if (operacao == 2) {
                System.out.println("\n--- Gerenciamento de Funcionários ---");
                System.out.println("[1] Cadastrar Novo Funcionário");
                System.out.println("[2] Listar Funcionários Cadastrados");
                System.out.println("[3] Editar Funcionário");
                System.out.println("[4] Excluir Funcionário");
                System.out.println("[0] Voltar ao menu principal");
                System.out.print("Escolha uma opção: ");
                int opcaoFuncionario = ler.nextInt();
                ler.nextLine();

                if (opcaoFuncionario == 1) {
                    System.out.println("\n--- Cadastro de Novo Funcionário ---");
                    System.out.print("Digite o Nome completo: ");
                    String nome = ler.nextLine();
                    System.out.print("Digite o ano de nascimento: ");
                    int dataNasc = ler.nextInt();
                    ler.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = ler.nextLine();
                    System.out.print("Digite a matrícula: ");
                    int matricula = ler.nextInt();
                    ler.nextLine();
                    Funcionario novoFuncionario = new Funcionario(nome, dataNasc,  cpf, matricula);
                    listaDeFuncionarios.add(novoFuncionario);
                    System.out.println("\n>> Funcionário '" + nome + "' cadastrado com sucesso! <<");
                } else if (opcaoFuncionario == 2) {
                    System.out.println("\n--- Lista de Funcionários Cadastrados ---");
                    if (listaDeFuncionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado ainda.");
                    } else {
                        for (Funcionario funcionario : listaDeFuncionarios) {
                            System.out.println(funcionario);
                            System.out.println("--------------------");
                        }
                    }
                }  else if (opcaoFuncionario == 3) {

                    System.out.println("\n--- Editar Funcionário ---");
                    if (listaDeFuncionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado para editar.");
                    } else {
                        System.out.println("Qual funcionário você deseja editar?");
                        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + listaDeFuncionarios.get(i).getNome());
                        }
                        System.out.print("\nDigite o número do funcionário (ou 0 para cancelar): ");
                        int escolhaUsuario = ler.nextInt();
                        ler.nextLine();

                        if (escolhaUsuario > 0 && escolhaUsuario <= listaDeFuncionarios.size()) {
                            Funcionario funcionarioParaEditar = listaDeFuncionarios.get(escolhaUsuario - 1);

                            int opcaoEdicao = -1;
                            while (opcaoEdicao != 0) {
                                System.out.println("\nEditando funcionário: " + funcionarioParaEditar.getNome());
                                System.out.println("[1] Editar Nome");
                                System.out.println("[2] Editar Ano de Nascimento");
                                System.out.println("[3] Editar CPF");
                                System.out.println("[4] Editar Matrícula");
                                System.out.println("[0] Concluir Edição");
                                System.out.print("Escolha uma opção: ");
                                opcaoEdicao = ler.nextInt();
                                ler.nextLine();

                                if (opcaoEdicao == 1) {
                                    System.out.print("Digite o novo nome: ");
                                    String novoNome = ler.nextLine();
                                    funcionarioParaEditar.setNome(novoNome);
                                    System.out.println("Nome alterado com sucesso!");
                                } else if (opcaoEdicao == 2) {
                                    System.out.print("Digite o novo ano de nascimento: ");
                                    int novoAno = ler.nextInt();
                                    ler.nextLine();
                                     funcionarioParaEditar.setDataNasc(novoAno);
                                    System.out.println("Ano de nascimento alterado com sucesso!");
                                } else if (opcaoEdicao == 3) {
                                    System.out.print("Digite o novo CPF: ");
                                    String novoCpf = ler.nextLine();
                                    funcionarioParaEditar.setCpf(novoCpf);
                                    System.out.println("CPF alterado com sucesso!");
                                } else if (opcaoEdicao == 4) {
                                    System.out.print("Digite a nova matrícula: ");
                                    int novaMatricula = ler.nextInt();
                                    ler.nextLine();
                                    funcionarioParaEditar.setMatricula(novaMatricula);
                                    System.out.println("Matrícula alterada com sucesso!");
                                }
                            }
                        } else if (escolhaUsuario != 0) {
                            System.out.println("Opção inválida!");
                        }
                    }
                } else if (opcaoFuncionario == 4) {
                    System.out.println("\n--- Excluir Funcionário ---");
                    if (listaDeFuncionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado para excluir.");
                    } else {
                        System.out.println("Qual funcionário você deseja excluir?");
                        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + listaDeFuncionarios.get(i).getNome());
                        }
                        System.out.print("\nDigite o número do funcionário (ou 0 para cancelar): ");
                        int escolhaUsuario = ler.nextInt();
                        ler.nextLine();

                        if (escolhaUsuario > 0 && escolhaUsuario <= listaDeFuncionarios.size()) {
                            Funcionario funcionarioParaExcluir = listaDeFuncionarios.get(escolhaUsuario - 1);

                            System.out.println("\nVOCÊ TEM CERTEZA QUE DESEJA EXCLUIR O FUNCIONÁRIO ABAIXO?");
                            System.out.println(funcionarioParaExcluir);
                            System.out.print("Digite 'S' para confirmar ou qualquer outra tecla para cancelar: ");
                            String confirmacao = ler.nextLine();

                            if (confirmacao.equalsIgnoreCase("S")) {
                                listaDeFuncionarios.remove(funcionarioParaExcluir);
                                System.out.println("\n>> Funcionário excluído com sucesso! <<");
                            } else {
                                System.out.println("\nOperação de exclusão cancelada.");
                            }
                        } else if (escolhaUsuario != 0) {
                            System.out.println("Opção inválida!");
                        }
                    }
                } else if (opcaoFuncionario != 0) {
                    System.out.println("Opção inválida! Voltando ao menu principal.");
                }
            } else if (operacao == 3) {
                System.out.println("\n--- Gerenciamento de Catálogo ---");
                System.out.println("[1] Cadastrar Novo Equipamento");
                System.out.println("[2] Listar Equipamentos");
                System.out.println("[3] Cadastrar Novo Serviço");
                System.out.println("[4] Listar Novo Serviço");
                System.out.println("[0] Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");
                int opcaoCatalogo = ler.nextInt();
                ler.nextLine();

                if (opcaoCatalogo == 1) {
                    System.out.println("\n--- Cadastro de Novo Equipamento ---");
                    System.out.print("Digite o nome do equipamento (ex: Ar Condicionado Split): ");
                    String nome = ler.nextLine();
                    System.out.print("Digite a marca do equipamento (ex: Samsung): ");
                    String marca = ler.nextLine();
                    Equipamento novoEquipamento = new Equipamento(nome, marca);
                    listaDeEquipamento.add(novoEquipamento);
                    System.out.println("\n>> Equipamento '" + nome + "' cadastrado com sucesso no catálogo! <<");
                } else if (opcaoCatalogo == 2) {
                    System.out.println("\n--- Lista de Equipamentos no Catálogo ---");
                    if (listaDeEquipamento.isEmpty()) {
                        System.out.println("Nenhum equipamento cadastrado ainda.");
                    } else {
                        for (int i = 0; i < listaDeEquipamento.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + listaDeEquipamento.get(i).toString());
                            System.out.println("--------------------");
                        }
                    }
                } else if (opcaoCatalogo != 0) {
                    System.out.println("Opção inválida! Voltando ao menu principal.");
                }
            } else if (operacao != 0) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}

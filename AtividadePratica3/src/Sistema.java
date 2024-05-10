//import do scanner...
import java.util.Scanner;


import Colaboradores.Funcionario;
import Colaboradores.Gerente;
import Colaboradores.Desenvolvedor;
import Colaboradores.Estagiario;

import Trabalho.Trabalho;

public class Sistema {
    private static Scanner scanner = new Scanner(System.in);

    private static void exibirMenu() {

        System.out.println("\n");
        System.out.println("[1] Cadastrar Funcionario");
        System.out.println("[2] Remover Funcionario");
        System.out.println("[3] Exibir Funcionario");
        System.out.println("[4] Listar todos os Funcionarios");
        System.out.println("|0| Sair...");
        System.out.print("\nInforme uma opção: ");
    }
    
    private static void verificarOpcao(int op) {
        switch (op) {
            case 1: 
            cadastrarNovoFuncionario();
                break;
            case 2: 
                removerFuncionario();
                break;
            case 3: 
                exibirFuncionario();
                break;
            case 4: 
                listarFuncionarios();
                break;
            case 0: 
                Saida();
                break;
            default:
                System.out.println("\nTente novamente...");
                break;
        }
    }

    private static void cadastrarNovoFuncionario() {
        System.out.println("Qual tipo de funcionário deseja cadastrar?");
        System.out.println("[1] Gerente");
        System.out.println("[2] Desenvolvedor");
        System.out.println("[3] Estagiario");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 
    
        switch (tipo) {
            case 1:
                System.out.println("Informe o nome do gerente:");
                String nomeGerente = scanner.nextLine();
    
                System.out.println("Informe a matrícula do gerente:");
                String matriculaGerente = scanner.nextLine();
    
                System.out.println("Informe a equipe sob gerência do gerente:");
                String equipeGerencia = scanner.nextLine();
    
                System.out.println("Informe o bônus do gerente:");
                float bonusGerente = scanner.nextFloat();
                scanner.nextLine(); 

                System.out.println("Informe o salário do gerente:");
                float salarioGerente = scanner.nextFloat();
                scanner.nextLine(); 

                Gerente gerente = new Gerente(nomeGerente, matriculaGerente, salarioGerente, equipeGerencia, bonusGerente);
                Cadastro.cadastrar(gerente);
                break;
            case 2:
                System.out.println("Informe o nome do desenvolvedor:");
                String nomeDesenvolvedor = scanner.nextLine();
    
                System.out.println("Informe a matrícula do desenvolvedor:");
                String matriculaDesenvolvedor = scanner.nextLine();
    
                System.out.println("Informe as linguagens do desenvolvedor:");
                String linguagensDesenvolvedor = scanner.nextLine();

                System.out.println("Informe o salário do desenvolvedor:");
                float salarioDesenvolvedor = scanner.nextFloat();
                scanner.nextLine(); 

                Desenvolvedor desenvolvedor = new Desenvolvedor(nomeDesenvolvedor, matriculaDesenvolvedor, salarioDesenvolvedor, linguagensDesenvolvedor);
                Cadastro.cadastrar(desenvolvedor);
                break;
            case 3:
                System.out.println("Informe o nome do estagiário:");
                String nomeEstagiario = scanner.nextLine();
    
                System.out.println("Informe a matrícula do estagiário:");
                String matriculaEstagiario = scanner.nextLine();
    
                System.out.println("Informe as horas de trabalho do estagiário:");
                float horasTrabalhoEstagiario = scanner.nextFloat();
                scanner.nextLine(); 
                
                System.out.println("Informe o nome do supervisor do estagiário:");
                String nomeSupervisorEstagiario = scanner.nextLine();

                System.out.println("Informe o salário do estagiário:");
                float salarioEstagiario = scanner.nextFloat();
                scanner.nextLine();

                Estagiario estagiario = new Estagiario(nomeEstagiario, matriculaEstagiario, salarioEstagiario, horasTrabalhoEstagiario, nomeSupervisorEstagiario);
                Cadastro.cadastrar(estagiario);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    
        System.out.println("\nFuncionário cadastrado com sucesso!");
        enterParaSeguir();
    }
    
    private static void removerFuncionario(){
        System.out.println("Informe a Matricula do funcionario a ser excluído:");
        String matricula = scanner.nextLine();
        for (Funcionario funcionario : Cadastro.getListaFuncionarios()) {
            if (funcionario.getMatricula().equals(matricula)) {
                Cadastro.getListaFuncionarios().remove(funcionario);
                System.out.println("Funcionario excluído com sucesso!");
                enterParaSeguir();
                return;
            }
        }
        System.out.println("Funcionario não encontrado.");
    }

    private static void exibirFuncionario() {
        System.out.println("Informe a matrícula do funcionário:");
        String matricula = scanner.nextLine();
        
        for (Funcionario funcionario : Cadastro.getListaFuncionarios()) {
            if (funcionario.getMatricula().equals(matricula)) {
                System.out.println("Funcionário encontrado:");
                System.out.println(funcionario.toString());

                if (funcionario instanceof Trabalho) {
                    Trabalho trabalho = (Trabalho) funcionario;

                    System.out.println("\nTrabalhando: " + trabalho.trabalhar());
                    System.out.println("Progresso: " + trabalho.relatarProgresso());

                    float salario = funcionario.calcularSalario();
                    System.out.println("Salário: " + salario);               
                } 
                enterParaSeguir();
                return;
            }
        }
        
        System.out.println("Funcionário não encontrado.");
    }

        private static void listarFuncionarios() {
        if (Cadastro.getListaFuncionarios().isEmpty()) {
            System.out.println("\nNão há FUncionarios cadastrados.");
        } else {
            System.out.println("\nLista de Funcionarios:");
            for (Funcionario funcionario : Cadastro.getListaFuncionarios()) {
                System.out.println(funcionario.toString());

                if (funcionario instanceof Trabalho) {
                    Trabalho trabalho = (Trabalho) funcionario;

                    System.out.println("\nTrabalhando: " + trabalho.trabalhar());
                    System.out.println("Progresso: " + trabalho.relatarProgresso());
                        
                    //imprime o salario de cada funcionario respectivamente..
                    float salario = funcionario.calcularSalario();
                    System.out.println("Salário: " + salario);   
                }
            }
            enterParaSeguir();
    }
    }
    

    public static void enterParaSeguir() {
        System.out.println("\nClique em qualquer tecla para continuar");
        scanner.nextLine();
    }
    private static void Saida(){
        System.out.println("\nO programa foi finalizado...");
    }
    public static void executar() {
        int op;
        do {
            exibirMenu();
            op = scanner.nextInt();
            scanner.nextLine(); 
            verificarOpcao(op);
        } while (op != 0);
    }
}
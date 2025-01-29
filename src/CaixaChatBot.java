import banco.entidades.Agencia;
import banco.entidades.Conta;
import banco.entidades.ContaSimples;

import java.util.Scanner;

public class CaixaChatBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha = 1;

        while (escolha == 1 || escolha == 2) {

            System.out.printf("1. para criar uma nova conta\n2. para localizar uma conta já existente através de seu número.\n> ");
            escolha = sc.nextInt();
            sc.nextLine();

            if (escolha == 1) {
                criarConta();
            }
            else if (escolha == 2) {
                Agencia.abrirCaixa();
                Conta contaLocalizada = localizarConta();

                int operacao = 1;
                while (operacao <5){
                    double valorOperacao;
                    operacao = menuDeOperacoes();
                    switch (operacao) {
                        case 1:
                            System.out.println("Valor à se depositar: ");
                            valorOperacao = sc.nextDouble();
                            contaLocalizada.depositar(valorOperacao);
                            System.out.println("Depósito de R$: " + valorOperacao + " relizado com sucesso!");
                            System.out.println("saldo atual R$: " + contaLocalizada.getSaldo());
                            separador();
                            break;
                        case 2:
                            System.out.println("Valor à se sacar: ");
                            valorOperacao = sc.nextDouble();
                            if (valorOperacao > contaLocalizada.getSaldo()) {
                                System.out.println("Saldo insuficiente.");
                                separador();
                            } else {
                                contaLocalizada.sacar(valorOperacao);
                                System.out.println("Sauque de R$: " + valorOperacao + " relizado com sucesso!");
                                System.out.println("saldo atual R$: " + contaLocalizada.getSaldo());
                                separador();
                            }
                            break;
                        case 3:
                            Conta contaTransferencia = localizarContaTransferencia();
                            System.out.println("Valor à transferir: ");
                            valorOperacao = sc.nextDouble();
                            contaLocalizada.transferir(contaTransferencia, valorOperacao);
                            System.out.println("Transferência de R$: " + valorOperacao + " para " + contaTransferencia.getNome() + " relizado com sucesso!");
                            System.out.println("saldo atual R$: " + contaLocalizada.getSaldo());

                            break;
                        case 4:
                            separador();
                            System.out.println("O saldo da conta informada é de R$: " + contaLocalizada.getSaldo());
                            separador();
                            break;
                        case 5:
                            System.out.println("Saindo da conta...");
                            System.out.println("O Saldo final da conta de " + contaLocalizada.getTitular() + "é de R$: " + contaLocalizada.getSaldo());
                            System.out.println(" ");
                            Agencia.fecharCaixa();
                            break;
                    }
                }
            }
            else {
                System.out.println("Execução finalizada.");
            }
        }
    }

    private static void separador() {
        System.out.println("=======================================");
    }

    private static Conta localizarContaTransferencia() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o número da conta de destino para efetuar a transferência:\n>  ");
        long conta = sc.nextLong();
        Conta contaLocalizada = Agencia.localizarConta(conta);
        separador();
        System.out.println("Conta localizada com sucesso!");
        System.out.println(contaLocalizada.getNome());
        separador();
        return contaLocalizada;
    }

    private static Conta localizarConta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o número da conta a ser localizada:\n>  ");
        long conta = sc.nextLong();
        Conta contaLocalizada = Agencia.localizarConta(conta);
        separador();
        System.out.println("Conta localizada com sucesso!");
        System.out.println(contaLocalizada);
        separador();
        return contaLocalizada;
    }

    private static void criarConta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o titular da conta: ");
        String nome = sc.nextLine();

        System.out.print("Informe o CPF do titular da conta: ");
        String cpf = sc.nextLine();

        ContaSimples conta1 = new ContaSimples(nome, cpf);

        Agencia.abrirCaixa();
        Agencia.addConta(conta1);
        Agencia.fecharCaixa();
        separador();
        System.out.println("Conta criada com sucesso!");
        System.out.println(conta1);
        separador();
    }

    private static int menuDeOperacoes() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">> Agora escolha uma das operações a seguir: ");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Transferir");
        System.out.println("4. Saldo");
        System.out.println("5. Sair");
        System.out.print("> ");

        int opcao = sc.nextInt();
        return opcao;
    }
}

/*
Escreva um programa chamado CaixaChatBot.

Este chatbot deve ter as seguintes opções de uso:

1. para criar uma nova conta
- (que deve ser salva na agência), antes de encerrar o programa imprima na tela a conta criada.

2. para localizar uma conta já existente através de seu número.
 - Para isso deve pedir ao usuario o número da conta a ser localizada.

Com a conta recuperada o menu de opções do bot deve mudar para as seguintes opções:

    1. Depositar

    2. Sacar

    3. Transferir

    4. Saldo

    5. Sair

Realize o desejo do usuário e em seguida, se a opção não é a de sair, apresente o menu novamente. Para cada opção é preciso solicitar do usuário os dados necessários para a operação.  Se o usuário quer sacar, pergunte quanto e saque... Se quer transferir pergunte para que conta (número) e o valor...

Fique neste loop até que o usuário deseje sair do programa. Antes de terminar o programa imprima o saldo final da conta e feche a agência para salvar a conta manipulada.

Copie e cole aqui o conteúdo do arquivo  CaixaChatBotTESTE .java que você desenvolver. Lembre de escrever um código fácil de entender e que segue as regras de estilo de programação Java.*/
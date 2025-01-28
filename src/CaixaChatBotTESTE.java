import java.util.Scanner;

public class CaixaChatBotTESTE {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);

        System.out.printf("1. para criar uma nova conta\n2. para localizar uma conta já existente através de seu número.\nOpção: ");
        int op = sc.nextInt();

        while (op != 1 && op != 2) {
            System.out.print("Opção inválida, tente novamente: ");
            op = sc.nextInt();
        }
        switch (op) {
            case 1:
                System.out.println("Código para criar uma conta...");
                break;
            case 2:
                System.out.println("Código para acessar conta...");
                break;
        }

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

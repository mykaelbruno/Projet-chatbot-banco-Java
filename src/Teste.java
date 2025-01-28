import banco.entidades.Agencia;
import banco.entidades.ContaSimples;

public class Teste {
    public static void main(String[] args) {
        ContaSimples conta = new ContaSimples("Raquel", "00011122233");

        System.out.println(conta);

        Agencia.abrirCaixa();
        Agencia.addConta(conta);
        Agencia.fecharCaixa();

        ContaSimples contaLocalizada = (ContaSimples) Agencia.localizarConta(2);
        System.out.println(contaLocalizada);
    }
}
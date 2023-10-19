// Abstract Expressao
interface Expressao {
    int interpret();
}

// Terminal Expressao
class NumeroExpressao implements Expressao {
    private int numero;

    public NumeroExpressao(int numero) {
        this.numero = numero;
    }

    public int interpret() {
        return numero;
    }
}

// Non-Terminal Expressao
class juntarExxpressao implements Expressao {
    private Expressao left;
    private Expressao right;

    public juntarExxpressao(Expressao left, Expressao right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

public class Main {
    public static void main(String[] args) {
        Expressao expressao = new juntarExxpressao(new NumeroExpressao(2), new NumeroExpressao(8));

        int resultado = expressao.interpret();
        System.out.println("resultadoado: " + resultado);
    }
}

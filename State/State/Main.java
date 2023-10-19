interface estadoMaquinaVendas {
    void inserirMoeda();
    void selecionarProduto();
    void soltarProduto();
}

// Concrete States (Estados Concretos)
class estadoSemMoeda implements estadoMaquinaVendas {
    public void inserirMoeda() {
        System.out.println("Moeda inserida.");
    }

    public void selecionarProduto() {
        System.out.println("Por favor, insira a moeda primeiro.");
    }

    public void soltarProduto() {
        System.out.println("Por favor, selecione o produto primeiro.");
    }
}

class HasCoinState implements estadoMaquinaVendas {
    public void inserirMoeda() {
        System.out.println("Você não pode inserir outra moeda.");
    }

    public void selecionarProduto() {
        System.out.println("Produto selecionado.");
    }

    public void soltarProduto() {
        System.out.println("Produto enviado.");
    }
}

// Context (Contexto)
class MaquinaVendas {
    private estadoMaquinaVendas state;

    public MaquinaVendas() {
        state = new estadoSemMoeda();
    }

    public void setEstado(estadoMaquinaVendas state) {
        this.state = state;
    }

    public void inserirMoeda() {
        state.inserirMoeda();
    }

    public void selecionarProduto() {
        state.selecionarProduto();
    }

    public void soltarProduto() {
        state.soltarProduto();
    }
}

public class Main {
    public static void main(String[] args) {
        MaquinaVendas maquinaVendas = new MaquinaVendas();

        maquinaVendas.inserirMoeda();
        maquinaVendas.selecionarProduto();
        maquinaVendas.soltarProduto();

        maquinaVendas.setEstado(new HasCoinState());

        maquinaVendas.inserirMoeda();
        maquinaVendas.selecionarProduto();
        maquinaVendas.soltarProduto();
    }
}
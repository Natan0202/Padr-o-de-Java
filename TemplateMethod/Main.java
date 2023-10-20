abstract class Documento {
    public void CriarDocumento() {
        abrir();
        adicionarCabecalho();
        adicionarConteudo();
        adicionarRodape();
        fechar();
    }

    protected abstract void abrir();
    protected abstract void adicionarCabecalho();
    protected abstract void adicionarConteudo();
    protected abstract void adicionarRodape();
    protected abstract void fechar();
}

// Concrete Class
class TextoDocumento extends Documento {
    protected void abrir() {
        System.out.println("Texto aberto.");
    }

    protected void adicionarCabecalho() {
        System.out.println("Cabecalho adicionado.");
    }

    protected void adicionarConteudo() {
        System.out.println("Conteudo adicionado.");
    }

    protected void adicionarRodape() {
        System.out.println("Rodape adicionado.");
    }

    protected void fechar() {
        System.out.println("Fechado.");
    }
}

class Main {
    public static void main(String[] args) {
        Documento documento = new TextoDocumento();
        documento.CriarDocumento();
    }
}

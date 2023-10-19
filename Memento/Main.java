class DocumentMemento {
    private String conteudo;

    public DocumentMemento(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getconteudo() {
        return conteudo;
    }
}

// Originator
class Document {
    private String conteudo;

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public DocumentMemento createMemento() {
        return new DocumentMemento(conteudo);
    }

    public void restoreMemento(DocumentMemento memento) {
        conteudo = memento.getconteudo();
    }

    public void escreverConteudo() {
        System.out.println("Conteudo do documento: " + conteudo);
    }
}

public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        document.setConteudo("Conteudo!!!");

        document.escreverConteudo();

        DocumentMemento memento = document.createMemento();

        document.setConteudo("Um novo conteudo aparece!");
        document.escreverConteudo();

        document.restoreMemento(memento);
        document.escreverConteudo();
    }
}
interface DocumentElement {
    void accept(Visitor visitor);
}

class TextElement implements DocumentElement {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class ImageElement implements DocumentElement {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(TextElement text);
    void visit(ImageElement image);
}

class DocumentExporter implements Visitor {
    public void visit(TextElement text) {
        System.out.println("Exportando elemnto de texto");
    }

    public void visit(ImageElement image) {
        System.out.println("Exportando elemento de imagem");
    }
}

public class Main {
    public static void main(String[] args) {
        DocumentElement[] elements = {new TextElement(), new ImageElement()};
        DocumentExporter exporter = new DocumentExporter();

        for (DocumentElement element : elements) {
            element.accept(exporter);
        }
    }
}
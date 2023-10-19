import java.util.ArrayList;
import java.util.List;

// Subject (Sujeito)
class PublicadorNoticias {
    private List<Observer> observers = new ArrayList<>();
    private String noticias;

    public void adicionarObservador(Observer observer) {
        observers.add(observer);
    }

    public void removerObservador(Observer observer) {
        observers.remove(observer);
    }

    public void publicarNoticia(String noticias) {
        this.noticias = noticias;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observer observer : observers) {
            observer.atualizar(noticias);
        }
    }
}

// Observer (Observador)
interface Observer {
    void atualizar(String noticias);
}

// Concrete Observers (Observadores Concretos)
class Inscrito implements Observer {
    private String nome;

    public Inscrito(String nome) {
        this.nome = nome;
    }

    public void atualizar(String noticias) {
        System.out.println(nome + " Recebeu noticias: " + noticias);
    }
}

public class Main {
    public static void main(String[] args) {
        PublicadorNoticias PublicadorNoticias = new PublicadorNoticias();

        Inscrito inscrito1 = new Inscrito("Raphael");
        Inscrito inscrito2 = new Inscrito("Vanessa");

        PublicadorNoticias.adicionarObservador(inscrito1);
        PublicadorNoticias.adicionarObservador(inscrito2);

        PublicadorNoticias.publicarNoticia("noticias novas: Nova tecnologia lancada!");
    }
}
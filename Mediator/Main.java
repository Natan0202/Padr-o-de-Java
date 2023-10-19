import java.util.ArrayList;
import java.util.List;

// mediador
class MediadorChat {
    private List<UsuarioChat> users = new ArrayList<>();

    public void adcionarUsuario(UsuarioChat user) {
        users.add(user);
    }

    public void enviarMensagem(String mensagem, UsuarioChat enviaer) {
        for (UsuarioChat user : users) {
            if (user != enviaer) {
                user.recebe(mensagem);
            }
        }
    }
}

// Colleague
class UsuarioChat {
    private String nome;
    private MediadorChat mediador;

    public UsuarioChat(String nome, MediadorChat mediador) {
        this.nome = nome;
        this.mediador = mediador;
    }

    public void envia(String mensagem) {
        System.out.println(nome + " envia: " + mensagem);
        mediador.enviarMensagem(mensagem, this);
    }

    public void recebe(String mensagem) {
        System.out.println(nome + " recebe: " + mensagem);
    }
}

public class Main {
    public static void main(String[] args) {
        MediadorChat MediadorChat = new MediadorChat();

        UsuarioChat user1 = new UsuarioChat("Raphael", MediadorChat);
        UsuarioChat user2 = new UsuarioChat("Karl", MediadorChat);
        UsuarioChat user3 = new UsuarioChat("Sakura", MediadorChat);

        MediadorChat.adcionarUsuario(user1);
        MediadorChat.adcionarUsuario(user2);
        MediadorChat.adcionarUsuario(user3);

        user1.envia("Eae Pessoal!");
    }
}
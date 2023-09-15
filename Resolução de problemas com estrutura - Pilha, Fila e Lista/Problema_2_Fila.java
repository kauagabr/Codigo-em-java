package atv_Estrutura_de_dados_2;
import java.util.LinkedList;
import java.util.Queue;

// Problema: Implementação de um Sistema de Histórico de Mensagens em um Aplicativo de Chat
// Explicação: Nesse problema, precisamos implementar um sistema de histórico de mensagens 
// 			   em um aplicativo de chat, permitindo a exibição das mensagens trocadas.

public class Problema_2_Fila {
    private Queue<String> messages;

    public Problema_2_Fila() {
        messages = new LinkedList<>();
    }

    public void sendMessage(String message) {
        messages.add(message);
    }

    public void displayMessages() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        Problema_2_Fila chat = new Problema_2_Fila();

        chat.sendMessage("User1: Hello!");
        chat.sendMessage("User2: Hi there!");
        chat.sendMessage("User1: How are you?");

        chat.displayMessages(); 
                               
                               
    }
}
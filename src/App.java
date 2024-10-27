import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Client> clients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Remover Cliente");
            System.out.println("5 - Buscar Cliente");
            System.out.println("6 - Sair");

            int option = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer

            switch (option) {
                case 1 -> addClient();
                case 2 -> listClients();
                case 3 -> updateClient();
                case 4 -> removeClient();
                case 5 -> searchClient();
                case 6 -> {
                    System.out.println("Encerrando o sistema.");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void addClient() {
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer
        System.out.print("Digite o Nome: ");
        String name = scanner.nextLine();
        System.out.print("Digite o Email: ");
        String email = scanner.nextLine();
        System.out.print("Digite o Telefone: ");
        String phone = scanner.nextLine();

        Client client = new Client(id, name, email, phone);
        clients.add(client);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listClients() {
        if (clients.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Client client : clients) {
                System.out.println("ID: " + client.getId() + ", Nome: " + client.getName() +
                                   ", Email: " + client.getEmail() + ", Telefone: " + client.getPhone());
            }
        }
    }

    private static void updateClient() {
        System.out.print("Digite o ID do cliente que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer

        Client client = findClientById(id);
        if (client != null) {
            System.out.print("Novo Nome: ");
            client.setName(scanner.nextLine());
            System.out.print("Novo Email: ");
            client.setEmail(scanner.nextLine());
            System.out.print("Novo Telefone: ");
            client.setPhone(scanner.nextLine());
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void removeClient() {
        System.out.print("Digite o ID do cliente que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer

        Client client = findClientById(id);
        if (client != null) {
            clients.remove(client);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void searchClient() {
        System.out.print("Digite o ID do cliente que deseja buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpa o buffer

        Client client = findClientById(id);
        if (client != null) {
            System.out.println("Cliente encontrado: ID: " + client.getId() +
                               ", Nome: " + client.getName() +
                               ", Email: " + client.getEmail() +
                               ", Telefone: " + client.getPhone());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static Client findClientById(int id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        return null;
    }
}

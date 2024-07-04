package CRUD;

import java.util.List;

    public class Demo {
        public static void main(String[] args) {
            ClientService clientService = new ClientService();

            long clientId1 = clientService.create("ABC Corp");
            long clientId2 = clientService.create("XYZ Inc");
            long clientId3 = clientService.create("Global Solutions");

            System.out.println("Створено клієнтів:");
            System.out.println("ID: " + clientId1 + ", Name: " + clientService.getById(clientId1));
            System.out.println("ID: " + clientId2 + ", Name: " + clientService.getById(clientId2));
            System.out.println("ID: " + clientId3 + ", Name: " + clientService.getById(clientId3));

            clientService.setName(clientId1, "Updated ABC Corp");
            System.out.println("Оновлене ім'я клієнта з ID: " + clientId1 + " - " + clientService.getById(clientId1));

            clientService.deleteById(clientId2);
            System.out.println("Клієнт з ID: " + clientId2 + " видалений.");

            List<Client> clients = clientService.listAll();
            System.out.println("Всі клієнти:");
            for (Client client : clients) {
                System.out.println("ID: " + client.getId() + ", Name: " + client.getName());
            }
        }
    }

package org.example.event;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем хранилище событий
        EventStore eventStore = new EventStore();
        // Создаем банковский счет
        BankAccount bankAccount = new BankAccount(eventStore);
        // Выполняем операции счета
        bankAccount.deposit(200);
        bankAccount.withdraw(50);
        bankAccount.deposit(100);
        bankAccount.withdraw(80);

        // Получаем список событий
        List<Event> events = eventStore.getEvents();

        // Восстанавливаем состояние счета
        BankAccount restoredAccount = new BankAccount(new EventStore());
        for (Event event : events) {
            if ("DEPOSIT".equals(event.getEventType())) {
                int amount = Integer.parseInt(event.getEventData());
                restoredAccount.deposit(amount);
            } else if ("WITHDRAW".equals(event.getEventType())) {
                int amount = Integer.parseInt(event.getEventData());
                restoredAccount.withdraw(amount);
            }
        }

        // Выводим информацию
        System.out.println("Original Balance: " + bankAccount.getBalance());
        System.out.println("Restored Balance: " + restoredAccount.getBalance());
    }
}
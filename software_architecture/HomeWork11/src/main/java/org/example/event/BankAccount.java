package org.example.event;

// Класс, представляющий банковский счет
public class BankAccount {
    private int balance = 0;                  // Баланс счета
    private EventStore eventStore;            // Хранилище событий

    public BankAccount(EventStore eventStore) {
        this.eventStore = eventStore;
    }
    // Метод для внесения денег на счет
    public void deposit(int amount) {
        if (amount > 0) {
            Event depositEvent = new Event("DEPOSIT", String.valueOf(amount));
            eventStore.addEvent(depositEvent);
            balance += amount;
        }
    }
    // Метод для снятия денег со счета
    public void withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            Event withdrawEvent = new Event("WITHDRAW", String.valueOf(amount));
            eventStore.addEvent(withdrawEvent);
            balance -= amount;
        }
    }
    // Метод для получения текущего баланса
    public int getBalance() {
        return balance;
    }
}

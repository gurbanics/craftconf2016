package org.craftconf;

public class AccountService {

    private MyClock clock;
    private TransactionRepository transactionRepository;

    public AccountService(MyClock clock, TransactionRepository transactionRepository) {
        this.clock = clock;
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {

        Transaction transaction = new Transaction(clock.getCurrentDate(), amount);

        transactionRepository.store(transaction);

    }

    public void withdraw(int amount) {
        Transaction transaction = new Transaction(clock.getCurrentDate(), -amount);

        transactionRepository.store(transaction);

    }

    public void printStatement() {

    }

}

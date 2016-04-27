package org.craftconf;

public class Transaction {

    private int amount;
    private String date;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Transaction)) {
            return false;
        }
        Transaction otherTransaction = (Transaction) other;
        return otherTransaction.getAmount() == amount && otherTransaction.getDate().equals(date);
    }
    // TODO: hashcode
}

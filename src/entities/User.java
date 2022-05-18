package entities;


import execeptions.NegotiationExecution;

public class User {

    private Integer number; //numero da conta
    private String holder; //titular
    private Double balance; // saldo
    private Double withdrawLimit; //limite de saque

    public User() {
    }

    public User(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        validateWithdraw(amount);
        balance -= amount;
    }

    private void validateWithdraw(double amount) {
        if (amount > getWithdrawLimit()) {
            throw new NegotiationExecution("Erro de saque: A quantia excede o limite de saque");
        }
        if (amount > getBalance()) {
            throw new NegotiationExecution("Erro de saque: Saldo insuficiente");
        }
    }
}

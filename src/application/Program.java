package application;

/*programa para de conta bancaria tem regras de saque, deposito e tratar as regras  nos erros com as mensages
corretar.
/*Fazer um programa para ler os dados de uma conta bancária  e depois realizar um saque
 não pode ocorrer ou se não houver saldo na conta, ou se o valor do saque for superior ao limite
 de saque da conta. Implemente a conta  bancária.*/

import entities.User;
import execeptions.NegotiationExecution;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Titular: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();
        System.out.print("Limite de saque: ");
        double withdrawLimit = sc.nextDouble();

        User acc = new User(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Informe uma quantia para sacar: ");
        double amount = sc.nextDouble();

        try { // tentar
            acc.withdraw(amount);
            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());

        }
        catch (NegotiationExecution e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

}

package ru.geekbrains.jc.hw.fourth;

import java.util.List;
import java.util.Random;

public class Account {
    private double balance;
    private int accountNumber;
    private String password;
    private String login;


    private Account(String login, String password){
        Random random = new Random();

        this.login = login;
        this.password = password;
        this.balance = 0;
        this.accountNumber = random.nextInt(1, 101);;
    }
    public void setBalance(double balance){
        if (balance < 0){
            throw new IllegalArgumentException("Отрицательный баланс на вашем счете заставит вас выплачивать долг банку.\n" +
                    " ".repeat(63)+ "Рекомендую вам ввести положительный баланс.");
        }
       this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public void addBalance(double addingMoney){
        if(addingMoney < 0){
            throw new IllegalArgumentException("Отрицательная сумма не может пополнить ваш баланс");
        }
        this.balance += addingMoney;
    }
    public void cashMoney(double cashMoney)throws InsufficientFundsException{
        if (cashMoney > this.balance){
            throw new InsufficientFundsException("Недостаточно средств на счете");
        }
        if (cashMoney < 0 ){
            throw new IllegalArgumentException("Отрицательная сумму нельзя обналичить.");
        }
        this.balance -= cashMoney;
    }


    public String getLogin(){
        return login;
    }
    public boolean checkPassword(String password){
        if (this.password.equals(password)){return true;}
        else {
            System.out.println("Не правильный пароль");
            return false;
        }
    }
    public String toString(){
        return "Login - "  + login + ", Account № " + accountNumber +", Balance - " + balance;
    }
    public static Account createAccount(List<Account> accounts){
        String login = Input.inputString("Введите логин -> ");
        String password = Input.inputString("Введите пароль -> ");
        for (Account account : accounts) {
            if (account.getLogin().equals(login)){
                System.out.println("Такой логин уже используется. Попробуйте изменить на другое");
                createAccount(accounts);
            }
        }
        System.out.println("Аккаунт создан с логином " + login);
        return new Account(login, password);
    }


}

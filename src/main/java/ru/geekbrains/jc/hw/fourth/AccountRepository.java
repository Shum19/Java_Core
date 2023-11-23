package ru.geekbrains.jc.hw.fourth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountRepository {
    private List <Account> accounts;
    private Account account;
    public AccountRepository(){
        accounts = new ArrayList<>();
    }
    public void addAccount (Account account){
        this.accounts.add(account);
    }
    public Account getAccount(int index){
        return accounts.get(index);
    }

    public boolean enterInAccount(String login, String password){
        if(findAccount(login)){
            if (this.account.checkPassword(password)) {
                return true;
            }
        }
        this.account = null;
        return false;
    }

    public List<Account> getAccounts(){
        return this.accounts;
    }
    public Account getAccount(){
        return account;
    }
    private boolean findAccount(String login){
        for (Account account: accounts) {
            if (account.getLogin().equals(login)){
                this.account = account;
                return true;
            }
        }
        System.out.println("Неправильный логин");
        return false;
    }

}

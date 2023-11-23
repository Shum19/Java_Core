package ru.geekbrains.jc.hw.fourth;

public class AccountApp {
    public static void main(String [] args) {
        AccountRepository accountRepository = new AccountRepository();




        boolean flag = true;

        while (flag) {
            String option = Input.inputString("Выберете один из вариантов\n" +
                                                    "1. Зарегистрироваться.\n" +
                                                    "2. Войти в личный кабинет.\n"+
                                                    "3. Выйти\n");
            System.out.println("*".repeat(20));
            switch (option){
                case "1":
                    accountRepository.addAccount(Account.createAccount(accountRepository.getAccounts()));
                    System.out.println("*".repeat(20));
                    break;
                case "2":
                    if(accountRepository.getAccounts().size() == 0){
                        System.out.println("Нет зарегистрированных аккаунтов");
                        System.out.println("*".repeat(20));
                        break;
                    }
                    String login = Input.inputString("Введите логин -> ");
                    String password = Input.inputString("Введите пароль -> ");
                    if (accountRepository.enterInAccount(login, password)){
                        Account account = accountRepository.getAccount();
                        boolean manage = true;
                        while (manage) {
                            System.out.println(account.toString());
                            String optionSecond = Input.inputString("Управление счетом:\n" +
                                                                         "1. Внести первую сумму наличных.\n" +
                                                                         "2. Пополнить Баланс.\n" +
                                                                         "3. Снять наличные.\n" +
                                                                         "4. Выйти\n");
                            switch (optionSecond) {
                                case "1":
                                    System.out.println("Ваш текущий баланс " + account.getBalance());
                                    account.setBalance(Input.inputDouble("Введите первую сумму наличных ->"));
                                    System.out.println("Ваш новый баланс " + account.getBalance());
                                    break;
                                case "2":
                                    System.out.println("Ваш текущий баланс " + account.getBalance());
                                    double addingCash = Input.inputDouble("Введите сумму наличных ->");
                                    account.addBalance(addingCash);
                                    System.out.println("Вы внесли сумму наличных " + addingCash +
                                                        "Ваш новый баланс " + account.getBalance());
                                    break;
                                case "3":
                                    System.out.println("Ваш текущий баланс " + account.getBalance());
                                    double cash = Input.inputDouble("Введите сумму для снятия наличных ->");
                                    try {
                                        account.cashMoney(cash);
                                        System.out.println("Вы сняли сумму наличных " + cash +
                                                "Ваш новый баланс " + account.getBalance());
                                    }catch (InsufficientFundsException e){
                                        e.getMessage();
                                    }
                                    break;
                                case "4":
                                    manage = false;
                            }
                        }
                    }
                    break;
                case "3":
                    flag = false;
            }
        }
    }
}

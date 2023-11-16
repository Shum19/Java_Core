package ru.geekbrains.jc.hw.second;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = '0';
    private static final char EMPTY_DOT = '*';
    private static int WIN_COUNT = 3;
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);
    private static char [][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int aiX = 0;
    private static int aiY = 0;
    public static void main(String [] args){
        String flag = "";
        do {
            createField();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (isWin(HUMAN_DOT)) {
                    System.out.println("Поздравляем игрока Крестиков с ПОБЕДОЙ");
                    break;
                }

                if (isDrawnGame()){
                    System.out.println("Ничья");
                    break;
                }

                aiTurn();
                printField();
                if (isWin(AI_DOT)) {
                    System.out.println("Поздравляем игрока Ноликов с ПОБЕДОЙ");
                    break;
                }

            }
            System.out.println("Если вы хотите продолжить игру то введите Y");
            flag = input.next();
        }while (flag.equalsIgnoreCase("Y"));
    }

    /**
     * Создание игрового поля. Размеры необходимо вводить в ручную с консоли. Таким образам достигается универсальность
     * игры.
     */
    private static void createField(){
        System.out.print("Введите число рядов от 3 и выше для игрового поля ->> ");
        fieldSizeX = input.nextInt();
        fieldSizeY = fieldSizeX;
        if (fieldSizeX > 3){
            WIN_COUNT = 4;
        }
        field = new char[fieldSizeY][fieldSizeX];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = EMPTY_DOT;
            }
        }
    }

    /**
     * Вывод игрового поля в консоль.
     */
    private static void printField(){
        System.out.print("+");
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print("-" + (x + 1));
        }
        System.out.println("-");
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print((x+1) + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }
        int footerLine = fieldSizeY*2+2;
        for (int x = 0; x < footerLine; x++) {
            System.out.print("-");
        }
        System.out.println();
    }
    private static void humanTurn(){
        int x, y;
        do{
            System.out.print("Введите номер столбца --> ");
            y = input.nextInt() - 1;
            System.out.print("Введите номер строки --> ");
            x = input.nextInt() - 1;
            if(!isOutOfIndex(x, y)){
                System.out.println("Вы ввели номер строки/столбца ячейки за пределами поля. Попробуйте ещё раз.");
            } else if(!isEmpty(x, y)){
                if (field[x][y] == AI_DOT){
                    System.out.println("Ячейка используется вашим соперником. Выбирайте ячейку с *!");
                }else {
                    System.out.println("Вы уже используете эту ячейку!Попробуйте выбрать другую.");
                }
            }
        }while (!isOutOfIndex(x, y) || !isEmpty(x, y));
        field[x][y] = HUMAN_DOT;
        aiX = x;
        aiY = y;
    }

    /**
     * Метод выбора компьютера
     */
    private static void aiTurn(){
        int x, y;
        if (nextCell(aiX, aiY) && fieldSizeX > 3){
            x = aiX;
            y = aiY;
        }else {
            do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
            } while (!isEmpty(x, y));
        }
        field[x][y] = AI_DOT;
    }

    /**
     * Метод проверяет что выбранная ячейка лежит в диапазоне игрового поля.
     * @param x номер строки
     * @param y номер столбца
     * @return возвращает true в случае если X и Y лежат в диапазоне игрового поля.
     */
    private static boolean isOutOfIndex(int x, int y){
        return x >=0 && x < fieldSizeX && y >=0 && y <fieldSizeY;
    }

    /**
     * Метод проверяет что выбранная ячейка свободная.
     * @param x номер строки
     * @param y номер столбца
     * @return возвращает true в случае если X и Y равны EMPTY_DOT.
     */
    private static boolean isEmpty(int x, int y){
        return field[x][y] == EMPTY_DOT;
    }

    /**
     * Проверка игрового поля
     * @param dot Игровая фишка(крестик или ноль)
     * @return возвращает true в случае если одинаковые фишки в количестве WIN_COUNT идут подряд
     */
    private static boolean isWin(char dot){
        if (checkHorizontal(dot)){
            System.out.println("Horizan");
            return true;
        }if (checkVertical(dot)){
            System.out.println("Vertical");
            return true;
        }if (checkDiagonal(dot)){
            System.out.println("Diag");
            return true;
        }
        return false;
    }
    private static boolean checkHorizontal(char dot){
        int winCount = 0;
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (dot == field[x][y]){
                    winCount++;
                    if (winCount == WIN_COUNT){
                        return true;
                    }
                } else winCount = 0;
            }
            winCount = 0;
        }
        return false;
    }
    private static boolean checkVertical(char dot){
        int winCount = 0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (dot == field[x][y]) {
                    winCount++;
                    if (winCount == WIN_COUNT) {
                        return true;
                    }
                } else winCount = 0;
            }
            winCount = 0;
        }
            return false;
    }
    private static boolean checkDiagonal(char dot){
        int winCount = 0;
        int col = fieldSizeY - 1;
        for (int x = 0; x < fieldSizeX; x++) {
                if (dot == field[x][x]){
                    winCount++;
                    if (winCount == WIN_COUNT){
                        return true;
                    }
                }else winCount = 0;
            }
        winCount = 0;
        for (int x = 0; x < fieldSizeX; x++) {
            if (dot == field[x][col]){
                winCount++;
                if (winCount == WIN_COUNT){
                    return true;
                }
            }else winCount = 0;
            col--;
        }
        return false;
    }
    private static boolean isDrawnGame(){
        for (int x = 0; x < fieldSizeY; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if(isEmpty(x, y)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean nextCell(int x, int y){
        if (checkHorizontal(x, y)) {
            return true;
        }
        if (checkVertical(x, y)){
            return true;
        }

        return false;
    }
    private static boolean checkHorizontal(int x, int y){
        int rightCount = 0;
        int leftCount = 0;
        int rightDiffer = 0;
        int leftDiffer = 0;
        int rightLimit = fieldSizeY - 1;
        int leftLimit = 0;
        int leftEmpty = 0;
        int rightEmpty = 0;
        if (y <= rightLimit - (WIN_COUNT - 2)){
            rightLimit = y + (WIN_COUNT - 2);
        }
        if (y >= WIN_COUNT - 2){
            leftLimit = y - (WIN_COUNT - 2);
        }

        for (int col = rightLimit; col >= y; col--) {
            if (field[x][col] == HUMAN_DOT){
                rightCount++;
            }
            if (isEmpty(x, col)){
                rightEmpty++;
                rightDiffer = col;
            }if (field[x][col] == AI_DOT){
                rightCount--;
            }
        }

        for (int col = leftLimit; col <= y ; col++) {
            if (field[x][col] == HUMAN_DOT){
                leftCount++;
            }
            if (isEmpty(x, col)){
                leftDiffer = col;
                leftEmpty++;
            } if (field[x][col] == AI_DOT){
                leftCount--;
            }

        }
        if (leftCount >= WIN_COUNT - 2 || rightCount >= WIN_COUNT - 2) {
/**
 * Сложное условие из нескольких комбинация так как игровое поле может быть большим то необходимо смотреть на два шага
 * вперед. Условие проверяет в какую сторону идти влево или вправо. Сначала проверяем что разница до пустого поля одна
 * единица и что есть два или менее пустых поля, далее проверяется условие количество пустых полей с одной стороны и
 * с другой и потом еще раз проверяем разницу пустого поля от поля куда только что поставили фишку. Данные условия
 * выбирают необходимое на правление для выбора компьютером фишки по горизонтали
 */
            if (rightDiffer - y == 1  && rightEmpty <= 2 || rightEmpty > leftEmpty || rightDiffer - y == 1) {
                for (int column = y; column < fieldSizeY; column++) {
                    if (isEmpty(x, column) ) {
                        aiX = x;
                        aiY = column;
                        return true;
                    }
                }
            } else if (y - leftDiffer == 1 && leftEmpty <= 2 || leftEmpty > rightEmpty || y - leftDiffer == 1) {
                for (int column = y; column >= leftLimit; column--) {
                    if (isEmpty(x, column) ) {
                        aiX = x;
                        aiY = column;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean checkVertical(int x, int y){
        int upCount = 0;
        int downCount = 0;
        int upDiffer = 0;
        int downDiffer = 0;
        int upLimit = 0;
        int downLimit = fieldSizeX - 1;
        int upEmpty = 0;
        int downEmpty = 0;
        if (x <= downLimit - (WIN_COUNT - 2)) {
            downLimit = x + (WIN_COUNT - 2);
        }
        if ( x >= WIN_COUNT - 2) {
            upLimit = x - (WIN_COUNT - 2);
        }
        for (int row = downLimit; row >= x; row--) {
            if (field[row][y] == HUMAN_DOT){downCount++;}
            if (isEmpty(row, y)){
                downEmpty++;
                downDiffer = row;
            }
            if (field[row][y] == AI_DOT){downCount--;}
        }
        for (int row = upLimit; row <= x ; row++) {
            if(field[row][y] == HUMAN_DOT ){upCount++;}
            if (field[row][y] == AI_DOT){upCount--;}
            if (isEmpty(row, y)){
                upEmpty++;
                upDiffer = row;
            }
        }
        if (downCount >= WIN_COUNT - 2 || upCount >= WIN_COUNT - 2){
            if (downDiffer - x == 1 && downEmpty <= 2 || downEmpty > upEmpty || downDiffer - 1 == 1){
                for (int row = x; row < downLimit ; row++) {
                    if (isEmpty(row, y)){
                        aiX = row;
                        aiY = y;
                        return true;
                    }
                }
            }else if (upDiffer - 1 == 1 && upEmpty <= 2 || upEmpty > downEmpty || upDiffer - 1 == 1){
                for (int row = x; row >= upLimit; row--) {
                    if (isEmpty(row, y)){
                        aiX = row;
                        aiY = y;
                        return true;
                    }

                }
            }
        }
        return false;
    }



}//final line

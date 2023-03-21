// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000

package seminar5_Homework;

import java.util.ArrayDeque;

public class task3 {
    public static void main(String[] args) {
        int[][] desk = new int[8][8]; // Доска
        ArrayDeque<Integer[]> resultQueen = new ArrayDeque<>(); // Стек для координат ферзей
        int queen = 1;
        Integer[] initCoords = new Integer[2]; // Начальные координаты проверки
        initCoords[1] = initCoords[0] = 0;
        while (queen <= 8) {
            boolean isSet = false;
            for (int i = initCoords[0]; i < 8; i++) {
                for (int j = initCoords[1]; j < 8; j++) {
                    if (desk[i][j] == 0) { // Проверка возможности поставить фигуру
                        boolean isFree = true;
                        for (int k = 0; k < 8; k++) {
                            if (desk[i][k] == 1 || desk[k][j] == 1)
                                isFree = false;
                            if (i + k < 8 && j + k < 8)
                                if (desk[i + k][j + k] == 1)
                                    isFree = false;
                            if (i + k < 8 && j - k >= 0)
                                if (desk[i + k][j - k] == 1)
                                    isFree = false;
                            if (i - k >= 0 && j + k < 8)
                                if (desk[i - k][j + k] == 1)
                                    isFree = false;
                            if (i - k >= 0 && j - k >= 0)
                                if (desk[i - k][j - k] == 1)
                                    isFree = false;
                        }
                        if (isFree) { // установка фигуры
                            Integer[] coords = new Integer[] { i, j };
                            resultQueen.addLast(coords);
                            desk[i][j] = 1;
                            i = j = 8;
                            queen++;
                            isSet = true;
                            initCoords[1] = initCoords[0] = 0;
                        }

                    }
                }
            }
            if (isSet == false) { // Если не получилось
                queen--; // убираем фигуры
                if (resultQueen.isEmpty()) {
                    initCoords[1] = initCoords[0] = 0;
                } else {
                    initCoords = resultQueen.getLast();
                    resultQueen.removeLast(); // удаляем ее координаты
                    desk[initCoords[0]][initCoords[1]] = 0; // убираем с доски
                    if (initCoords[1] == 7) { // Выставляем координаты для продолжения поиска положения убранной фигуры
                        initCoords[0] = initCoords[0] + 1;
                        initCoords[1] = 0;
                    } else
                        initCoords[1]++;
                }
            }

        }
        for (int i = 0; i < 8; i++) { // Печатаем доску
            for (int j = 0; j < 8; j++) {
                System.out.print(desk[i][j] + " ");
            }
            System.out.println();

        }
    }
}

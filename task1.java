// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я: 2
// Иванов: 1242353, 547568

package seminar5_Homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phones = new HashMap<>();
        Scanner myScanner = new Scanner(System.in, "Cp866");
        try {
            while (true) {
                ArrayList<String> personPhones = new ArrayList<>();
                System.out.println("Выберите требуемое действие: \n1 - Добавление номера \n2 - Вывод всего");
                int action = myScanner.nextInt();
                myScanner.nextLine();
                if (action == 1) {
                    System.out.print("Введите фамилию: ");
                    String name = myScanner.nextLine();
                    System.out.print("Введите номер: ");
                    String phone = myScanner.nextLine();
                    if (phones.containsKey(name)) {
                        personPhones = phones.get(name);
                    }
                    personPhones.add(phone);
                    phones.put(name, personPhones);
                } else if (action == 2) {
                    for (Map.Entry<String, ArrayList<String>> item : phones.entrySet()) {
                        System.out.print(item.getKey() + ": ");
                        item.getValue().forEach(s -> System.out.print(s + ", "));
                        System.out.println();

                    }
                } else
                    System.out.println("Некорректное действие");
            }
        } catch (Exception e) {
            System.out.println("Введено некорректное значение");
            myScanner.close();
        }
    }
}


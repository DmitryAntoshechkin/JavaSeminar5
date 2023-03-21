// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.


package seminar5_Homework;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class task2 {
    public static void main(String[] args) {
        HashMap<String, String> people = GetEmployee();
        // ArrayList<String> names = ArrayList<String>(people.values());
        ArrayList<String> names = new ArrayList<>(people.values());
        System.out.println(names);
        names.sort(Comparator.naturalOrder());
        System.out.println(names);
        HashMap <String, Integer> sortedNames  = new HashMap<>();
        int count = 1;
        for (int i = 0; i <names.size()-1; i++) {
            if (names.get(i) == names.get(i+1)){
                count ++;                
            }else{
                if (count != 1){
                    sortedNames.put(names.get(i), count);
                }
                count = 1;
            }            
        }
        if (count != 1) sortedNames.put(names.get(names.size()), count);
        sortedNames.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
        .forEach(System.out::println);

    }

public static HashMap<String, String> GetEmployee() {
    HashMap<String, String> employee = new HashMap<>();
    employee.put("Иванов", "Иван");
    employee.put("Петрова", "Светлана");
    employee.put("Белова", "Кристина");
    employee.put("Мусина", "Анна");
    employee.put("Крутова", "Анна");
    employee.put("Юрин", "Иван");
    employee.put("Лыков", "Петр");
    employee.put("Чернов", "Павел");
    employee.put("Чернышов", "Петр");
    employee.put("Федорова", "Мария");
    employee.put("Светлова", "Марина");
    employee.put("Савина", "Мария");
    employee.put("Рыкова", "Мария");
    employee.put("Лугова", "Марина");
    employee.put("Владимирова", "Анна");
    employee.put("Мечников", "Иван");
    employee.put("Петин", "Петр");
    employee.put("Ежов", "Иван");
    return employee;    
}    
}




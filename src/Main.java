import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Борис", "Сидоров", 14,"Россия"));
        users.add(new User(2, "Максим", "Воронин", 6,"Беларусь"));
        users.add(new User(3, "Сергей", "Котов", 26,"Россия"));
        users.add(new User(4, "Анна", "Белова", 22,"Беларусь"));
        users.add(new User(5, "Варвара", "Кривенко", 31,"Украина"));
        System.out.println("1)     вывести всех пользователей, отсортированных по lastName;");
        printUsersSortedByLastName(users);
        System.out.println("2)     вывести всех пользователей, отсортированных по age;");
        printUsersSortedByAge(users);
        System.out.println("3)     проверить, что для всех пользователей age > 7;");
        printCheckResultIfEveryUserOlderThanSeven(users);
        System.out.println("4)     вычислить средний возраст всех пользователей;");
        printAverageUserAge(users);
        System.out.println("5)    вывести количество разных стран проживания (country) среди заданных пользователей");
        printCountryAmount(users);
    }

    public static void printUsersSortedByLastName(List<User> users) {
        Comparator<User> comparator = Comparator.comparing(User::getLastName);
        users.stream().sorted(comparator).forEach(System.out::println);
    }

    public static void printUsersSortedByAge(List<User> users) {
        Comparator<User> comparator = Comparator.comparing(User::getAge);
        users.stream().sorted(comparator).forEach(System.out::println);
    }

    public static void printCheckResultIfEveryUserOlderThanSeven(List<User> users) {
        System.out.println(users.stream().allMatch(u -> u.getAge() > 7));
    }

    public static void printAverageUserAge(List<User> users) {
        var average = users.stream()
                .map(u -> u.getAge())
                .mapToInt(a -> a)
                .average()
                .orElseThrow();
        System.out.println(average);
    }

    public static void printCountryAmount(List<User> users) {
        var count = users.stream()
                .map(u -> u.getCountry())
                .distinct()
                .count();
        System.out.println(count);
    }
}
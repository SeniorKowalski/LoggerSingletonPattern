import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>();
        int size;
        int upperValue;
        int filterNum;
        Random random = new Random();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка:");
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
            logger.log("Размер списка: " + size);
        } else {
            logger.log("Введено некорректное число");
            logger.log("Программа завершена");
            throw new NumberFormatException();
        }
        System.out.println("Введите верхнюю границу для значений:");

        if (scanner.hasNextInt()) {
            upperValue = scanner.nextInt();
            logger.log("Верхняя граница значений: " + upperValue);
        } else {
            logger.log("Введено некорректное число");
            logger.log("Программа завершена");
            throw new NumberFormatException();
        }
        logger.log("Создаём и наполняем список");
        for (int i = 0; i < size; i++) {
            integers.add(i, random.nextInt(upperValue) + 1);
        }
        System.out.println("Вот случайный список " + integers.toString());
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра:");
        if (scanner.hasNextInt()) {
            filterNum = scanner.nextInt();
            Filter filter = new Filter(filterNum);
            logger.log("Порог для фильтра: " + filterNum);
            filter.filterOut(integers);
        } else {
            logger.log("Введено некорректное число");
            logger.log("Программа завершена");
            throw new NumberFormatException();
        }
    }
}

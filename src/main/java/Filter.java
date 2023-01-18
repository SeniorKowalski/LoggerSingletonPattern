import java.util.List;

public class Filter {

    private int f;

    public Filter(int f) {
        this.f = f;
    }

    void filterOut(List<Integer> list) {
        Logger logger = Logger.getInstance();

        logger.log("Запускаем фильтрацию");
        list.forEach(integer -> logger.log("Элемент " + integer + ((integer > f) ? " проходит" : " не проходит")));
        List<Integer> resList = list.stream().parallel().filter(integer -> integer > f).toList();
        logger.log("Прошло фильтр " + resList.size() + " элемент(ов) из " + list.size());
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + resList);
        System.out.println("Завершаем программу.");
    }
}
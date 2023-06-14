package main.java;

import main.java.entity.Product;
import main.java.storages.ProductsImpl;

/**
 * Класс тестов разработанных классов.
 *
 * @version 1.0
 * @autor Кирилл Воробьев
 */
public class Test {

    /**
     * Функция, выводящая в консоль линию (для визуального отделения действий)
     */
    private static void printLine() {
        System.out.println("-------------------------------------------------------------------");
    }

    /**
     * Функция, тестирующая добавление элементов в коллекцию
     *
     * @param productsImpl - класс интерфейса коллекции
     */
    private static void additionTest(ProductsImpl productsImpl) {
        System.out.println("\nТест на добавление элементов:");
        printLine();
        System.out.println("Начальное состояние коллекции: " + productsImpl.getProducts()); // пустая коллекция
        System.out.println("Результат добавления несуществующего элемента: " + productsImpl.addProduct(new Product("1", "Mouse"))); // true
        System.out.println("Результат дублирующего добавления: " + productsImpl.addProduct(new Product("1", "Keyboard"))); // false
        System.out.println("Результат добавления несуществующего элемента: " + productsImpl.addProduct(new Product("2", "Keyboard"))); // true
        System.out.println("Результат добавления несуществующего элемента: " + productsImpl.addProduct(new Product("3", "Keyboard"))); // true
        System.out.println("Конечное состояние коллекции: " + productsImpl.getProducts()); // 3 элемента
        printLine();
    }

    /**
     * Функция, тестирующая поиск имени элемента коллекции по его идентификатору
     *
     * @param productsImpl - класс интерфейса коллекции
     */
    private static void getNameTest(ProductsImpl productsImpl) {
        System.out.println("\nТест на получение имени продукта по его идентификатору:");
        printLine();
        System.out.println("Состояние коллекции: " + productsImpl.getProducts());
        System.out.println("Результат получения существующего элемента: " + productsImpl.getName("1")); // "Mouse"
        System.out.println("Результат получения несуществующего элемента: " + productsImpl.getName("0")); // пустая строка
        printLine();
    }

    /**
     * Функция, тестирующая поиск элементов коллекции по их имени
     *
     * @param productsImpl - класс интерфейса коллекции
     */
    private static void findByNameTest(ProductsImpl productsImpl) {
        System.out.println("\nТест на получение списка идентификаторов элементов с заданным именем:");
        printLine();
        System.out.println("Состояние коллекции: " + productsImpl.getProducts());
        System.out.println("Результат получения идентификаторов элементов с существующим именем: " + productsImpl.findByName("Keyboard")); // 2 элемента
        System.out.println("Результат получения идентификаторов элементов с несуществующим именем: " + productsImpl.findByName("Computer")); // пустое множество
        printLine();
    }

    /**
     * Функция, тестирующая удаление элементов коллекции
     *
     * @param productsImpl - класс интерфейса коллекции
     */
    private static void deletionTest(ProductsImpl productsImpl) {
        System.out.println("\nТест на удаление элементов:");
        printLine();
        System.out.println("Начальное состояние коллекции: " + productsImpl.getProducts()); // 3 элемента
        System.out.println("Результат удаления существующего элемента: " + productsImpl.deleteProduct(new Product("1", "Mouse"))); // true
        System.out.println("Результат удаления несуществующего элемента: " + productsImpl.deleteProduct(new Product("1", "Mouse"))); // false
        System.out.println("Результат удаления существующего элемента: " + productsImpl.deleteProduct(new Product("2", "Keyboard"))); // true
        System.out.println("Результат удаления существующего элемента: " + productsImpl.deleteProduct(new Product("3", "Keyboard"))); // true
        System.out.println("Конечное состояние коллекции: " + productsImpl.getProducts()); // пустая коллекция
        printLine();
    }

    public static void main(String[] args) {
        System.out.println("\nЗапуск тестов...\n");
        ProductsImpl productsImpl = new ProductsImpl();
        additionTest(productsImpl);
        getNameTest(productsImpl);
        findByNameTest(productsImpl);
        deletionTest(productsImpl);
        System.out.println("\nВсе тесты выполнены.\n");
    }
}

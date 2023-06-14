package main.java.storages;

import main.java.entity.Product;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Класс, хранящий коллекцию и содержащий методы для работы с ней.
 *
 * @version 1.0
 * @autor Кирилл Воробьев
 */
public class ProductsImpl {

    /**
     * Коллекция, хранящая элементы класса Product {@link Product}
     */
    private HashSet<Product> products;

    /**
     * Конструктор - создание нового объекта
     */
    public ProductsImpl() {
        this.products = new HashSet<>();
    }

    /**
     * Функция получения элементов коллекции {@link ProductsImpl#products}
     *
     * @return возвращает коллекцию элементов класса Product
     */
    public HashSet<Product> getProducts() {
        return products;
    }

    /**
     * Функция добавления нового продукта
     *
     * @param product - заданный для добавления продукт
     * @return true - если продукта с таким id еще не было
     * false - если был такой id, вставка отменяется
     */
    public boolean addProduct(Product product) {
        String addedId = product.getId();
        Optional<Product> desiredProduct = products.stream().filter(p -> p.getId().equals(addedId)).findFirst();
        if (desiredProduct.isEmpty()) {
            products.add(product);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Функция удаления продукта
     *
     * @param product - заданный для удаления продукт
     * @return true - если продукт с таким id был
     * false - если id не было, (удаления не происходит)
     */
    public boolean deleteProduct(Product product) {
        String addedId = product.getId();
        Optional<Product> desiredProduct = products.stream().filter(p -> p.getId().equals(addedId)).findFirst();
        if (desiredProduct.isEmpty()) {
            return false;
        } else {
            products.remove(desiredProduct.get());
            return true;
        }
    }


    /**
     * Функция получения имени (name) продукта
     *
     * @param id - заданный id
     * @return name продукта у которого идентификатор равен (=) id
     * если продукта нет, вернуть пустую строку ""
     */
    public String getName(String id) {
        Optional<Product> desiredProduct = products.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (desiredProduct.isEmpty()) return "";
        else return desiredProduct.get().getName();
    }

    /**
     * Функция получения массива (списка) идентификаторов (id)
     * У которых наименование равно (=) name
     *
     * @param name - заданное имя
     * @return массив идентификаторов (id) у которых наименование равно (=) name
     * если таких нет, возвращается пустой массив (список)
     */
    public List<String> findByName(String name) {
        List<String> resIdList = new LinkedList<>();
        products.stream().filter(p -> p.getName().equals(name)).forEach(p -> resIdList.add(p.getId()));
        return resIdList;
    }
}

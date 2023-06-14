package main.java.entity;

/**
 * Класс продукции со свойствами <b>id</b> и <b>name</b>.
 *
 * @version 1.0
 * @autor Кирилл Воробьев
 */
public class Product {

    /**
     * Поле идентификатор
     */
    private String id;

    /**
     * Поле имя
     */
    private String name;

    /**
     * Конструктор - создание нового объекта
     */
    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Функция получения значения поля {@link Product#id}
     *
     * @return возвращает идентификатор продукта
     */
    public String getId() {
        return id;
    }

    /**
     * Функция установления идентификатора продукту {@link Product#id}
     *
     * @param id - идентификатор
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Функция получения значения поля {@link Product#name}
     *
     * @return возвращает имя продукта
     */
    public String getName() {
        return name;
    }

    /**
     * Функция установления имени продукту {@link Product#name}
     *
     * @param name - имя
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

package ru.nomad.lesson3;

    // Это Presenter, делаем его на основе паттерна «одиночка».
    // Этот паттерн обладает свойством хранить один экземпляр объекта на все приложение.
    // Для реализации паттерна «одиночка» надо добавить статическое приватное поле (instance),
    // сделать конструктор приватным,
    // добавить статический метод, который проверяет, существует ли этот
    // объект в нашем поле, если нет, то создает его и возвращает это поле в качестве
    // результата.
    // Таким образом, в приложении всегда существует только один объект.
    // Класс, реализующий паттерн «одиночка» нельзя наследовать.
public final class LifeCyclePresenter {

    // Внутреннее поле, будет хранить единственный экземпляр
    private static LifeCyclePresenter instance = null;

    private int increment;

    // Конструктор. Вызввать извне его нельзя, поэтому он приватный
    private LifeCyclePresenter() {
        increment = 0;
    }

    public void doIncrement() {
        increment++;
    }

    public int getIncrement() {
        return increment;
    }

    // Метод, который возвращает экземпляр объекта.
    // Если объекта нет, то создаем его.
    public static LifeCyclePresenter getInstance() {
        // Здесь реализована «ленивая» инициализация объекта,
        // то есть, пока объект не нужен, не создаем его.
        if (instance == null) {
            instance = new LifeCyclePresenter();
        }
        return instance;
    }
}

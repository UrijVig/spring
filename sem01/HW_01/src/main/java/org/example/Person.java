package org.example;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Класс, представляющий человека с именем, фамилией и возрастом
 */
public class Person {
    private String firstName;
    private String lastName;
    public static final Gson gson = new Gson(); // Объект Gson для сериализации и десериализации
    private int age;

    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Геттер для имени
     *
     * @return имя
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Сеттер для имени
     *
     * @param firstName новое имя
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Геттер для фамилии
     *
     * @return фамилия
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Сеттер для фамилии
     *
     * @param lastName новая фамилия
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Геттер для возраста
     *
     * @return возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * Сеттер для возраста
     *
      * @param age новый возраст
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Метод для сериализации объекта в JSON
     *
     * @return строка в формате JSON
     */
    public String serialization(){
        return gson.toJson(this);
    }

    /**
     * Статический метод для десериализации JSON строки в объект Person
     *
     * @param json строка в формате JSON
     * @return объект класса Person
     */
    static public Person deserialization(String json){
        return gson.fromJson(json, Person.class);
    }

    /**
     * Переопределение метода equals для сравнения объектов на равенство
     *
     * @param o объект для сравнения
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return new EqualsBuilder().append(firstName, person.firstName)
                .append(lastName, person.lastName)
                .append(age, person.age)
                .isEquals();
    }

    /**
     * Переопределение метода hashCode для генерации хэш-кода объекта
     *
     * @return переопределённый хэш-код объекта
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(firstName)
                .append(lastName)
                .append(age)
                .toHashCode();
    }

    /**
     * Переопределение метода toString для возврата строкового представления объекта
     *
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("name", firstName)
                .append("lastName", lastName)
                .append("age", age)
                .toString();
    }
}

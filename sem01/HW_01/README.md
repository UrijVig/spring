## Урок 1. Системы сборки Maven и Gradle для разработки Java приложений

1. Создайте новый [Maven](https://github.com/UrijVig/spring/blob/master/sem01/HW_01/pom.xml) или Gradle проект, через Intellj IDEA.
2. Добавьте зависимости org.apache.commons:commons-lang3:3.14.0
~~~xml
    <!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>3.14.0</version>
    </dependency>
~~~
и com.google.code.gson:gson:2.10.1.
~~~xml
    <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
~~~
3. Создайте класс 
[Person](https://github.com/UrijVig/spring/blob/master/sem01/HW_01/src/main/java/org/example/Person.java)
с полями firstName, lastName и age.
4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
    ~~~java
    import org.apache.commons.lang3.builder.EqualsBuilder;
    import org.apache.commons.lang3.builder.HashCodeBuilder;
    import org.apache.commons.lang3.builder.ToStringBuilder;
    import org.apache.commons.lang3.builder.ToStringStyle;
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
    
        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                    .append(firstName)
                    .append(lastName)
                    .append(age)
                    .toHashCode();
        }    
    
        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("name", firstName)
                    .append("lastName", lastName)
                    .append("age", age)
                    .toString();
        }
    ~~~
5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
    ~~~java
    import com.google.gson.Gson;

        //Сериализация
        public String serialization(){
            return gson.toJson(this);
        }
        //Десериализация
        static public Person deserialization(String json){
            return gson.fromJson(json, Person.class);
        }
    ~~~
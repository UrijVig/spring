## Урок 4. Spring MVC. Использование шаблонизатора Thymeleaf

1. Создание базового веб-приложения Spring MVC
Начните с создания простого веб-приложения с использованием Spring MVC. Это может быть простой сайт, который выводит "Привет, мир!" на главной странице. Используйте аннотацию @Controller и @RequestMapping для маршрутизации запросов на эту страницу.
    > Результат выполнения можно увидеть в классе [HelloController](https://github.com/UrijVig/spring/blob/master/sem04/HW_04/HomeWork04/src/main/java/com/example/HomeWork04/controller/HelloController.java)

2. Добавление Thymeleaf в проект
Добавьте Thymeleaf в свое веб-приложение Spring MVC. Создайте простую страницу с некоторыми переменными, которые заполняются с помощью модели Spring MVC и отображаются на странице с использованием Thymeleaf.
    > Результат выполнения можно увидеть в классе [RandomController](https://github.com/UrijVig/spring/blob/master/sem04/HW_04/HomeWork04/src/main/java/com/example/HomeWork04/controller/RandomController.java)

3. Создание формы ввода и обработка данных формы
Создайте страницу с формой ввода, используя Thymeleaf для рендеринга формы. Затем создайте контроллер Spring MVC, который обрабатывает отправку формы и выводит полученные данные. Это может быть форма для регистрации или любая другая форма, которая собирает информацию от пользователя.
    > Результат выполнения можно увидеть в классе [StudentController](https://github.com/UrijVig/spring/blob/master/sem04/HW_04/HomeWork04/src/main/java/com/example/HomeWork04/controller/StudentController.java)

    > Шаблон для заполнения формы: [student-form.html](https://github.com/UrijVig/spring/blob/master/sem04/HW_04/HomeWork04/src/main/resources/templates/student-form.html)

    > Файл для отображения стилей [style.css](https://github.com/UrijVig/spring/blob/master/sem04/HW_04/HomeWork04/src/main/resources/static/style.css)

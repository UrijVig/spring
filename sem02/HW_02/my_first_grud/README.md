## Урок 2. Основы Spring. Spring Boot

Добавить в простое CRUD веб-приложение, которое было разработано на семинаре функцию удаления данных о пользователе:

1) В класс UserRepository добавить метод **public void deleteById(int id)** - удаления записи пользователя из БД по ID.

    ~~~java
        public void deleteById(int id) {
            String sql = "DELETE FROM userTable WHERE id=?";
            jdbc.update(sql, id);
        }
    ~~~

2) В класс UserService добавить метод **public void deleteById(int id)** - удаление пользователя через репозиторий.

    ~~~java
        public void deleteById(int id) {
            repository.deleteById(id);
        }
    ~~~


3) В класс UserController добавить метод **public String deleteUser(@PathVariable("id") int id)**(с аннотацией: @GetMapping("user-delete/{id}")) - перехват команды на удаление студента от браузера.

    ~~~java
        @GetMapping("user-delete/{id}")
        public String deleteUserById(@PathVariable int id) {
            service.deleteById(id);
            return "redirect:/users";
        }
    ~~~


Классы 
[UserRepository](https://github.com/UrijVig/spring/blob/master/sem02/HW_02/my_first_grud/src/main/java/com/example/my_first_grud/repository/imp/UserRepository.java), 
[UserService](https://github.com/UrijVig/spring/blob/master/sem02/HW_02/my_first_grud/src/main/java/com/example/my_first_grud/service/imp/UserService.java) и 
[UserController](https://github.com/UrijVig/spring/blob/master/sem02/HW_02/my_first_grud/src/main/java/com/example/my_first_grud/controller/imp/UserController.java)
 имплементируют классы 
 [iRepository](https://github.com/UrijVig/spring/blob/master/sem02/HW_02/my_first_grud/src/main/java/com/example/my_first_grud/repository/iRepository.java), 
 [iService](https://github.com/UrijVig/spring/blob/master/sem02/HW_02/my_first_grud/src/main/java/com/example/my_first_grud/service/iService.java) и 
 [iController](https://github.com/UrijVig/spring/blob/master/sem02/HW_02/my_first_grud/src/main/java/com/example/my_first_grud/controller/iController.java) соответственно
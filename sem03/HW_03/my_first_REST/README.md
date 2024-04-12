## Урок 3. Использование Spring для разработки серверного приложения

    Задание: Используя Spring, создайте серверное REST приложение. Добавить функционал в приложение разработанное на семинаре:

### Базовое задание

1) В класс [RegistrationService](https://github.com/UrijVig/spring/blob/master/sem03/HW_03/my_first_REST/src/main/java/com/example/my_first_REST/service/RegistrationService.java) добавить поля UserService, NotificationService
    ~~~java
        @Autowired
        private UserService userService;
        @Autowired
        private NotificationService notificationService;
    ~~~

2) Разработать метод processRegistration в котором:
    - создается пользователь из параметров метода
    - созданный пользователь добавляется в репозиторий
    - через notificationService выводится сообщение в консоль

    ~~~java
        public void processRegistration(User user) {
            dataProcessingService.addUser(user);
            userService.createUser(user);
            notificationService.sendNotification("Пользователь успешьно зарегистрирован!");
        }
    ~~~

3) В [TaskController](https://github.com/UrijVig/spring/blob/master/sem03/HW_03/my_first_REST/src/main/java/com/example/my_first_REST/controller/TaskController.java) добавить обработчики  
    * filterUsersByAge()
    ~~~java
        @GetMapping("/filter/{age}")
        public List<User> filterUsersByAge(@PathVariable int age)
        {
            return service.filterUsersByAge(age);
        }
    ~~~
    * calculateAverageAge 
    ~~~java
        @GetMapping("/calc")
        public double calculateAverageAge()
        {
            return service.calculateAverageAge();
        }
    ~~~
4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable

### Задание со звездочкой

1) В классе [UserController](https://github.com/UrijVig/spring/blob/master/sem03/HW_03/my_first_REST/src/main/java/com/example/my_first_REST/controller/UserController.java) добавить обработчик userAddFromParam извлекающий данные для создания пользователя из параметров HTTP запроса
    ~~~java
        @PostMapping("/{name}/{age}/{email}")
        public String userAddFromBody(@PathVariable("name") String name,@PathVariable("age") int age,@PathVariable("email") String email )
        {
            service.processRegistration(new User(name, age, email));
            return "User added from body!";
        }
    ~~~
2) Перенести репозиторий проекта с List<User> на базу данных H2.

    > Данное задание выполнено путём создание интерфейса [iRepository](https://github.com/UrijVig/spring/blob/master/sem03/HW_03/my_first_REST/src/main/java/com/example/my_first_REST/repository/iRepository.java) В которой описаны все необходимые методы. 
    * Обработка информации в List<User> описано в классе [MemoryRepository](https://github.com/UrijVig/spring/blob/master/sem03/HW_03/my_first_REST/src/main/java/com/example/my_first_REST/repository/imp/MemoryRepository.java)  
    * Обработка информации в базе данных H2, описано в классе [H2Repository](https://github.com/UrijVig/spring/blob/master/sem03/HW_03/my_first_REST/src/main/java/com/example/my_first_REST/repository/imp/H2Repository.java)  

    > Переключение между этими репозиториями осуществляется путём переключения профиля в Spring через аннотацию **@Profile** и её значение ***"task1"*** или ***"task2"*** в фалу конфигурации [application.yaml](https://github.com/UrijVig/spring/blob/master/sem03/HW_03/my_first_REST/src/main/resources/application.yaml)
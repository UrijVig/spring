## Урок 8. Spring AOP, управление транзакциями.

Вам необходимо разработать механизм регистрации действий пользователя в вашем Spring Boot приложении. Используйте Spring AOP
для создания журнала действий, в котором будет сохраняться информация о том, какие методы сервиса вызывались, кем и с какими параметрами.

1. Создайте аннотацию 
[@TrackUserAction](https://github.com/UrijVig/spring/blob/master/sem02/HW_02/my_first_grud/src/main/java/com/example/my_first_grud/aspect/TrackUserAction.java).
2. Реализуйте aspect, который будет регистрировать действия пользователя, когда вызывается метод, отмеченный этой аннотацией.
~~~java
    @Aspect
    public class TrackUserActionAspect {
        /**
         * Данный метод реализует аспект отслеживания действий пользователя на странице и вывода данных в консоль
         * @param joinPoint - использованный метод
         * @param returnedValue - возвращённое значение
         */
        @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
        public void trackActionLog(JoinPoint joinPoint, Object returnedValue){
            String methodName = joinPoint.getSignature().getName();
            String methodArgs = joinPoint.getArgs()[0].toString();
            System.out.printf("""
                    Был вызван метод %s\s
                    с переданными в него параметрами:\s
                    %s%n""", methodName, methodArgs);
        }
    }

    @Configuration
    @ComponentScan(basePackages = "com.example.my_first_grud")
    @EnableAspectJAutoProxy
    public class ProjectConfiguration {
        @Bean
        public TrackUserActionAspect trackUserActionAspect(){
            return new TrackUserActionAspect();
        }
    }
~~~
3. Примените аннотацию @TrackUserAction к нескольким методам в слое [сервиса](https://github.com/UrijVig/spring/blob/master/sem02/HW_02/my_first_grud/src/main/java/com/example/my_first_grud/service/imp/UserService.java).
4. Результаты регистрации в консоль
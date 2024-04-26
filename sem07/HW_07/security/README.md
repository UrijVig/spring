## Урок 7. Spring Security. Работа с JWT. Защита от основных видов атак.

Вам необходимо создать Spring Boot приложение, которое управляет доступом к ресурсам в зависимости от роли пользователя. У вас должно быть два типа пользователей: USER и ADMIN.

1. Создайте ресурс /private, доступный только для аутентифицированных пользователей с ролью ADMIN
    ~~~java
        @GetMapping("/api/private")
        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
        public String getPrivateData() {
            return "private";
        }
    ~~~
2. Создайте ресурс /public, доступный для всех аутентифицированных пользователей независимо от их роли
    ~~~java
    @GetMapping("/api/public")
    public String getPublicData() {
        return "public";
    }
    ~~~
3. Реализуйте форму входа для аутентификации пользователей с использованием стандартных средств Spring Security
    ~~~java
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    ~~~
4. Если неаутентифицированный пользователь пытается получить доступ к /private, он должен быть перенаправлен на форму входа
    ~~~java
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll() //общий доступ для аутентификации
                        .requestMatchers("api/**").authenticated()) // ограничение доступа к ресурсам
                .formLogin(login -> login.loginPage("/login") //замена дефолтной страницы аутентификации
                        .defaultSuccessUrl("/api") //перенаправление пользователя после успешной аутентификации
                        .permitAll()) // свободный доступ
                .build();
    }
    ~~~


Создание юзеров было осуществлено с помощью следующего метода:
~~~java
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User.builder().username("admin").password(encoder.encode("admin")).roles("ADMIN").build();
        UserDetails user = User.builder().username("user").password(encoder.encode("user")).roles("USER").build();

        return new InMemoryUserDetailsManager(admin, user);
    }
~~~

Подробнее с кодом вы можете ознакомится в классе [контроллере](https://github.com/UrijVig/spring/blob/master/sem07/HW_07/security/src/main/java/com/example/security/controller/WebController.java) и в классе [конфигурации](https://github.com/UrijVig/spring/blob/master/sem07/HW_07/security/src/main/java/com/example/security/config/SecurityConfig.java) 
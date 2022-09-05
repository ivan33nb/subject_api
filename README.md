#Subject API

###Task:
надо сделать приложение на java (имеет смысл использовать spring boot для запуска приложения) с двума фреймворками - vaadin и jooq
vaadin - web фреймворк, ссылка на сайт https://vaadin.com/
jooq - аналог jpa, но сильно упрощенный , для работы с базой данных . (для разработки можете подключить любую, какая вам больше нравится). сайт https://www.jooq.org/

задача - сделать серверное приложение, которое будет слушать порт (например 8080) и показывать при обращении к нему страницу. на странице показывать таблицу. сверху таблицы кнопка создать запись, если на строчку в таблице кликнуть - открытьвать модалку редактирование записи.

структура таблицы -
название, коментарий, кол-во, дата создания, дата изменения

###Для запуска
IDEA -> File -> New -> project from version control -> `https://github.com/ivan33nb/subject_api.git`

Для запуска потребуется добавить переменные окружения
1) `DB_TEST_URL` - урл базы данных
2) `DB_TEST_USERNAME` - юзернэйм
3) `DB_TEST_PASSWORD` - пароль

**Перед запуском приложения, следует накатить скрипты liquibase. Для этого выполните** `mvn liquibase:update`.

**После того, как БД заполнится, можно будет начинать генерацию JOOQ сущностей ->** `mvn clean compile`


* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/#build-image)
* [Testcontainers MySQL Module Reference Guide](https://www.testcontainers.org/modules/databases/mysql/)
* [JOOQ Access Layer](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#data.sql.jooq)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#web)
* [Vaadin](https://vaadin.com/spring)
* [Testcontainers](https://www.testcontainers.org/)
* [Liquibase](https://www.liquibase.org/)
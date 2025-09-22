# LombardMS

## Описание

LombardMS — микросервисное приложение на Spring Boot для управления ломбардом. Система предназначена для автоматизации процессов учета залогов, клиентов и операций в ломбарде.

## Технологии

- **Backend**: Spring Boot
- **База данных**: PostgreSQL
- **Язык**: Java

## Структура проекта

- `src/main/java` — Основной код приложения (контроллеры, сервисы, репозитории).
- `src/main/resources` — Конфигурационные файлы, включая настройки базы данных.
- `pom.xml` — Файл сборки Maven.

## Установка и запуск

1. Клонируйте репозиторий:
   ```
   git clone https://github.com/AlexanderBultsev/LombardMS.git
   ```

2. Перейдите в директорию проекта:
   ```
   cd LombardMS
   ```

3. Соберите проект с помощью Maven:
   ```
   mvn clean install
   ```

4. Настройте подключение к PostgreSQL в файле `src/main/resources/application.properties`:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/lombarddb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

5. Запустите приложение:
   ```
   mvn spring-boot:run
   ```

Приложение будет доступно по адресу `http://localhost:8080`.

## Использование

- **API эндпоинты**: Документация Swagger будет добавлена в будущем.
- **Основные функции**:
  - Регистрация клиентов.
  - Учет залогов.
  - Управление операциями выдачи/возврата.

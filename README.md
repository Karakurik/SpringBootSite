# Блог API

## Функционал проекта

- Создание авторов
- Создание постов
- Комментирование
- Добавление в избранное

## Используемый стек технологий

- Java 1.8
- Spring Boot 2.6.5
- H2 Database

### Заметки про REST

* Способ описания API сервера, который представлен набором действий, осуществляемых с помощью HTTP-протокола.

- Ориентация на ресурсы

```
GET /users/76/friends

DELETE /users/76
```

- Использование HTTP-методов (GET, POST, PUT, DELETE)

- Использование JSON

- Отсутствие состояния (сессий)
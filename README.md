# EmployeeVacation

Реализация API для организации формирования заявлений на отпуск

## Обязательные требования
- Отпуск можно оформить не ранее 5 рабочих дней до начала отпуска (график работы считается стандартным 5/2)
- Возможность оформления оплачиваемого или неоплачиваемого отпуска
- Суммарно оплачиваемые отпуска могут быть оформлены не более, чем на 28 календарных дней в году; на неоплачиваемые отпуска ограничений нет


## Необязательные требования
- При попадании оплачиваемого отпуска на праздничный день, этот день не учитывается, окончание отпуска сдвигается (праздничные дни можно получить по производственному календарю на 2022г)
- Оповещение пользователя в telegram о создании/отмене заявления на отпуск

## Требования к API

### API для работы с сотрудниками

#### 1. GET getEmployees (/api/v0/employee/all)

##### Описание
Получение списка cотрудников

##### Структура ответа
```
{[
    "id": number,
    "name": string,
    "phone": string,
    "email": string,
    "telegramId": string
]}
```

#### 2. GET getEmployee (/api/v0/employee/{id})

##### Описание
Получение информации о сотруднике

##### Входные данные (path parameters)
- id: number - ID сотрудника

##### Структура ответа
```
{
    "id": number,
    "name": string,
    "phone": string,
    "email": string,
    "telegramId": string
}
```

#### 3. PUT addEmployee (/api/v0/employee)

##### Описание
Добавление нового сотрудника

##### Структура входных данных (body)
```
{
    "name": string,
    "phone": string,
    "email": string,
    "telegramId": string
}   
```

#### 4. PATCH editEmployee (/api/v0/employee/{id})

##### Описание 
Редактирование данных о сотруднике

##### Входные данные (path parameters)
- id: number - ID сотрудника

##### Структура входных данных (body)
```
{
    "name": string,
    "phone": string,
    "email": string,
    "telegramId": string
}   
```

#### 5. DELETE deleteEmployee (/api/v0/employee/{id})

##### Описание
Удаление сотрудника

##### Входные данные (path parameters)
- id: number - ID сотрудника

### API для работы с отпусками

#### 1. GET getVacations (/api/v0/vacation/all)

#### Описание
Получение списка отпусков сотрудников. Отмененные отпуска не должны попадать в список

##### Структура ответа
```
[{
    "id": number,
    "userId": number,
    "type": VacationType
    "dateFrom": string (format dd.MM.yyyy),
    "dateTo": string (format dd.MM.yyyy)
}]

enum VacationType { PAID, UNPAID }
```

#### 2. GET getEmployeeVacations (/api/v0/vacation/{employeeId}/all)

#### Описание
Получение списка отпусков определенного сотрудника. Отмененные отпуска не должны попадать в список

##### Входные данные (path parameters)
- employeeId: number - ID сотрудника

##### Структура ответа
```
[{
    "id": number,
    "userId": number,
    "type": VacationType
    "dateFrom": string (format dd.MM.yyyy),
    "dateTo": string (format dd.MM.yyyy)
}]

enum VacationType { PAID, UNPAID }
```

#### 3. PUT addVacation (/api/v0/vacation)

#### Описание
Оформление отпуска сотрудником

##### Структура входных данных (body)
```
{
    "employeeId": number,
    "type": VacationType
    "dateFrom": string (format dd.MM.yyyy),
    "dateTo": string (format dd.MM.yyyy)
}

enum VacationType { PAID, UNPAID }
```

#### 4. PATCH editVacation (/api/v0/vacation/{id})

#### Описание
Оформление отпуска сотрудником. Редактирование заявление допустимо не позднее, чем за 3 рабочих дня до начала отпуска.

##### Входные данные (path parameters)
- id: number - ID заявления на отпуск

##### Структура входных данных (body)
```
{
    "employeeId": number,
    "type": VacationType
    "dateFrom": string (format dd.MM.yyyy),
    "dateTo": string (format dd.MM.yyyy)
}

enum VacationType { PAID, UNPAID }
```

#### 5. DELETE cancelVacation (/api/v0/vacation/{id})

#### Описание
Отмена заявления на отпуск. Отмена возможна не позднее 3 рабочих дней до начала отпуска.

##### Входные данные (path parameters)
- id: number - ID заявления на отпуск

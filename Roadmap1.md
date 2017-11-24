
# My Plan.

1. Создать консольное приложение (R)        (1 min)
2. Считать параметры командной строки и вывести (R 1.8) (30 mins)
     1. Найти информацию о том как передать в программу аргументы (10 mins)
     2. Найти информацию о том как использовать эти аргументы ( 10 mins)
     3. Потренироваться на простых примерах (10 mins)
     1. Передать в качестве параметра один аргумент и вывести &quot;Hello, {arg}&quot;
3. Добавить возможность аутентификации пользователей(R 1.1) (65 mins)
   1. Создать класс user (R 1.1) (25 mins)
       1. Прочитать главу классы в курсах по Java ( 10 mins)
       2. Создать класс-пример human (5 mins)
            1. Задать несколько переменных этому классу (name, age, pet)
            2. Создать объект этого класса
            3. Задать ему через ввод данных с клавиатуры значения его полей
            4. Вывести в консоль &quot;Hello, my name is {name}, i&#39;m {age} years old and i have a {pet}&quot;
    3. Задать двух начальных пользователей (5 min)
         1. login:auravadima  pass:rAAzhyGF
         2. login:vasya                pass:qwerty
         3. Добавить в коллекцию
        4. Создать новый объект user (1 min)
        5. Заполнить user данными из командной строки: login pass (1 min)
        6. Сравнить логин и пароль user с login и pass начальных пользователей (2 min)
    2. Написать тесты в bat (R 1.12) (25 mins)
        1. Прочитать основные команды в bat ( 15 mins)
        2. Создать bat файл
        3. Сделать тесты на проверку выходной ошибки при различных комбинациях login pass(1-4) (10 mins)
            1. Узнать как получить код ошибки из программы и использовать его как переменную в bat (5 mins)
            2. Rlogin Rpass (Rlogin - Right login) → 0
            3. Rlogin INCpass → 2
            4. INClogin Rpass → 1
            5. INClogin INCpass → 1
4. Добавить возможность авторизации(R 1.11) (77 mins)
    1. Добавить аргументы services.AuthService.Cmd для задания роли, ресурса (R 1.8)  (23 mins)
        1. Добавить опции командной строки (15 mins)
            1. Role: задание роли: WRITE READ EXECUTE
            2. Res: задание пути к ресурсу
        2. Заполнить user параметрами: login pass role res (5 mins)
        3. Вывести параметры в консоль (1 min)
    2. Сделать проверку аргументов на допустимые комбинации (R 1.8) (30 mins)
        1. Возможные комбинации
            1. логин пароль
            2. логин пароль ресурс роль
    2. Если комбинация не соответствует → вывести справку
    3. Сделать проверку валидности аргументов (R 1.9) (14 mins)
        1. Если role не {WRITE, READ, EXECUTE} → невалидный (R 1.5) (2 mins)
            1. Проверять role на совпадение с &quot;WRITE&quot; &quot;READ&quot; &quot;EXECUTE&quot;
        2. Выводить в консоль какие параметры валидные, а какие - нет и код ошибки
        1. Создать два массива, в один из которых будут заноситься невалидные аргументы в виде строк, а в другой валидные
      2. Вывести в консоль оба массива
    4. Добавить тесты: (10 mins)
        1. Rlogin Rpass Rrole Rres  → 0
        2. Rlogin Rpass Rrole INCres → 4
        3. Rlogin Rpass INCrole Rres → 3
        4. Rlogin Rpass INCrole INCres → 3
        5. Rlogin INCpass INCrole INCres → 2
        6. INClogin Rpass INCrole Rres → 1
        7. Rlogin INCpass INCrole Rres → 2
        8. INClogin INCpass INCrole INCres → 1
5. Добавить common-cli (R 1.10) (109 min)
    1. Ожидаемый результат:
        1. Простая реализация подачи аргументов в программу в произвольном порядке (R 1.10)
        2. Получение полностью рабочей консольной утилиты без необходимости ввода вручную всех параметров внутри программы (R 1.8)
        3. Реализация возможности подачи в командную строку различных комбинаций аргументов ( 2, 4, 7)
        4. Вывод справки по аргументу -h
    2. Что для этого нужно узнать:
        1. Нужна ли мне эта библиотека?
            1. После прочтения документации мне станет ясно нужна она мне или я смогу добиться большего, сделав всё нативными методами.
        2. Как добавить стороннюю библиотеку в проект?
            1. Данную информацию легко найти на сайте Stack Overflow
        3. Какие функции мне пригодятся?
            1. Прочитаю на сайте cli примеры использования, посмотрю возможности данной библиотеки
            2. Посмотрю примеры генерации справки
            1. Добавлю вызов справки в проект
        4. Как их использовать в моём проекте?
            1. Прочитав документацию и просмотрев примеры, я определюсь с тем как буду использовать и вообще нужно ли мне это
    3. Прочитать документацию (30 min)
    4. Посмотреть примеры на сайте (20 min)
    5. Скопировать себе пример
    6. Изменить пример под свою задачу (10 min)
    7. Добавить вывод справки (5 mins)
    8. Проверить работоспособность нового кода с common-cli
        1. Вывести login pass role res введённые в аргументах в консоль
        2. Вывести справку
6. Добавить возможность аккаунтизации (R 1.11) (66 mins)
    1. Добавить аргументы services.AuthService.Cmd для задания даты начала, даты конца и объём(R 1.8)  (26 min)
        1. Добавить опции командной строки (15 mins)
            1. Ds: задание начальной даты
            2. De: задание конечной даты
            3. Vol: задание объёма
        2. Заполнить user параметрами: login pass role res  ds de vol (5 mins)
        3. Вывести ds de vol в консоль (1 min)
    2. Добавить проверку на комбинацию аргументов (5 mins)
        1. логин пароль ресурс роль дата\_начала дата\_конца объём
    3. Сделать проверку валидности аргументов (20 mins)
        1. Если vol не число → невалидный
        2. Если ds и de строки не формата &quot;yyyy-MM-dd&quot; → невалидные
            1. Прочитать документацию по java.Time
            2. Задать pattern строки даты
            3. Проводить проверку по данному паттерну &quot;yyyy-MM-dd&quot;
    4. Добавить тесты: (15 mins)
        1. Rlogin Rpass Rrole Rres Rds Rde Rvol → 0
        2. Rlogin Rpass Rrole Rres Rds Rde INCvol → 5
        3. Rlogin Rpass Rrole Rres INCds INCde Rvol → 5
        4. Rlogin Rpass Rrole Rres INCds Rde INCvold → 5
        5. Rlogin Rpass Rrole INCres Rds Rde Rvol → 4
        6. Rlogin Rpass INCrole Rres Rds Rde Rvol → 3
        7. Rlogin INCpass Rrole Rres Rds Rde Rvol → 2
        8. INClogin Rpass Rrole Rres Rds Rde Rvol → 1
7. Написать функцию Hash возвращающую hash пароля (R 1.2) (25 mins)
    1. Ожидаемый результат:
        1. Возможность безопасного хранения паролей
    2. Необходимо узнать: (15 mins)
        1. Как производится хэширование?
        2. Можно ли использовать стандартные функции в java для получения hash?
        3. Если нет, то что необходимо сделать, чтобы получить hash?
    3. Изменить поведение проверки пароля напрямую( 10 mins)
        1. В user сохранять hash (5 min)
        2. Сделать проверку по hash(hash(password)+salt) (5 min)
8. Провести тесты и получить SUCCESS по всем проверкам (10 mins)

#

#

# Тестовые сценарии:

Работаю с пользователями:

Login: auravadima

Pass: rAAzhyGF

И

Login: vasya

Pass: qwerty

Уровень доступа auravadima A.B с ролью EXECUTE
#
Уровень доступа vasya A.K.Y с ролью READ


      1. -l auravadima -p rAAzhyGF → 0
      2. -l auravadima -p qwertyui → 2
      3. -l user -p rAAzhyGF → 1
      4. -l user -p asdg → 1
      5. -l vasya -p qwerty -role READ -res A.K.Y  → 0
      6. -l auravadima -p rAAzhyGF -res A.B -role WRITE → 4
      7. -l vasya -p qwerty -res A.K.Y.innerFolder  -role READ → 0
      8. -l auravadima -p rAAzhyGF -role OPEN -res ABG → 3
      9. -l vasya -p rAAzhyGF -role OPEN -res GHY.IOP → 2
      10. -l user -p qwerty -role OPEN -res ABG.THG.TYU.innerFolder.innerFolder → 1
      11. -l vasya -p rAAzhyGF -role GHJK -res ABG.THG.TYU.innerFolder → 2
      12. -l qwerty -p asdfg -role qwsd -res ABG.THG.TYU → 1
      13. -l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res A.K.Y -role WRITE → 4
      14. -l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG.THG.TYU -role OPEN → 3
      15. -l auravadima -p rAAzhyGF -ds not\_Date -de not\_Date -vol 12345 -res A.B -role EXECUTE → 5
      16. -l auravadima -p rAAzhyGF -ds 2015-12-12 -de not\_Date -vol 12345 -res A.B.C.D.E -role EXECUTE → 5
      17. -l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG -role WRITE → 4
      18. -l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG.THG.TYU -role bjkl →  3
      19. -l auravadima -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG.THG.TYU -role WRITE → 2
      20. -l vadim -p rAAzhyGF -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG.THG.TYU -role WRITE → 1

# Таблица

| Пункт | Предполагаемое время(mins) | Реальное время(mins) |
| --- | --- | --- |
|  1  |  1  |  5  |
|  2  |  30 |  5  |
|  3  |  65 |  31 |
|  4  |  77 |  50 |
|  5  | 109 | 130 |
|  6  |  66 |  30 |
|  7  |  25 |  10 |
|  8  |  10 |  40 |
| Sum | 383 | 301 |


# Дипломный проект по модулю «Автоматизация тестирования» для профессии «Инженер по тестированию»
# Описание проекта
Наше приложение — это веб-сервис, который предлагает купить тур по определённой цене двумя способами:
- Обычная оплата по дебетовой карте.
- Уникальная технология: выдача кредита по данным банковской карты. 

![service.png](pic%2Fservice.png)

  
# Документация

1. [План](https://github.com/SergeevKostia/QA61/blob/main/Docs/Plan.md)
2. [Отчет по итогам тестирования](https://github.com/SergeevKostia/QA61/blob/main/Docs/Report.md)
3. [Отчет по итогам автоматизации](https://github.com/SergeevKostia/QA61/blob/main/Docs/Summary.md)



# Начало работы
1. Клонировать [репризиторий](https://github.com/SergeevKostia/QA61) командой `git clone`;
## Prerequisites
1. Установить Docker Desktop;
2. Установить IntelliJ IDEA;
3. GIT;
4. Google Chrome;
## Установка и запуск
1. Открыть проект в IDEA;
2. Запустить БД командой `docker-compose up`;
3. Запустить приложение командой `java -jar ./artifacts/aqa-shop.jar`;
4. Открыть браузер и ввести в адресную строку `http://localhost:8080/`.
## Запуск тестов
1. Открыть IDEA;
2. Ввести в терминал команду: `./gradlew clean test`.
## Генерация и открытие отчетов
1. Для генерации отчета ввести в терминал команду: `./gradlew allureServe`;
2. После генерации отчет появится в окне браузера.
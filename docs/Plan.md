# План

## 1. Перечень автоматизируемых сценариев

* Покупка тура действующей картой с валидными данными
* Покупка тура в кредит действующей картой с валидными данными
* Покупка тура недействующей картой с валидными данными
* Покупка тура в кредит недействующей картой с валидными данными
* Покупка тура действующей картой с невалидными данными
* Покупка тура в кредит действующей картой с невалидными данными
* Покупка тура недействующей картой с невалидными данными
* Покупка тура в кредит недействующей картой с невалидными данными
* Проверка корректности данных, записанных в MySQL
* Проверка корректности данных, записанных в Postgres

## 2. Перечень используемых инструментов

* IntelliJ IDEA - IDE, облегчающая работу с кодом.
* Git - система контроля версий, позволяющая хранить написанный код (на Github) и отслеживать его изменения.
* JUnit5 - библиотека для создания и выполнения автотестов.
* Gradle - инструмент автоматизации сборки и управления зависимостями, который самостоятельно выкачивает необходимые для работы библиотеки + позволяет создавать автоматические отчеты.
* Selenide - фреймворк для автоматизированного тестирования веб-приложений.
* Docker - система контейнеризации, которая будет эмулировать работу необходимых БД MySQL и PostgreSQL, а также платформы Node.js.

## 3. Перечень возможных рисков

* Проблемы с интерпретацией ТЗ.
* Проблемы с настройкой и запуском приложения (подключение к БД, запуск симулятора банковских сервисов).
* Непредвиденное поведение приложения и симулятора банковских сервисов.

## 4. Интервальная оценка с учётом рисков
1. Подготовка плана автоматизации - 6 часов.
1. Подготовка окружения (развертывание БД, запуск симулятора банковских сервисов, запуск приложения) - 20 часов.
1. Реализация и прогон автотестов, фиксация обнаруженных багов - 40 часов.
1. Создание отчетных документов - 6 часов.

## 5. План сдачи работ
1. Сдача плана: 04 - 06 июля 2022.
1. Подготовка окружения: 07 - 13 июля 2022.
1. Реализация и прогон автотестов: 14 - 26 июля 2022.
1. Создание отчетных документов: 27 - 29 июля 2022.
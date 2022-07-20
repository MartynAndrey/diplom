#Инструкция по запуску

1. Запустить Docker
2. Скачать файлы из репозитория командой  
   git clone https://github.com/MartynAndrey/diplom.git
3. Указать активный профиль (от этого зависит, какая БД будет использоваться), записав в файле application.properties одну из соответствующих строк  
   spring.profiles.active=mysql  
   или  
   spring.profiles.active=postgres
4. Запустить контейнеры Docker одной из соответствующих команд  
   docker-compose -f docker-compose-mysql.yml up -d  
   или  
   docker-compose -f docker-compose-postgres.yml up -d
5. Запусть приложение из файла командой  
   java -jar aqa-shop.jar
6. /Выполнить тестирование и сделать отчет/
7. Остановить приложение
8. Остановить контейнеры Docker одной из соответствующих команд  
   docker-compose -f docker-compose-mysql.yml down  
   или  
   docker-compose -f docker-compose-postgres.yml down

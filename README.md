#Инструкция по запуску

1. Запустить Docker
2. Скачать файлы из репозитория командой  
   git clone https://github.com/MartynAndrey/diplom.git
3. Запустить контейнеры Docker одной из соответствующих команд  
   docker-compose -f docker-compose-mysql.yml up -d  
   или  
   docker-compose -f docker-compose-postgres.yml up -d
4. Запусть приложение из файла соответствующей командой  
   java -jar aqa-shop.jar -Dspring.profiles.active=mysql  
   или  
   java -jar aqa-shop.jar -Dspring.profiles.active=postgres
5. Запустить тесты одной из соответствующих команд  
   ./gradlew test -Ddb.url=jdbc:mysql://192.168.99.100 -Ddb.port=3306  
   или  
   ./gradlew test -Ddb.url=jdbc:postgresql://192.168.99.100 -Ddb.port=5432
6. Сформировать отчет командой  
   ./gradlew allureReport  
   и открыть его в браузере командой  
   ./gradlew allureServe
7. Остановить приложение
8. Остановить контейнеры Docker одной из соответствующих команд  
   docker-compose -f docker-compose-mysql.yml down  
   или  
   docker-compose -f docker-compose-postgres.yml down

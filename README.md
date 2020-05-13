# lab
pratice-rmi:
  1. собрать модули
    $ ./gradlew clean shadowJar
  2. записать в переменную окружения CLASSPATH путь к библиотеке build/libs/server-all.jar
    (оставляю все собраные jar внутри проекта, но могу и сложить в отдельную папку)
    $ export CLASSPATH=~/home/lab/practice-rmi/server/build/libs/server-all.jar
  3. запустить rmiregistry
    $ rmiregistry &
  4. запустить remote server
    $ java -jar ~/home/lab/practice-rmi/server/build/libs/server-all.jar
    $ Server ready
  5. запустить remote client
    $ java -jar ~/home/lab/practice-rmi/client/build/libs/client.jar
    
practice-ejb:
  1. установаить aplication server который поддерживает спецификацию javaee-8
     1.1 скачать архив
       https://wildfly.org/downloads/
     1.2 распаковать архив
       wildfly-19.1.0.Final
     1.3 запустить сервер
       $ wildfly-19.1.0.Final/bin/standalone.sh
     1.4 создать админа
       $ wildfly-19.1.0.Final/bin/add-user.sh
  2. собрать приложение
    $ ./gradlew clean practice-ejb:war
  3. развернуть приложение на wildfly сервере
    через консоль администратора указать путь к war файлу
     build/libs/practice-ejb.war
  4. проверить приложение
    http://127.0.0.1:8080/practice-ejb/

lab-ejb:
    1. установаить aplication server который поддерживает спецификацию javaee-8
      1.1 скачать архив
        https://wildfly.org/downloads/
      1.2 распаковать архив
        wildfly-19.1.0.Final
     1.3 запустить сервер
       $ wildfly-19.1.0.Final/bin/standalone.sh
     1.4 создать админа
       $ wildfly-19.1.0.Final/bin/add-user.sh
  2. собрать приложение
    $ ./gradlew clean lab-ejb:war
  3. развернуть приложение на wildfly сервере
    через консоль администратора указать путь к war файлу
     build/libs/lab-ejb.war
  4. проверить приложение
    http://127.0.0.1:8080/lab-ejb/

# exerciciojbdcfixation

This program is a exercise of Dao architecture using java database connectivity(jdbc), this program uses the classes and api of jdbc, to connect a program in java to a mysql db. The project is called exericiciojdbcfixation, and his db is a abstraction of how a small network of malls works, it contains a table of malls, a table of department stores and a table of rents of department stores.
The program has the all the CRUD a operations, and it has some extra queries as:

1. queries of department store table:
   - findByMall
   - findByIdOfRent
2. queries of mall table:
   - findByIdOfRent
   - findByIdOfDepartmentStore
3. queries of rent table:
   - findAllByIdOfDepartmentStore
   - findAllByIdOfMall

All the tables are available in a file call db.sql, that it's a sql file that has the capacity of being a script of creation of tables and insert some data for testing.

## Requirements

For the usage of mysql and java it's required a connector dependent of operation system, that could be found in:
[mysql official connector](https://dev.mysql.com/downloads/connector/j/)

As a suggestion for the usage of the software, it's recommend to use a mysql docker container for running with the program.
For checking if you have docker available on your system you could check using, this command:
`docker ps`

If you don't have available the docker engine, it's possible to install using:
[official docker website](https://docs.docker.com/engine/install/)

For starting the docker container with the mysql server, that it's required for the usage of program, it's necessary to use the command:
`docker run -d --name mysql-mall-db -p 3306:3306 -v mysqldata-mall:/var/lib/mysql -e "MYSQL_ROOT_PASSWORD=my-secret-pw" mysql:latest`

A file call db.properties could be used, for the connection settings, the default version of the file has the settings of the container.

## Usage of Program

For the usage of the program is necessary create the database, is possible doing that with the docker container informed previously, and is required that the parameters
of the database as password and user and door are equal as described in db.properties file. If some parameter as password, door or user would be change this change must being
do it at the db.properties.
The start script of db.sql contain all the creation of data tables, and the start data for testing the program.
After the installation of the mysql connector is required compile the program, for purpose is required being present on folder **./path-to-project/exerciciojbdcfixation/** and use the command:

```
javac -classpath folder_that_contain_mysql_connector*:. -d ./bin ./src/db/*.java ./src/exerciciojbdcfixation/*.java ./src/model/dao/*.java ./src/model/dao/impl/*.java ./src/model/entities/*.java
```

the **folder_that_contain_mysql_connector** is where was located the .jar file that is the connector mysql for java.

This command will compilate all the .java files on bytecode files(.class).

Is required to copy the file ** db.properties ** to the ./bin folder, is possible to do it that with command:

```
cp db.properties ./bin
```

The execution of the program is possible using the command on the inside de folder **./path-to-project/exerciciojbdcfixation/bin**:

```
java -cp folder_that_contain_mysql_connector*:. exerciciojbdcfixation/MyProjectLauncher
```

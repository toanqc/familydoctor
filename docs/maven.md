
Maven
======

The project comes with pom.xml and it is possible to compile and get the war file by following command .

mvn install


#### Configuring the data source

Database needs to be prepared to create appropriate username and password. The destination database name is medicoder. The following command configures the mysql database,

```
create database medicoder;
grant all privileges on familydoctor.* to medicoder@localhost identified by 'medicoder';
flush privileges;
```

Again the project application context should be configured with appropriate mysql username and password.

```
<bean id="dataSource"
	class="org.springframework.jdbc.datasource.DriverManagerDataSource">
	<property name="driverClassName" value="com.mysql.jdbc.Driver" />
	<property name="url" value="jdbc:mysql://localhost:3306/medicoder" />
	<property name="username" value="medicoder" />
	<property name="password" value="medicoder" />
</bean>

```

#### running the mysql server

Please refer to mysql site to run the mysql server. It is typicaly done by following command,

```
mysql.server restart
```

#### running the web server

And the site can be tested using tomcat server.

```
mvn tomcat7:run-war
```

#### creating the javadoc

Javadoc is created by the `javadoc` command.

```
mvn javadoc:javadoc
```

Javadoc is created automatically in the `target/apidocs/` directory.


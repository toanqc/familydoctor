Technologies
============

#### Annotation

We used validation annotations for spring. We also used the JPA annotation like @entity. Our pages are mapped using the @RequestMapping annotation. We used the @RequestBody to do the ajax.

#### Databinding

The databinding works for the form saving pages. It is done by @ModelAttribute annotation.

#### Persistance in JPA 

The JPA is configured in [application context config file](src/main/webapp/WEB-INF/config/application-context.xml)


All the repositories are maintained by JPA implementation.

```
	<jpa:repositories base-package="mum.waa.fd.app.repository" />
```

There is an entity manager. It is implemented by Hibernate library.

```
	<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
		<property name="entityManagerFactory" ref="entityManagerFactory" />
	</bean>
	<bean id="entityManagerFactory"
		class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="packagesToScan" value="mum.waa.fd.app.domain" />

		<!-- provider-specific initialization,etc. -->
		<property name="jpaVendorAdapter">
			<bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter" />
		</property>
		<property name="jpaProperties">
			<props>
				<!-- validate: validate the schema, makes no changes to the database. 
					update: update the schema. create: creates the schema, destroying previous 
					data. create-drop: drop the schema at the end of the session. These options 
					intended to be developers tools and not to facilitate any production level 
					database -->
				<prop key="hibernate.hbm2ddl.auto">create-drop</prop>
				<!-- hibernate.dialect. This property makes Hibernate generate the appropriate 
					SQL for the chosen database. -->
				<prop key="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</prop>
				<prop key="hibernate.hbm2ddl.import_files">populate.sql</prop>
			</props>
		</property>

	</bean>
```

And data source configuration

```
	<bean id="dataSource"
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://localhost:3306/medicoder" />
		<property name="username" value="root" />
		<property name="password" value="root" />
	</bean>

```


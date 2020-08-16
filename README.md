# Spring-MVC-CRUDOperation
Spring-MVC -CRUD application with QJuery(Asynchronous request) and with email validation

This application was build using H2 Database , for using Oracle DB if any error occur we should install
the corresponding driver.

mvn install:install-file -Dfile=H:/spring boot/miniprojects/ojdbc8.jar -DgroupId=com.oracle 
	-DartifactId=ojdbc8 -Dversion=19.3 -Dpackaging=jar


	<dependency>
		<groupId>com.oracle</groupId>
		<artifactId>ojdbc</artifactId>
		<version>8</version>
		<scope>system</scope>
		<systemPath>H:/spring boot/ojdbc6.jar</systemPath>
	</dependency>


mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=19.3 -Dpackaging=jar -Dfile=ojdbc8.jar -DgeneratePom=true



mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar -Dfile=ojdbc6.jar -DgeneratePom=true

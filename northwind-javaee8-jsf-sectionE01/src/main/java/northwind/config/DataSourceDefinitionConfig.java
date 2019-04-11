package northwind.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;

@DataSourceDefinition(
	name="java:app/datasources/northwind-javaee8-jsf-sectionE01/NorthwindDS",
	className="com.mysql.cj.jdbc.MysqlDataSource",
	url="jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC",
	user="dmit2015",
	password="Password2015")
//@DataSourceDefinition(
//		name="java:app/datasources/ProjectDS",
//		className="com.microsoft.sqlserver.jdbc.SQLServerDataSource",
//		url="jdbc:sqlserver://localhost;databaseName=DMIT2015ProjectDB",
//		user="dmit2015",
//		password="Password2015")
@ApplicationScoped
public class DataSourceDefinitionConfig {

}

package security.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@BasicAuthenticationMechanismDefinition(
	realmName="jaspitest"
)

@DatabaseIdentityStoreDefinition(
	dataSourceLookup="java:app/datasources/ChinookDS",
	callerQuery="SELECT password FROM LoginUser WHERE username = ?",
	groupsQuery="SELECT g.groupname FROM LoginUser u, LoginUserGroup ug, LoginGroup g WHERE u.username = ? AND u.id = ug.userid AND ug.groupid = g.id",
	priority = 10
)

@DataSourceDefinition(
	name="java:app/datasources/ChinookDS",
	className="com.mysql.cj.jdbc.MysqlDataSource",
	url="jdbc:mysql://localhost:3306/Chinook?serverTimezone=UTC",
	user="dmit2015",
	password="Password2015"
)

@ApplicationScoped
public class ApplicationSecurityConfig {

}

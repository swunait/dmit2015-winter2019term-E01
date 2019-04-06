package security.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

@EmbeddedIdentityStoreDefinition({
	@Credentials(callerName="admin2015", password="adminPassword2015",groups="VIEW_ADMIN_PAGES")
})

@CustomFormAuthenticationMechanismDefinition(
	loginToContinue = @LoginToContinue(
		loginPage="/login.xhtml", 
		useForwardToLogin = false,
		errorPage="")
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

@FacesConfig @ApplicationScoped
public class ApplicationSecurityConfig {

}

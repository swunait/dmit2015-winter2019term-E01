package security.config;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.LdapIdentityStoreDefinition;

import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

//@BasicAuthenticationMechanismDefinition(
//	realmName="jaspitest"
//)

@FormAuthenticationMechanismDefinition(		
	loginToContinue = @LoginToContinue(
		loginPage="/login.html",
		errorPage="/login.html?error=true"
	)
)

@EmbeddedIdentityStoreDefinition({
	@Credentials(callerName = "user2015", password = "Password2015",groups= {"VIEW_USER_PAGES"}),
	@Credentials(callerName="admin2015",password="Password2015",
		groups= {"VIEW_USER_PAGES","VIEW_ADMIN_PAGES"})
})

@LdapIdentityStoreDefinition(
	url = "ldap://metro-ds1.nait.ca:389",
	callerSearchBase = "dc=nait,dc=ca",
	callerNameAttribute = "SamAccountName",	// SamAccountName or UserPrincipalName
	groupSearchBase = "dc=nait,dc=ca",
	bindDn = "cn=DMIT Student1,ou=DMITStudentRestricted,ou=Student,ou=DMIT,ou=SICET,dc=nait,dc=ca",
	bindDnPassword = "Password2015",
	priority = 5
)

@ApplicationScoped
public class ApplicationSecurityConfig {

}

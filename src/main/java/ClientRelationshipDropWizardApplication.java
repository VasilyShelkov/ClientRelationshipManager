import account.AccountDetailServiceImpl;
import account.AccountServiceImpl;
import account.AccountsDetailResource;
import account.AccountsResource;
import account.client.ClientAccountsServiceImpl;
import account.protectedname.ProtectedNameAccountsServiceImpl;
import account.unprotectedname.UnprotectedNameAccountsService;
import account.unprotectedname.UnprotectedNameAccountsServiceImpl;
import dataObjects.Account;
import dataObjects.Name;
import database.ConnectionService;
import database.account.AccountDetailsSQLService;
import database.account.ClientAccountsSQLService;
import database.account.ProtectedNameAccountsSQLService;
import database.account.UnprotectedNameAccountsSQLService;
import database.generic.GenericAccountSQLService;
import database.generic.GenericNamesSQLService;
import database.names.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import names.NameDetailsServiceImpl;
import names.NamesResource;
import names.NamesServiceImpl;
import names.clients.AccountClientsServiceImpl;
import names.clients.ClientDetailsResource;
import names.clients.ClientDetailsServiceImpl;
import names.protectednames.AccountProtectedNamesServiceImpl;
import names.protectednames.ProtectedNameDetailsResource;
import names.protectednames.ProtectedNameDetailsService;
import names.protectednames.ProtectedNameDetailsServiceImpl;
import names.unprotectednames.AccountUnprotectedNamesServiceImpl;
import names.unprotectednames.UnprotectedNameDetailsResource;
import names.unprotectednames.UnprotectedNameDetailsServiceImpl;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.EnumSet;

/**
 * Created by Vasia on 14/01/2015.
 */
@Configuration
public class ClientRelationshipDropWizardApplication extends Application<ClientRelationshipDropWizardConfiguration> {

    private static ApplicationContext clientRelationshipManagerContext;

    public static void main(String[] args) throws Exception {
        clientRelationshipManagerContext = getClientRelationshipManagerContext();
        new ClientRelationshipDropWizardApplication().run(args);
    }

    public static ApplicationContext getClientRelationshipManagerContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ClientRelationshipDropWizardApplication.class);
        context.register(AccountsResource.class);
        context.register(AccountServiceImpl.class);
        context.register(GenericAccountSQLService.class);
        context.register(AccountsDetailResource.class);
        context.register(AccountDetailServiceImpl.class);
        context.register(AccountDetailsSQLService.class);
        context.register(UnprotectedNameAccountsServiceImpl.class);
        context.register(UnprotectedNameAccountsSQLService.class);
        context.register(ProtectedNameAccountsServiceImpl.class);
        context.register(ProtectedNameAccountsSQLService.class);
        context.register(ClientAccountsServiceImpl.class);
        context.register(ClientAccountsSQLService.class);

        context.register(NamesResource.class);
        context.register(NamesServiceImpl.class);
        context.register(GenericNamesSQLService.class);
        context.register(NameDetailsServiceImpl.class);
        context.register(NameDetailsSQLService.class);

        context.register(AccountUnprotectedNamesServiceImpl.class);
        context.register(AccountUnprotectedNamesSQLService.class);
        context.register(AccountProtectedNamesServiceImpl.class);
        context.register(AccountProtectedNamesSQLService.class);
        context.register(AccountClientsServiceImpl.class);
        context.register(AccountClientsSQLService.class);

        context.register(UnprotectedNameDetailsResource.class);
        context.register(UnprotectedNameDetailsServiceImpl.class);
        context.register(UnprotectedNameDetailsSQLService.class);

        context.register(ProtectedNameDetailsResource.class);
        context.register(ProtectedNameDetailsServiceImpl.class);
        context.register(ProtectedNameDetailsSQLService.class);

        context.register(ClientDetailsResource.class);
        context.register(ClientDetailsServiceImpl.class);
        context.register(ClientDetailsSQLService.class);

        context.register(ConnectionService.class);
        context.refresh();
        return context;
    }

    @Override
    public void run(ClientRelationshipDropWizardConfiguration configuration, Environment environment) throws Exception {
        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        //environment.jersey().register(clientRelationshipManagerContext.getBean("accountsResource"));
        //environment.jersey().register(clientRelationshipManagerContext.getBean("accountsDetailResource"));
        //environment.jersey().register(clientRelationshipManagerContext.getBean("namesResource"));
        environment.jersey().register(clientRelationshipManagerContext.getBean("unprotectedNameDetailsResource"));
        //environment.jersey().register(clientRelationshipManagerContext.getBean("protectedNameDetailsResource"));
        //environment.jersey().register(clientRelationshipManagerContext.getBean("clientDetailsResource"));
    }

    @Override
    public void initialize(Bootstrap<ClientRelationshipDropWizardConfiguration> bootstrap) {
    }

    @Bean(name = "validator")
    public Validator getValidator(){
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Bean(name = "url")
    public String getUrl(){
        return "jdbc:mysql://localhost:3306/protectme";
    }

    @Bean(name = "user")
    public String getName(){
        return "root";
    }

    @Bean(name = "pass")
    public String getPassword(){
        return "root";
    }

    @Bean(name = "accountClazz")
    public Class<Account> getAccountClazz(){
        return Account.class;
    }

    @Bean(name = "nameClazz")
    public Class<Name> getNameClazz() { return Name.class; }
}

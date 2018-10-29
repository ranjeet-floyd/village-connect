package org.village.connect;



import org.village.connect.dao.UserDao;
import org.village.connect.resources.UserResource;
import org.village.connect.service.UserService;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.jdbi.v3.core.Jdbi;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * @author ranjeet.kumar
 * Dropwizard based application launcher.
 */
public class VillageConnect extends Application<VillageConnectConfiguration> {
    
    private static final String SQL = "sql";
    private static final String VILLAGE_CONNECT_REST_SERVICE = "Village connect rest service";

    /**
     * Java entry point.
     * 
     * @param args the command-line arguments.
     * @throws Exception an error occurred.
     */
    public static void main(String[] args) throws Exception {
        new VillageConnect().run(args);
    }

    /**
     * @see io.dropwizard.Application#initialize(io.dropwizard.setup.Bootstrap)
     */
    @Override
    public void initialize(Bootstrap<VillageConnectConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
                bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
        bootstrap.addBundle(new AssetsBundle());
        // TODO: add HibernateBundle
        // bootstrap.addBundle(hibernateBundle);
    }

    /**
     * @see io.dropwizard.Application#run(io.dropwizard.Configuration, io.dropwizard.setup.Environment)
     */
    @Override
    public void run(VillageConnectConfiguration configuration, Environment environment) {
        // Datasource configuration
        JdbiFactory jdbiFactory  = new JdbiFactory();
        Jdbi jdbi =  jdbiFactory.build(environment, configuration.getDataSourceFactory(), SQL);
        //final DBIFactory factory = new DBIFactory();
//        final DataSource dataSource =
//            configuration.getDataSourceFactory().build(environment.metrics(), SQL);
//        
//        Jdbi jdbi = Jdbi.create(dataSource);
//        jdbi.installPlugin(new SqlObjectPlugin());
        // Common modules
        environment.jersey().register(new AbstractBinder() {
            @Override
            protected void configure() {
                // Configuration
                bind(configuration).to(VillageConnectConfiguration.class);
            }
        });
        // register user resource service
        UserDao userDao =  jdbi.onDemand(UserDao.class);
        environment.jersey().register(new UserResource(new UserService(userDao)));

        // Resources
        registerModules("org.village.connect.resources", "Resource", (classInfo) -> {
            environment.jersey().register(classInfo.load());
        });
    }

    private void registerModules(String packageName, String classNameSuffix, Consumer<? super ClassInfo> action) {
        try {
            ClassPath.from(Thread.currentThread().getContextClassLoader()).getTopLevelClassesRecursive(packageName)
                    .stream().filter((classInfo) -> classInfo.getName().endsWith(classNameSuffix)).forEach(action);
        } catch (IOException ex) {
            throw new IllegalStateException(ex.getMessage(), ex);
        }
    }

}

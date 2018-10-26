package org.village;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * Dropwizard based application launcher.
 */
public class connect extends Application<connectConfiguration> {

    /**
     * Java entry point.
     * 
     * @param args the command-line arguments.
     * @throws Exception an error occurred.
     */
    public static void main(String[] args) throws Exception {
        new connect().run(args);
    }

    /**
     * @see io.dropwizard.Application#initialize(io.dropwizard.setup.Bootstrap)
     */
    @Override
    public void initialize(Bootstrap<connectConfiguration> bootstrap) {
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
    public void run(connectConfiguration configuration, Environment environment) {
        // Common modules
        environment.jersey().register(new AbstractBinder() {
            @Override
            protected void configure() {
                // Configuration
                bind(configuration).to(connectConfiguration.class);
            }
        });

        // Resources
        registerModules("org.village.resources", "Resource", (classInfo) -> {
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

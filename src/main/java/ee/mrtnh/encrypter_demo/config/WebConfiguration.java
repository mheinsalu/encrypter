package ee.mrtnh.encrypter_demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class WebConfiguration implements ServletContextInitializer {
    // Class from https://dba-presents.com/index.php/jvm/java/87-enabling-h2-db-in-spring-boot-app
    
    private static final Logger logger = LoggerFactory.getLogger(WebConfiguration.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        initH2Console(servletContext);
    }

    private void initH2Console(ServletContext servletContext) {
        logger.info("Starting H2 console");
        ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
        h2ConsoleServlet.addMapping("/h2-console/*");
        h2ConsoleServlet.setLoadOnStartup(1);
    }
}

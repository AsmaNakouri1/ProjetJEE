package util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
public static SessionFactory sessionFactory;
private static ServiceRegistry serviceRegistry;
public static String CONFIG_FILE_LOCATION = "hibernate.cfg.xml";
static {
	try {
			Configuration configuration = new Configuration();
				configuration.configure();
				serviceRegistry = new ServiceRegistryBuilder().applySettings(
							configuration.getProperties()). buildServiceRegistry();
					sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
}
}}
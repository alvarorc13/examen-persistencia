package main.java.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConnectionUtil {
	
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		try {
			//configure hace que se lea la configuración de hibernate.cfg.xml
			registry = new StandardServiceRegistryBuilder().configure().build();
			Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}catch(Exception e) {
			shutdown();
			e.printStackTrace();
		}
		
		return sessionFactory;
	}
	
	public static void shutdown() {
		if(registry!=null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}


}

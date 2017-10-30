package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("rehber-unit");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}

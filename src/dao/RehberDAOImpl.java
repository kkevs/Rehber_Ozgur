package dao;
import util.JPAUtil;
import models.Rehber;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.primefaces.event.RowEditEvent;

import java.util.List;

public class RehberDAOImpl implements RehberDAO{
	private EntityManager entityManager;

    public RehberDAOImpl() {
        EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Rehber insertRehber(Rehber rehber) {
        entityManager.getTransaction().begin();
        entityManager.persist(rehber);
        entityManager.getTransaction().commit();
        return rehber;
    }

    public Rehber findRehber(int id) {
        return entityManager.find(Rehber.class, id);
    }

    public List<Rehber> findAllRehber() {
        TypedQuery<Rehber> query = entityManager.createQuery("select r from Rehber r", Rehber.class);
        return query.getResultList();
    }

    public void removeRehber(int id) {
        Rehber rehber = findRehber(id);
        if (rehber != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(rehber);
            entityManager.getTransaction().commit();
        }
    }

    public void updateRehber(RowEditEvent event) {
    	Rehber rehber=(Rehber) event.getObject();
        entityManager.getTransaction().begin();
        entityManager.merge(rehber);
        entityManager.getTransaction().commit();
    }

}

package main;

import dao.RehberDAOImpl;
import models.Rehber;

public class Test {
	public static void main(String[] args) {

		RehberDAOImpl daoImlp = new RehberDAOImpl();

		Rehber rehber = new Rehber("husnu", "kose", "kkevs@gmail.com", 123);

		daoImlp.insertRehber(rehber);
	}
}

package dao;

import models.Rehber;

import java.util.List;

import org.primefaces.event.RowEditEvent;

public interface RehberDAO{
    public Rehber insertRehber(Rehber rehber);

    public Rehber findRehber(int id);

    public List<Rehber> findAllRehber();

    public void removeRehber(int id);

    public void updateRehber(RowEditEvent event);
}

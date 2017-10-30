package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import dao.RehberDAOImpl;
import models.Rehber;

@ManagedBean(name = "rehberControler", eager = true)
@RequestScoped
public class RehberController {
	Rehber rehber = new Rehber();
	RehberDAOImpl rehberDao = new RehberDAOImpl();
	List<Rehber> rehbers = new ArrayList<Rehber>();
	private Rehber selectedKisi;

	public RehberController() {
		super();
		rehbers = rehberDao.findAllRehber();
	}

	public Rehber getRehber() {
		return rehber;
	}

	public List<Rehber> getRehbers() {
		return rehbers;
	}

	

	public Rehber getSelectedKisi() {
		return selectedKisi;
	}

	public void setSelectedKisi(Rehber selectedKisi) {
		this.selectedKisi = selectedKisi;
	}

	public void setRehbers(List<Rehber> rehbers) {
		this.rehbers = rehbers;
	}
	public void onRowEdit(RowEditEvent event) {
		rehberDao.updateRehber(event);
        FacesMessage msg = new FacesMessage("Güncellendi", ((Rehber) event.getObject()).getAd());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Düzenleme Kapandý", ((Rehber) event.getObject()).getAd());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void deleteRehber() {
		int id=selectedKisi.getId();
		rehberDao.removeRehber(id);
		selectedKisi = null;
	}

	public void addRehber() {
		rehberDao.insertRehber(rehber);
	}

}

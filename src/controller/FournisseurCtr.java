package controller;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.FournisseurDao;
import entity.Fournisseur;



@ManagedBean(name="fournisseurCtr")
@SessionScoped
public class FournisseurCtr {
	
	private String idF;
	private String nom;
	private String adresse;
	private FournisseurDao fournisseurDao ;
	public String find() {
		fournisseurDao = new FournisseurDao();
		Fournisseur four = fournisseurDao.findById(idF);
		if (four != null)
			return"success";
		FacesContext.getCurrentInstance().addMessage(
				null,new FacesMessage("produit non trouvable ! "));
		return"fail";
	}
	public String getIdF() {
		return idF;
	}
	public void setIdF(String idF) {
		this.idF = idF;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	
}

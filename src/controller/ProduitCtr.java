package controller;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.ProduitDao;
import entity.Produit;



@ManagedBean(name="produitCtr")
@SessionScoped
public class ProduitCtr {
	
	private String idp;
	private String nomp;
	private BigDecimal quantitep;
	private ProduitDao ProduitDao ;
	public String find() {
		ProduitDao = new ProduitDao();
		Produit prod = ProduitDao.findById(nomp);
		if (prod != null)
			{FacesContext.getCurrentInstance().addMessage(
					null,new FacesMessage("produit trouvable : "+ prod.toString()));
			return"success";}
		else{
		FacesContext.getCurrentInstance().addMessage(
				null,new FacesMessage("produit non trouvable ! "));
		return"fail";}
	}

	public String getNomp() {
		return nomp;
	}
	public void setNomp(String nom) {
		this.nomp = nom;
	} 
	public void setIdp(String id) {
		this.idp = id;
	}


	public BigDecimal getQuantitep() {
		return quantitep;
	}


	public void setQuantitep(BigDecimal quantite) {
		this.quantitep = quantitep;
	}




}

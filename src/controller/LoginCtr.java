package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UtilisateurDao;
import entity.Utilisateur;


@ManagedBean(name="loginCtr")
@SessionScoped
public class LoginCtr {
	
	private String userName;
	private String userPassWord;
	private UtilisateurDao utilisateurDao ;
	public String connecter() {
		utilisateurDao = new UtilisateurDao();
		Utilisateur user = utilisateurDao.findById(userName);
		if (user != null && user.getPassword().equals(userPassWord))
			return"success";
		FacesContext.getCurrentInstance().addMessage(
				null,new FacesMessage("Utilisateur invalide ou mot de passe incorrecte ! "));
		return"fail";
	}
	
	public String ajouterUtilisateur()
	{
		utilisateurDao = new UtilisateurDao();
		if(userName!="" && userPassWord!="")
		{
		Utilisateur user=new Utilisateur(userName,userPassWord);
		utilisateurDao.persist(user);
		FacesContext.getCurrentInstance().addMessage(
				null,new FacesMessage("Utilisateur ajouter! "));
		return "success";
		}
		else return "fail";
	}
	
	public String back()
	{
		return "back";
	}
 
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}	
	
}

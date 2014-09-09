package findbusweb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

@Named
@ViewAccessScoped
public class HomeMB implements Serializable {
	private static final long serialVersionUID = -4322633329714127833L;

	private String mensagem = "digite algo";
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public void action(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(getMensagem()));
	}

}

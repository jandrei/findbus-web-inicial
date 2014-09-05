package findbusweb;

import java.io.Serializable;

import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

@Named
@ViewAccessScoped
public class HomeMB implements Serializable {
	private static final long serialVersionUID = -4322633329714127833L;

	public String getMessage() {
		System.out.println("jandrei masiero");
		return "funcionou";
	}

}

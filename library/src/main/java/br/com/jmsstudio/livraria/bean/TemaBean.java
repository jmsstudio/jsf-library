package br.com.jmsstudio.livraria.bean;

import br.com.jmsstudio.utils.jsf.SessionModel;

import java.io.Serializable;

@SessionModel
public class TemaBean implements Serializable {
	
	private static final long serialVersionUID = 3740536135286026768L;
	
	private String tema = "afternoon";

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public String[] getTemas() {
		return new String[]{"afterdark","afternoon","afterwork","aristo",
			"black-tie","blitzer","bluesky","bootstrap","casablanca",
			"cupertino","cruze","dark-hive","delta","dot-luv","eggplant",
			"excite-bike","flick","glass-x","home","hot-sneaks",
			"humanity","le-frog","midnight","mint-choc","overcast",
			"pepper-grinder","redmond","rocket","sam","smoothness",
			"south-street","start","sunny","swanky-purse","trontastic",
			"ui-darkness","ui-lightness","vader"};
	}
	

}

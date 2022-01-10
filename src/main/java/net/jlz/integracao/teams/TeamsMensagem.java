package net.jlz.integracao.teams;

import com.google.gson.JsonObject;

/**
 * Classe de representação do corpo de uma mensagem a ser enviada ao Teams.
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 10/01/2022
 */
public class TeamsMensagem {

	private static final String TEXT = "text";

	private final JsonObject teamsMensagemJO = new JsonObject();
	private final String texto;

	public TeamsMensagem(final String texto) {
		this.texto = texto;
	}

	/**
	 * Converte TeamsMessage para JSON
	 * @return JsonObject
	 */
	public JsonObject getBody() {
		if (this.texto == null) {
			throw new IllegalArgumentException("Valor de texto ausente em @TeamsMensagem");
		} else {
			this.teamsMensagemJO.addProperty(TeamsMensagem.TEXT, this.texto);
		}
		return this.teamsMensagemJO;
	}

}

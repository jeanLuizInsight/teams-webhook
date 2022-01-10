package net.jlz.integracao.teams;

/**
 * Exception personalizada para TeamsApi
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 10/01/2022
 */
public class TeamsException extends RuntimeException {

	private static final long serialVersionUID = -7363679371551550900L;

	public TeamsException(final Throwable cause) {
		super(cause);
	}
}

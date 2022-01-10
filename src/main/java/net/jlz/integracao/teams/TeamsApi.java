package net.jlz.integracao.teams;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import com.google.gson.JsonObject;

/**
 * Classe cliente.
 * @author <a href="mailto:jean.zanatta@unoesc.edu.br">Jean Luiz Zanatta</a>
 * @since 10/01/2022
 */
public class TeamsApi {

	private static final String POST = "POST";
	private static final String UTF_8 = "UTF-8";

	private final String endPoint;
	private final int timeout;
	private final Proxy proxy;

	public TeamsApi(final String endPoint) {
		this(endPoint, 5000, Proxy.NO_PROXY);
	}

	public TeamsApi(final String endPoint, final int timeout, final Proxy proxy) {
		this.timeout = timeout;
		if (endPoint == null) {
			throw new IllegalArgumentException("Configuração de URL do WebHook ausente em @TeamsApi");
		}
		if (proxy == null) {
			this.proxy = Proxy.NO_PROXY;
		} else {
			this.proxy = proxy;
		}
		this.endPoint = endPoint;
	}

	public void enviar(final TeamsMensagem mensagem) {
		if (mensagem != null) {
			this.enviar(mensagem.getBody());
		}
	}

	private String enviar(final JsonObject mensagem) {
		HttpURLConnection connection = null;
		try {
			// criar a conexão
			final URL url = new URL(this.endPoint);
			connection = (HttpURLConnection) url.openConnection(this.proxy);
			connection.setRequestMethod(TeamsApi.POST);
			connection.setConnectTimeout(this.timeout);
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			final String payload = URLEncoder.encode(mensagem.toString(), TeamsApi.UTF_8);

			// enviar requisição
			final DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(payload);
			wr.flush();
			wr.close();

			// capturar resposta
			final InputStream is = connection.getInputStream();
			final BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			final StringBuilder response = new StringBuilder();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\n');
			}
			rd.close();
			return response.toString();
		} catch (final Exception e) {
			throw new TeamsException(e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}

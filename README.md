# teams-webhook

Integração Teams WebHook para Java

# Exemplo

```java

// Enviar uma mensagem simples
TeamsApi api = new TeamsApi("https://dominio_conta.webhook.office.com/webhookb2/id_1/IncomingWebhook/id_2/id_3");
api.enviar(new TeamsMessage("minha_emnsagem"));


```
Por enquanto a API disponibiliza de um corpo simples (apenas texto). Se necessário poderá ser configurado mais atributos na classe TeamsMensagem.java de acordo com o payload data:
https://docs.microsoft.com/pt-br/microsoftteams/platform/webhooks-and-connectors/how-to/connectors-using?tabs=cURL

# Instalação
Adicionar a seguinte dependência no __pom.xml__
```xml
<dependency>
  <groupId>net.jlz.integracao.teams</groupId>
  <artifactId>teams-webhook</artifactId>
  <version>1.0.0</version>
</dependency>
```

# Configuração

1. Ver artigo: https://docs.microsoft.com/pt-br/microsoftteams/platform/webhooks-and-connectors/how-to/add-incoming-webhook

# Change Log
* 1.0.0
  - Versão inicial com texto simples


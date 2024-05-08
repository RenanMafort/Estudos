package br.com.devdojo.varargs.requisicoesHttp.request;
import br.com.devdojo.varargs.requisicoesHttp.model.Response;
import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;

public class Teste {
    public static void main(String[] args) {
//        int x = 10;
//        int y = 5;
//        int result = (x++ + y--) - (--x - ++y);
//        System.out.println(result);

        double peso = 24.8090;
        System.out.println(String.format("%.1f",peso));

    }

//    public static void main(String[] args) {
//        // Configuração do Pool de Conexões (opcional, mas recomendado)
//        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
//        connectionManager.setMaxTotal(200); // Número máximo de conexões totais
//        connectionManager.setDefaultMaxPerRoute(20); // Número máximo de conexões por rota
//
//        // Configuração de timeouts
//        RequestConfig requestConfig = RequestConfig.custom()
//                .setConnectTimeout(5000) // Tempo limite de conexão em milissegundos (5 segundos)
//                .setSocketTimeout(5000)  // Tempo limite de leitura em milissegundos (5 segundos)
//                .build();
//
//        try (CloseableHttpClient httpClient = HttpClients.custom()
//                .setConnectionManager(connectionManager) // Configura o Pool de Conexões
//                .setDefaultRequestConfig(requestConfig) // Aplica a configuração de timeouts
//                .build()) {
//
//            HttpGet httpGet = new HttpGet("http://localhost:3000/teste");
//            httpGet.addHeader("Accept", "application/json");
//
//            HttpResponse httpResponse = httpClient.execute(httpGet);
//            String json = EntityUtils.toString(httpResponse.getEntity());
//
//            // Converte o JSON em um objeto Resposta
//            Gson gson = new Gson();
//            Response resposta = gson.fromJson(json, Response.class);
//
//            System.out.println("Mensagem: " + resposta.getMensagem());
//            System.out.println("Status: " + resposta.getStatusCode());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

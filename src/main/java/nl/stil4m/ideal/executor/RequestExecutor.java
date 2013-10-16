package nl.stil4m.ideal.executor;

import nl.stil4m.ideal.IdealConstants;
import nl.stil4m.ideal.exceptions.FailedRequestException;
import nl.stil4m.ideal.exceptions.RequestExecutorException;
import nl.stil4m.ideal.requests.IdealRequest;
import nl.stil4m.ideal.responses.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

public class RequestExecutor {

    private final String scheme;
    private final String path;
    private final String url;

    public RequestExecutor() {
        this.scheme = IdealConstants.MOLLIE_IDEAL_SCHEME;
        this.url = IdealConstants.MOLLIE_IDEAL_URL;
        this.path = IdealConstants.MOLLIE_IDEAL_PATH;
    }

    public RequestExecutor(String scheme, String url, String path) {
        this.scheme = scheme;
        this.url = url;
        this.path = path;
    }

    public <T extends Response> T execute(IdealRequest<T> request) throws FailedRequestException {
        try {
            HttpGet get = buildHttpRequest(request);
            DefaultHttpClient client = new DefaultHttpClient();
            HttpResponse httpResponse = client.execute(get);

            JAXBContext jaxbContext = JAXBContext.newInstance(request.getResponseClass());

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            T response = (T) jaxbUnmarshaller.unmarshal(httpResponse.getEntity().getContent());
            if (!response.succeeded()) {
                throw new FailedRequestException(request, response);
            }
            return response;
        } catch (ClientProtocolException e) {
            throw new RequestExecutorException(e);
        } catch (IOException e) {
            throw new RequestExecutorException(e);
        } catch (JAXBException e) {
            throw new RequestExecutorException(e);
        } catch (URISyntaxException e) {
            throw new RequestExecutorException(e);
        }
    }

    private HttpGet buildHttpRequest(IdealRequest request) throws URISyntaxException {
        URIBuilder builder = new URIBuilder()
                .setScheme(scheme)
                .setHost(url)
                .setPath(path);

        Map<String, String> data = request.getData();
        Set<Map.Entry<String, String>> set = data.entrySet();
        for (Map.Entry<String, String> entry : set) {
            builder.addParameter(entry.getKey(), entry.getValue());
        }
        URI uri = builder.build();
        return new HttpGet(uri);
    }
}

// Copyright 2013 Mats Stijlaart
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package nl.stil4m.ideal.executor;

import nl.stil4m.ideal.IdealConstants;
import nl.stil4m.ideal.exceptions.FailedRequestException;
import nl.stil4m.ideal.exceptions.RequestExecutorException;
import nl.stil4m.ideal.requests.IdealRequest;
import nl.stil4m.ideal.responses.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

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
    private final HttpClient httpClient;

    public RequestExecutor(HttpClient httpClient) {
        this(
                IdealConstants.MOLLIE_IDEAL_SCHEME,
                IdealConstants.MOLLIE_IDEAL_URL,
                IdealConstants.MOLLIE_IDEAL_PATH,
                httpClient
        );
    }

    public RequestExecutor(String scheme, String url, String path, HttpClient httpClient) {
        this.scheme = scheme;
        this.url = url;
        this.path = path;
        this.httpClient = httpClient;
    }

    public <T extends Response> T execute(IdealRequest<T> request) throws FailedRequestException {
        try {
            HttpGet get = buildHttpRequest(request);
            HttpResponse httpResponse = httpClient.execute(get);

            JAXBContext jaxbContext = JAXBContext.newInstance(request.getResponseClass());

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            T response = (T) jaxbUnmarshaller.unmarshal(httpResponse.getEntity().getContent());
            if (!response.succeeded()) {
                throw new FailedRequestException(request, response);
            }
            return response;
        } catch (IOException | JAXBException | URISyntaxException e) {
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

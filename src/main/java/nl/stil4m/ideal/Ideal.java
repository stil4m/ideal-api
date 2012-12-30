package nl.stil4m.ideal;

import nl.stil4m.ideal.exceptions.FailedRequestException;
import nl.stil4m.ideal.executor.RequestExecutor;
import nl.stil4m.ideal.requests.Request;
import nl.stil4m.ideal.responses.Response;

import java.util.Properties;

public class Ideal {

    private final String partnerId;
    private final Properties properties;
    private final RequestExecutor requestExecutor;

    public Ideal(String partnerId, RequestExecutor requestExecutor) {
        this.partnerId = partnerId;
        this.requestExecutor = requestExecutor;
        this.properties = new IdealProperties();
    }

    public Ideal(String partnerId, RequestExecutor requestExecutor, Properties properties) {
        this.partnerId = partnerId;
        this.properties = properties;
        this.requestExecutor = requestExecutor;
    }

    public <T extends Response> T execute(Request<T> request) throws FailedRequestException {
        return requestExecutor.execute(request);
    }

    public String getPartnerId() {
        return partnerId;
    }
}

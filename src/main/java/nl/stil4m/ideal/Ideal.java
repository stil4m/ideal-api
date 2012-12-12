package nl.stil4m.ideal;

import nl.stil4m.ideal.exceptions.FailedRequestException;
import nl.stil4m.ideal.requests.Request;
import nl.stil4m.ideal.responses.Response;

import java.util.Properties;

public class Ideal {

    private final Properties properties;
    private final RequestExecutor requestExecutor;

    public Ideal(RequestExecutor requestExecutor) {
        this.requestExecutor = requestExecutor;
        this.properties = new IdealProperties();
    }

    public Ideal(RequestExecutor requestExecutor, Properties properties) {
        this.properties = properties;
        this.requestExecutor = requestExecutor;
    }

    public <T extends Response> T execute(Request<T> request) throws FailedRequestException {
        return requestExecutor.execute(request);
    }
}

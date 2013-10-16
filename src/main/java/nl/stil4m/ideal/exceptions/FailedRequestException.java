package nl.stil4m.ideal.exceptions;

import nl.stil4m.ideal.requests.IdealRequest;
import nl.stil4m.ideal.responses.Response;

public class FailedRequestException extends Throwable {

    private final IdealRequest request;
    private final Response response;

    public <T extends Response> FailedRequestException(IdealRequest<T> request, T response) {
        this.response = response;
        this.request = request;
    }

    public IdealRequest getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }
}

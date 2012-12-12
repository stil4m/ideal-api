package nl.stil4m.ideal.exceptions;

import nl.stil4m.ideal.requests.Request;
import nl.stil4m.ideal.responses.Response;

public class FailedRequestException extends Throwable {

    private final Request request;
    private final Response response;

    public <T extends Response> FailedRequestException(Request<T> request, T response) {
        this.response = response;
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }
}

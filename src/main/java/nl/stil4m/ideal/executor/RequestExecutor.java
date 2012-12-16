package nl.stil4m.ideal.executor;

import nl.stil4m.ideal.exceptions.FailedRequestException;
import nl.stil4m.ideal.requests.Request;
import nl.stil4m.ideal.responses.Response;

public interface RequestExecutor {

    <T extends Response> T execute(Request<T> request) throws FailedRequestException;
}

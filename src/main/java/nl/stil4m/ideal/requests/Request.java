package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.Response;

import java.util.Map;

public abstract class Request<T extends Response> {

    private Class<T> responseClazz;

    protected Request(Class<T> responseClazz) {
        this.responseClazz = responseClazz;
    }

    public Class<T> getResponseClass() {
        return responseClazz;
    }

    public abstract Map<String, String> getData();

    public abstract String getPath();
}

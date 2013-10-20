package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.Response;

import java.util.HashMap;
import java.util.Map;

public abstract class IdealRequest<T extends Response> {

    private final Map<String, String> data;

    private Class<T> responseClazz;

    protected IdealRequest(Class<T> responseClazz, boolean testMode) {
        this.responseClazz = responseClazz;
        this.data = new HashMap<>();
        if (testMode) {
            this.data.put("testmode", "true");
        }
    }

    public final Map<String, String> getData() {
        return data;
    }

    public Class<T> getResponseClass() {
        return responseClazz;
    }

}
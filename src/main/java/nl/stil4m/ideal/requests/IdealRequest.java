package nl.stil4m.ideal.requests;

import com.google.common.collect.Maps;
import nl.stil4m.ideal.responses.Response;

import java.util.Map;

public abstract class IdealRequest<T extends Response> extends Request<T> {

    private boolean testMode;

    protected IdealRequest(Class<T> responseClazz) {
        super(responseClazz);
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = Maps.newHashMap();
        if (testMode) {
            data.put("testmode", "true");
        }
        return data;
    }
}
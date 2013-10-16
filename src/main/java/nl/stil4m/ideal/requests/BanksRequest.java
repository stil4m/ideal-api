package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.BanksResponse;

import java.util.HashMap;
import java.util.Map;

public class BanksRequest extends IdealRequest<BanksResponse> {

    private static final Map<String, String> defaultMap = new HashMap<String, String>();

    static {
        defaultMap.put("a", "banklist");
    }

    public BanksRequest(boolean testMode) {
        super(BanksResponse.class, testMode);
        getData().putAll(defaultMap);
    }
}

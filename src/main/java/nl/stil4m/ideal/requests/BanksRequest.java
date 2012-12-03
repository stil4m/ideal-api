package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.BanksResponse;

import java.util.Map;

public class BanksRequest extends IdealRequest<BanksResponse> {

    public BanksRequest() {
        super(BanksResponse.class);
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = super.getData();
        data.put("a", "banklist");
        return data;
    }

    @Override
    public String getPath() {
        return "/xml/ideal";
    }
}

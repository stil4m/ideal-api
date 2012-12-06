package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.domain.CheckResponse;

import java.util.Map;

public class CheckRequest extends IdealRequest<CheckResponse> {

    private final String partnerId;
    private final String transactionId;

    public CheckRequest(String partnerId, String transactionId) {
        super(CheckResponse.class);
        this.partnerId = partnerId;
        this.transactionId = transactionId;
    }

    @Override
    public String getPath() {
        return "/xml/ideal";
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = super.getData();
        data.put("a", "check");
        data.put("partnerid", partnerId);
        data.put("transaction_id", transactionId);
        return data;
    }
}

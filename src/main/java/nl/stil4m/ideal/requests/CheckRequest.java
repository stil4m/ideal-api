package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.CheckResponse;

import java.util.Map;

public class CheckRequest extends IdealRequest<CheckResponse> {

    public CheckRequest(String partnerId, String transactionId, Boolean testMode) {
        super(CheckResponse.class, testMode);
        Map<String, String> data = getData();
        data.put("a", "check");
        data.put("partnerid", partnerId);
        data.put("transaction_id", transactionId);
    }

}

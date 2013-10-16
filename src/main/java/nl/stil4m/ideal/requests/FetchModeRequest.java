package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.FetchModeResponse;

import java.util.Map;

public class FetchModeRequest extends IdealRequest<FetchModeResponse> {

    public FetchModeRequest(String partnerId, Integer amount, String bankId, String description, String reportUrl, String returnUrl, String profileKey) {
        super(FetchModeResponse.class, false);
        Map<String, String> data = getData();
        data.put("a", "fetch");
        data.put("partnerid", partnerId);
        data.put("amount", amount.toString());
        data.put("bank_id", bankId);
        data.put("description", description);
        data.put("reporturl", reportUrl);
        data.put("returnurl", returnUrl);

        if (profileKey != null) {
            data.put("profile_key", profileKey);
        }
    }
}

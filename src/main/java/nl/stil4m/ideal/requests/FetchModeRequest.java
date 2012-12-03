package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.FetchModeResponse;

import java.util.Map;

public class FetchModeRequest extends IdealRequest<FetchModeResponse> {

    private final String partnerId;
    private final Integer amount;
    private final String bankId;
    private final String description;
    private final String reportUrl;
    private final String returnUrl;
    private final String profileKey;

    public FetchModeRequest(String partnerId, Integer amount, String bankId, String description, String reportUrl, String returnUrl) {
        super(FetchModeResponse.class);
        this.partnerId = partnerId;
        this.amount = amount;
        this.bankId = bankId;
        this.description = description;
        this.reportUrl = reportUrl;
        this.returnUrl = returnUrl;
        this.profileKey = null;
    }

    protected FetchModeRequest(String partnerId, Integer amount, String bankId, String description, String reportUrl, String returnUrl, String profileKey) {
        super(FetchModeResponse.class);
        this.partnerId = partnerId;
        this.amount = amount;
        this.bankId = bankId;
        this.description = description;
        this.reportUrl = reportUrl;
        this.returnUrl = returnUrl;
        this.profileKey = profileKey;
    }




    @Override
    public String getPath() {
        return "/xml/ideal";
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = super.getData();
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
        return data;
    }
}

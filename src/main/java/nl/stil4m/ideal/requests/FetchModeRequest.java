// Copyright 2013 Mats Stijlaart
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.FetchModeResponse;

import java.util.Map;

public class FetchModeRequest extends IdealRequest<FetchModeResponse> {

    public FetchModeRequest(String partnerId, Integer amount, String currency, String bankId, String description, String reportUrl, String returnUrl, String profileKey) {
        super(FetchModeResponse.class, false);
        Map<String, String> data = getData();
        data.put("a", "fetch");
        data.put("partnerid", partnerId);
        data.put("amount", amount.toString());
        data.put("currency", currency);
        data.put("bank_id", bankId);
        data.put("description", description);
        data.put("reporturl", reportUrl);
        data.put("returnurl", returnUrl);

        if (profileKey != null) {
            data.put("profile_key", profileKey);
        }
    }
}

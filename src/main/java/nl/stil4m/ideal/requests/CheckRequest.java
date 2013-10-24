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

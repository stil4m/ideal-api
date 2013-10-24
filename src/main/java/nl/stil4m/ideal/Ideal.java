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

package nl.stil4m.ideal;

import nl.stil4m.ideal.domain.Bank;
import nl.stil4m.ideal.responses.BanksResponse;
import nl.stil4m.ideal.domain.CheckOrder;
import nl.stil4m.ideal.responses.CheckResponse;
import nl.stil4m.ideal.responses.FetchModeResponse;
import nl.stil4m.ideal.domain.Order;
import nl.stil4m.ideal.exceptions.FailedRequestException;
import nl.stil4m.ideal.executor.RequestExecutor;
import nl.stil4m.ideal.requests.BanksRequest;
import nl.stil4m.ideal.requests.CheckRequest;
import nl.stil4m.ideal.requests.FetchModeRequest;

import java.util.List;

public class Ideal {

    private final String partnerId;
    private final RequestExecutor requestExecutor;

    private boolean testMode = false;

    public Ideal(String partnerId, RequestExecutor requestExecutor) {
        this.partnerId = partnerId;
        this.requestExecutor = requestExecutor;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public List<Bank> getBanks() throws FailedRequestException {
        BanksRequest banksRequest = new BanksRequest(testMode);
        BanksResponse response = requestExecutor.execute(banksRequest);
        return response.getBanks();
    }

    public Order createPayment(Integer amount, String currency, String bankId, String description, String reportUrl, String returnUrl) throws FailedRequestException {
        FetchModeRequest fetchModeRequest = new FetchModeRequest(
                partnerId, amount, currency, bankId, description, reportUrl, returnUrl, null
        );

        FetchModeResponse response = requestExecutor.execute(fetchModeRequest);
        return response.getOrder();
    }

    public CheckOrder checkPayment(String transactionId) throws FailedRequestException {
        CheckRequest checkRequest = new CheckRequest(partnerId, transactionId, testMode);
        CheckResponse response = requestExecutor.execute(checkRequest);
        return response.getOrder();
    }
}

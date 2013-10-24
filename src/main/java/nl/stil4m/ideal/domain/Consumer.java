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

package nl.stil4m.ideal.domain;

import javax.xml.bind.annotation.XmlElement;

public class Consumer {

    private String consumerName;
    private String consumerAccount;
    private String consumerCity;

    public String getConsumerName() {
        return consumerName;
    }

    @XmlElement(name = "consumerName")
    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerAccount() {
        return consumerAccount;
    }

    @XmlElement(name = "consumerAccount")
    public void setConsumerAccount(String consumerAccount) {
        this.consumerAccount = consumerAccount;
    }

    public String getConsumerCity() {
        return consumerCity;
    }

    @XmlElement(name = "consumerCity")
    public void setConsumerCity(String consumerCity) {
        this.consumerCity = consumerCity;
    }
}

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

public class CheckOrder {
    private String transactionId;
    private Integer amount;
    private String currency;
    private Boolean payed;
    private String message;
    private Status status;
    private Consumer consumer;

    public String getTransactionId() {
        return transactionId;
    }

    @XmlElement(name = "transaction_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAmount() {
        return amount;
    }

    @XmlElement(name = "amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlElement(name = "currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getPayed() {
        return payed;
    }

    @XmlElement(name = "payed")
    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    public String getMessage() {
        return message;
    }

    @XmlElement(name = "message")
    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    @XmlElement(name = "status")
    public void setStatus(Status status) {
        this.status = status;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    @XmlElement(name = "consumer")
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}

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

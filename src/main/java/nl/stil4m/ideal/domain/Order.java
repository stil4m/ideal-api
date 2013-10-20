package nl.stil4m.ideal.domain;

import javax.xml.bind.annotation.XmlElement;

import java.net.URL;

public class Order {

    private String transactionId;
    private Integer amount;
    private String currency;
    private URL url;
    private String message;

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

    public URL getUrl() {
        return url;
    }

    @XmlElement(name = "URL")
    public void setUrl(URL url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    @XmlElement(name = "message")
    public void setMessage(String message) {
        this.message = message;
    }
}

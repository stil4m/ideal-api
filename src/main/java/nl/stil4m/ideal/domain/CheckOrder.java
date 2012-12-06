package nl.stil4m.ideal.domain;

import javax.xml.bind.annotation.XmlElement;

public class CheckOrder {
    private String transactionId;
    private Integer amount;
    private String currency;
    private Boolean payed;
    private String message;
    private String status;

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

    public String getStatus() {
        return status;
    }

    @XmlElement(name = "status")
    public void setStatus(String status) {
        this.status = status;
    }
}

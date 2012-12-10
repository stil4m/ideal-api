package nl.stil4m.ideal.domain;

import javax.xml.bind.annotation.XmlElement;

public class Bank {

    private String bankId;
    private String bankName;

    @XmlElement(name = "bank_id")
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @XmlElement(name = "bank_name")
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
    }
}

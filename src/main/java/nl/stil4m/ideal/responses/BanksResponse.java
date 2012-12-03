package nl.stil4m.ideal.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "response")
public class BanksResponse extends Response {

    private String message;
    private List<Bank> banks;

    public String getMessage() {
        return message;
    }

    @XmlElement
    public void setMessage(String message) {
        this.message = message;
    }

    @XmlElement(name = "bank")
    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public List<Bank> getBanks() {
        return banks;
    }
}

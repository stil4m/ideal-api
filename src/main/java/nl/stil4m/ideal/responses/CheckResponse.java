package nl.stil4m.ideal.responses;

import nl.stil4m.ideal.domain.CheckOrder;
import nl.stil4m.ideal.responses.Response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class CheckResponse extends Response {

    private CheckOrder order;

    public CheckOrder getOrder() {
        return order;
    }

    @XmlElement(name = "order")
    public void setOrder(CheckOrder order) {
        this.order = order;
    }

}

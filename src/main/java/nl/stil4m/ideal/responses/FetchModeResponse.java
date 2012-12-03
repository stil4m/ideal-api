package nl.stil4m.ideal.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class FetchModeResponse extends Response {

    private Order order;

    public Order getOrder() {
        return order;
    }

    @XmlElement(name = "order")
    public void setOrder(Order order) {
        this.order = order;
    }

}

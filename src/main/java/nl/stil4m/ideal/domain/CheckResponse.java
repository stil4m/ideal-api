package nl.stil4m.ideal.domain;

import nl.stil4m.ideal.responses.Response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class CheckResponse extends Response {

    private CheckOrder order;
    private Consumer consumer;

    public CheckOrder getOrder() {
        return order;
    }

    @XmlElement(name = "order")
    public void setOrder(CheckOrder order) {
        this.order = order;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    @XmlElement(name = "consumer")
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}

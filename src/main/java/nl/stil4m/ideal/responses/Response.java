package nl.stil4m.ideal.responses;

import nl.stil4m.ideal.domain.Item;

import javax.xml.bind.annotation.XmlElement;

public abstract class Response {

    private Item item;

    public Item getItem() {
        return item;
    }

    @XmlElement(name = "item")
    public void setItem(Item item) {
        this.item = item;
    }

    public boolean succeeded() {
        return item == null;
    }
}

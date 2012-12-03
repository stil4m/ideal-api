package nl.stil4m.ideal.responses;


import javax.xml.bind.annotation.XmlElement;

public class Item {

    private Integer errorCode;

    private String message;

    public Integer getErrorCode() {
        return errorCode;
    }

    @XmlElement(name = "errorcode")
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    @XmlElement(name = "message")
    public void setMessage(String message) {
        this.message = message;
    }
}

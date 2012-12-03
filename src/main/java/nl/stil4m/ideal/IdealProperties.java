package nl.stil4m.ideal;

import java.util.Properties;

public class IdealProperties extends Properties {

    public IdealProperties() {
        setProperty(IdealConstants.MOLLIE_IDEAL_SCHEME, "https");
        setProperty(IdealConstants.MOLLIE_IDEAL_URL, "secure.mollie.nl");
    }
}

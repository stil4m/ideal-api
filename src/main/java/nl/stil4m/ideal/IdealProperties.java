package nl.stil4m.ideal;

import java.util.Properties;

public class IdealProperties extends Properties {

    public static final String MOLLIE_IDEAL_SCHEME_KEY = "mollie.ideal.scheme";
    public static final String MOLLIE_IDEAL_URL_KEY = "mollie.ideal.url";

    public IdealProperties() {
        setProperty(MOLLIE_IDEAL_SCHEME_KEY, IdealConstants.MOLLIE_IDEAL_SCHEME);
        setProperty(MOLLIE_IDEAL_URL_KEY, IdealConstants.MOLLIE_IDEAL_URL);
    }
}

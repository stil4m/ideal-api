package nl.stil4m.ideal;

import java.util.Properties;

public class Ideal {

    private Properties properties;

    public Ideal() {
        this.properties = new IdealProperties();
    }

    public Ideal(Properties properties) {
        this.properties = properties;
    }

    public RequestExecutor createExecutor() {
        String scheme = properties.getProperty(IdealConstants.MOLLIE_IDEAL_SCHEME);
        String url = properties.getProperty(IdealConstants.MOLLIE_IDEAL_URL);
        return new RequestExecutor(scheme, url);
    }
}

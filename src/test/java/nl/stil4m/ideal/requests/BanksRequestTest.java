package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.BanksResponse;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BanksRequestTest {

    @Test
    public void testConstructionWithTestMode() {
        Map<String, String> expected = new HashMap<String, String>();
        expected.put("a", "banklist");
        expected.put("testMode", "true");

        BanksRequest banksRequest = new BanksRequest(true);
        assertThat(banksRequest.getData(), is(expected));
        assertThat(banksRequest.getResponseClass() == BanksResponse.class, is(true));
    }

    @Test
    public void testConstructionWithoutTestMode() {
        Map<String, String> expected = new HashMap<String, String>();
        expected.put("a", "banklist");

        BanksRequest banksRequest = new BanksRequest(false);
        assertThat(banksRequest.getData(), is(expected));
        assertThat(banksRequest.getResponseClass() == BanksResponse.class, is(true));
    }

}

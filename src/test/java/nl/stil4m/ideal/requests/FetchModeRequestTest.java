package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.FetchModeResponse;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FetchModeRequestTest {

    @Test
    public void testConstructionWithPartnerId() {
        Map<String, String> expected = new HashMap<String, String>();
        expected.put("a", "fetch");
        expected.put("partnerid", "pid");
        expected.put("amount", "123");
        expected.put("bank_id", "0999");
        expected.put("description", "desc");
        expected.put("reporturl", "rep");
        expected.put("returnurl", "ret");
        expected.put("profile_key", "prof");

        FetchModeRequest fetchModeRequest = new FetchModeRequest("pid", 123, "0999", "desc", "rep", "ret", "prof");
        assertThat(fetchModeRequest.getData(), is(expected));
        assertThat(fetchModeRequest.getResponseClass() == FetchModeResponse.class, is(true));
    }

    @Test
    public void testConstructionWithoutProfileKey() {
        Map<String, String> expected = new HashMap<String, String>();
        expected.put("a", "fetch");
        expected.put("partnerid", "pid");
        expected.put("amount", "123");
        expected.put("bank_id", "0999");
        expected.put("description", "desc");
        expected.put("reporturl", "rep");
        expected.put("returnurl", "ret");

        FetchModeRequest fetchModeRequest = new FetchModeRequest("pid", 123, "0999", "desc", "rep", "ret", null);
        assertThat(fetchModeRequest.getData(), is(expected));
        assertThat(fetchModeRequest.getResponseClass() == FetchModeResponse.class, is(true));
    }
}

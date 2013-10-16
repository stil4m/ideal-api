package nl.stil4m.ideal.requests;

import nl.stil4m.ideal.responses.BanksResponse;
import nl.stil4m.ideal.responses.CheckResponse;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckRequestTest {

    @Test
    public void testConstructionWithTestMode() {
        Map<String, String> expected = new HashMap<String, String>();
        expected.put("a", "check");
        expected.put("testMode", "true");
        expected.put("transactionId", "tid");
        expected.put("partnerId", "pid");

        CheckRequest checkRequest = new CheckRequest("pid", "tid", true);
        assertThat(checkRequest.getData(), is(expected));
        assertThat(checkRequest.getResponseClass() == CheckResponse.class, is(true));
    }

    @Test
    public void testConstructionWithoutTestMode() {
        Map<String, String> expected = new HashMap<String, String>();
        expected.put("a", "check");
        expected.put("transactionId", "tid");
        expected.put("partnerId", "pid");

        CheckRequest checkRequest = new CheckRequest("pid", "tid", false);
        assertThat(checkRequest.getData(), is(expected));
        assertThat(checkRequest.getResponseClass() == CheckResponse.class, is(true));
    }
}

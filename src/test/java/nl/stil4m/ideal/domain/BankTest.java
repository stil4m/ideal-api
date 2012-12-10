package nl.stil4m.ideal.domain;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {

    private Bank bank;

    @Before
    public void before() {
        bank = new Bank();
    }

    public void testId() {
        assertThat(bank.getBankId(), is(nullValue()));
        bank.setBankId("theId");
        assertThat(bank.getBankId(), is("theId"));
    }

    public void testName() {
        assertThat(bank.getBankName(), is(nullValue()));
        bank.setBankName("theName");
        assertThat(bank.getBankName(), is("theName"));
    }




}

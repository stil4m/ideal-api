package nl.stil4m.ideal.responses;

import com.google.common.collect.Lists;

import nl.stil4m.ideal.domain.Bank;
import nl.stil4m.ideal.domain.Item;
import nl.stil4m.ideal.responses.BanksResponse;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class BanksResponseTest {

    private BanksResponse banksResponse;

    @Before
    public void before() {
        banksResponse = new BanksResponse();
    }

    @Test
    public void testMessage() {
        assertThat(banksResponse.getMessage(), is(nullValue()));
        banksResponse.setMessage("message");
        assertThat(banksResponse.getMessage(), is("message"));
    }

    @Test
    public void testBanksList() {
        List<Bank> banks = Lists.newArrayList(mock(Bank.class), mock(Bank.class));
        assertThat(banksResponse.getBanks(), is(nullValue()));
        banksResponse.setBanks(banks);
        assertThat(banksResponse.getBanks(), is(banks));
    }

    @Test
    public void testItem() {
        Item item = mock(Item.class);
        assertThat(banksResponse.succeeded(), is(true));
        assertThat(banksResponse.getItem(), is(nullValue()));

        banksResponse.setItem(item);
        assertThat(banksResponse.succeeded(), is(false));
        assertThat(banksResponse.getItem(), is(item));
    }

}

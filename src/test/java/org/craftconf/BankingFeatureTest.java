package org.craftconf;

import static org.mockito.Mockito.inOrder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BankingFeatureTest {

    @Mock
    Console console;

    @Test
    public void statement_shows_account_history() {

        AccountService accountService = new AccountService();

        accountService.deposit(500);
        accountService.withdraw(250);

        accountService.printStatement();

        InOrder orderedConsole = inOrder(console);
        orderedConsole.verify(console).printLine("DATE | AMOUNT | BALANCE");
        orderedConsole.verify(console).printLine("27/04/2016 | -250.00 | 250.00");
        orderedConsole.verify(console).printLine("27/04/2016 | 500.00 | 500.00");

    }
}

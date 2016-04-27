package org.craftconf;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceShould {

    private static final int AMOUNT = 500;
    private static final String CURRENT_DATE = "27/04/2016";

    @Mock
    TransactionRepository transactionRepository;

    @Mock
    MyClock clock;

    @Test
    public void record_deposit_with_current_date() {

        Mockito.when(clock.getCurrentDate()).thenReturn(CURRENT_DATE);
        AccountService accountService = new AccountService(clock, transactionRepository);

        accountService.deposit(AMOUNT);


        Transaction transaction = new Transaction(CURRENT_DATE, AMOUNT);
        verify(transactionRepository).store(transaction);
    }

    @Test
    public void record_withdrawal_as_negative_with_current_date() {

        Mockito.when(clock.getCurrentDate()).thenReturn(CURRENT_DATE);
        AccountService accountService = new AccountService(clock, transactionRepository);

        accountService.withdraw(AMOUNT);

        Transaction transaction = new Transaction(CURRENT_DATE, -AMOUNT);
        verify(transactionRepository).store(transaction);

    }

    @Test
    public void print_empty_statement_with_empty_history() {

    }
}

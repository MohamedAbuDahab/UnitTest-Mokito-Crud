package org.example.account;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTestwithAssertThat {

    Customer customer = new Customer();
    AccountManager accountManager = new AccountManagerImpl();
    // deposit casses
    @Test
    public void testDeposite(){
        customer.setBalance(150);
        accountManager.deposit(customer, 50);
        // assertThat(customer.getBalance(), is(150)); 
        assertThat(customer.getBalance(), is(200));

    }

    @Test
    void givenAmountBelowMaxCreditForNormalCustomerWhenWithdrawThenSubtractFromBalance() {
        // Arrange
        customer.setBalance(100);
        // Act
        String result = accountManager.withdraw(customer, 50);
        // Assert
        int expectedBalance = customer.getBalance();
        assertThat(expectedBalance, is(50));
        assertThat(result, is("success"));
    }
    @Test
    void testWithdrawWithInSufficiantBalance(){
        // Arrange
        customer.setBalance(100);
        // Act
        String result = accountManager.withdraw(customer, 150);
        // Assert
        int expectedBalance = customer.getBalance();
        assertThat(expectedBalance, is(100));
        assertThat(result, is("insufficient account balance"));
    }
    @Test
    void testWithdrawWithCardAllowed(){
        // Arrange
        customer.setBalance(100);
        customer.setCreditAllowed(true);
        // Act
        String result = accountManager.withdraw(customer, 150);
        // Assert
        int expectedBalance = customer.getBalance();
        assertThat(expectedBalance, is(-50));
        assertThat(result, is("success"));
    }
}

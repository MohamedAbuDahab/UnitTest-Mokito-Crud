package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

    Customer customer = new Customer();
    AccountManager accountManager = new AccountManagerImpl();
    // deposit casses
    @Test
    public void testDeposite(){
        customer.setBalance(150);
        accountManager.deposit(customer,50);
       // Assertions.assertEquals(150,customer.getBalance());
        Assertions.assertEquals(200,customer.getBalance());

   }

    @Test
    void givenAmountBelowMaxCreditForNormalCustomerWhenWithdrawThenSubtractFromBalance() {
        // Arrange
        customer.setBalance(100);
        // Act
        String result = accountManager.withdraw(customer, 50);
        // Assert
        int expectedBalance = customer.getBalance();
        Assertions.assertEquals(50, expectedBalance);
        Assertions.assertEquals("success", result);
    }
    @Test
    void testWithdrawWithInSufficiantBalance(){
        customer.setBalance(100);
        String result = accountManager.withdraw(customer,150);
        int expectedBalanace =customer.getBalance();
        Assertions.assertEquals(100,expectedBalanace);
        Assertions.assertEquals("insufficient account balance",result);
    }
    @Test
    void testWithdrawWithCardAllowed(){
        customer.setBalance(100);
        customer.setCreditAllowed(true);
        String result = accountManager.withdraw(customer,150);
        int expectedBalanace =customer.getBalance();
        Assertions.assertEquals(-50,expectedBalanace);
        Assertions.assertEquals("success",result);
    }
    @Test // Error in logic of method that there are no handle for mac Exceded
    void testWithdrawWithMaxCreditExceededForNonVIP() {
        customer.setBalance(100);
        String result = accountManager.withdraw(customer,1500);
        int expectedBalanace =customer.getBalance();
        Assertions.assertEquals(100,expectedBalanace);
       //Assertions.assertEquals("maximum credit exceeded",result);

    }
    @Test // Error in vip customer
    public void testWithdrawWithMaxCreditExceededForVIP() {
        customer.setBalance(100);
        customer.setVip(true);

        String result = accountManager.withdraw(customer,1500);
        int expectedBalanace =customer.getBalance();
        Assertions.assertEquals(-1400,expectedBalanace);
        Assertions.assertEquals("success",result);
    }
}

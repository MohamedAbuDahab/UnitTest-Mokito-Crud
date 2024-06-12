package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class StoreMockitoTest {

    Store store;

    Product product = new Product();
    Customer customer = new Customer();


    @Test void test1() {
        // Arrange
        product.setQuantity(8);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        store = new StoreImpl(accountManager);

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(7, product.getQuantity());
    }
    @Test
    void giveProdtWithQZero_whenBuyIt_thenThrowsException() {
        // Arr
        product.setQuantity(0);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        store = new StoreImpl(accountManager);
//    Act
        RuntimeException ex = Assertions.assertThrows(RuntimeException.class,
                () -> store.buy(product, customer));
        //Ass
        Assertions.assertEquals("Product out of stock", ex.getMessage());
    }

    @Test
    void givenProduct_whenBuyWithdrawhasLessBalance_thenThrowsException() {

        product.setQuantity(8);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(any(),anyInt())).thenReturn("insufficient account balance");

        store = new StoreImpl(accountManager);

        RuntimeException ex = Assertions.assertThrows(RuntimeException.class,()->store.buy(product, customer));
        Assertions.assertEquals("Payment failure: insufficient account balance", ex.getMessage());

    }

    @Test
    void givenProduct_whenBuyMaxExceded_thenThrowsException() {

        product.setQuantity(10);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(any(),anyInt())).thenReturn("maximum credit exceeded");

        store = new StoreImpl(accountManager);

        RuntimeException ex = Assertions.assertThrows(RuntimeException.class,()->store.buy(product, customer));
        Assertions.assertEquals("Payment failure: maximum credit exceeded", ex.getMessage());

    }
}

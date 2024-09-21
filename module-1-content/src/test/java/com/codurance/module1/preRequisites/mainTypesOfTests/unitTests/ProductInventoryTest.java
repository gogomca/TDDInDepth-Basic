package com.codurance.module1.preRequisites.mainTypesOfTests.unitTests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is not using neither test doubles nor mocking libraries.
 * To perform checking process it is using a method (checkStock) of the SUT.
 */
class ProductInventoryTest {

    @Test
    void shouldAddProductsToStockSuccessfully() {
        // GIVEN
        var productId = "PR1";
        var quantity = 1500;
        var productInventory = new ProductInventory();

        // WHEN
        productInventory.addStock(productId, quantity);

        // THEN
        assertEquals(quantity, productInventory.checkStock(productId));
    }

    @Test
    void shouldAvoidRemovingStockBecauseNotEnoughProductQuantity() {
        // GIVEN
        var productId = "PR1";
        var initialQuantity = 1500;
        var removingQuantity = 2000;

        var productInventory = new ProductInventory();
        productInventory.addStock(productId, initialQuantity);

        var expectedErrorMessage ="Not enough stock available for " + productId;

        // WHEN
        var thrownException = assertThrows(IllegalArgumentException.class, () -> productInventory.removeStock(productId, removingQuantity));

        // THEN
        assertEquals(expectedErrorMessage, thrownException.getMessage());
    }

    @Test
    void shouldRemoveStockSuccessfully(){
        // GIVEN
        var productId = "PR1";
        var initialQuantity = 1500;
        var removingQuantity = 500;
        var expectedQuantity = 1000;

        var productInventory = new ProductInventory();
        productInventory.addStock(productId, initialQuantity);

        // WHEN
        productInventory.removeStock(productId, removingQuantity);

        // THEN
        assertEquals(expectedQuantity, productInventory.checkStock(productId));
    }

    @Test
    void checkStock() {
        // This method is used to check the other methods of the SUT.
        // Therefore, it is also tested indirectly.
    }
}
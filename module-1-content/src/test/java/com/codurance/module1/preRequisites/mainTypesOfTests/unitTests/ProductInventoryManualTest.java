package com.codurance.module1.preRequisites.mainTypesOfTests.unitTests;

class ProductInventoryManualTest {
    final static String productId = "PR1";
    final static ProductInventory productInventory = new ProductInventory();

    public static void main(String[] args) {
        // Check that the product stock is zero (no product stock has been generated).
        shouldGenerateProductInventoryWithoutAnyProductStock();

        // Check that adding product stock is successfully performed.
        shouldAddProductsToStockSuccessfully();

        // Check that trying to remove stock when not enough one throws an exception (IllegalArgumentException).
        shouldAvoidRemovingStockBecauseNotEnoughProductQuantity();

        // Check that the product stock has been updated according to the removed stock.
        shouldRemoveStockSuccessfully();
    }

    private static void shouldGenerateProductInventoryWithoutAnyProductStock() {
        // GIVEN
        int defaultUnits = 0;
        int exitStatus = 1;

        //WHEN
        if(defaultUnits != productInventory.checkStock(productId)){
            System.out.println("shouldGenerateProductInventoryWithoutAnyProductStock: KO");
            System.exit(exitStatus);
        }

        // THEN
        System.out.println("shouldGenerateProductInventoryWithoutAnyProductStock: OK");
    }

    private static void shouldAddProductsToStockSuccessfully() {
        // GIVEN
        int productQuantity = 1000;
        int expectedQuantity = 1000;
        int exitStatus = 2;

        // WHEN
        productInventory.addStock(productId, productQuantity);

        // THEN
        if(expectedQuantity != productInventory.checkStock(productId)){
            System.out.println("shouldAddProductsToStockSuccessfully: KO");
            System.exit(exitStatus);
        }

        System.out.println("shouldAddProductsToStockSuccessfully: OK");
    }

    private static void shouldAvoidRemovingStockBecauseNotEnoughProductQuantity() {
        // GIVEN
        int removingQuantity = 1500;
        var expectedErrorMessage ="Not enough stock available for " + productId;
        int exitStatus = 3;

        // WHEN
        try {
            productInventory.removeStock(productId, removingQuantity);

            // THEN
            System.out.println("shouldAvoidRemovingStockBecauseNotEnoughProductQuantity: KO");
            System.exit(exitStatus);
        } catch (IllegalArgumentException e) {
            if(!expectedErrorMessage.equals(e.getMessage())){
                System.out.println("shouldAvoidRemovingStockBecauseNotEnoughProductQuantity: KO");
                System.exit(exitStatus);
            }
        } catch (Exception e) {
            System.out.println("shouldAvoidRemovingStockBecauseNotEnoughProductQuantity: KO");
            System.exit(exitStatus);
        }

        System.out.println("shouldAvoidRemovingStockBecauseNotEnoughProductQuantity: OK");
    }

    private static void shouldRemoveStockSuccessfully(){
        // GIVEN
        var productId = "PR1";
        var removingQuantity = 750;
        var expectedQuantity = 250;
        int exitStatus = 4;

        // WHEN
        productInventory.removeStock(productId, removingQuantity);

        // THEN
        if(expectedQuantity != productInventory.checkStock(productId)){
            System.out.println("shouldAddProductsToStockSuccessfully: KO");
            System.exit(exitStatus);
        }

        System.out.println("shouldAddProductsToStockSuccessfully: OK");
    }

}
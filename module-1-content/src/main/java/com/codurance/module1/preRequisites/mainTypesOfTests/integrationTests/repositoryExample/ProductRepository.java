package com.codurance.module1.preRequisites.mainTypesOfTests.integrationTests.repositoryExample;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    void create(Product product);
    Optional<Product> findById(UUID id);
}

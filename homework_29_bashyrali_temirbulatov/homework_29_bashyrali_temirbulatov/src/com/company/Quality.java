package com.company;

import java.util.Objects;

abstract class Quality {
    ProductEnum productEnum;

    public ProductEnum getProductEnum() {
        return productEnum;
    }

    abstract void degradeQality(Product product);



}

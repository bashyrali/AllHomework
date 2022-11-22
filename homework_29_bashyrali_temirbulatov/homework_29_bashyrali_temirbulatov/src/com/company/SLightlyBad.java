package com.company;

public class SLightlyBad extends Quality {
    public SLightlyBad(){
        this.productEnum = ProductEnum.SLIGHTLYBAD;
    }

    @Override
    void degradeQality(Product product) {
        product.setQuality(new HalfBad());
    }
}

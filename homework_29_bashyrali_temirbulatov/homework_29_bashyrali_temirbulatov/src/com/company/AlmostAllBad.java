package com.company;

public class AlmostAllBad extends Quality{
    public AlmostAllBad(){
        this.productEnum = ProductEnum.ALMOSTALLBAD;
    }

    @Override
    void degradeQality(Product product) {
        product.setQuality(new AllBad());
    }
}

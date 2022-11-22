package com.company;

public class HalfBad extends Quality{
    public HalfBad(){
        this.productEnum = ProductEnum.HALFBAD;
    }

    @Override
    void degradeQality(Product product) {
        product.setQuality(new AlmostAllBad());
    }
}

package com.company;

public class Normal extends Quality{
    public Normal(){
        this.productEnum=ProductEnum.NORMAL;
    }

    @Override
    void degradeQality(Product product) {
        product.setQuality(new SLightlyBad());
    }
}

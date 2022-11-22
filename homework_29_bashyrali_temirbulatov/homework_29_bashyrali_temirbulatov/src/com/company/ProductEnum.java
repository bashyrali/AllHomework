package com.company;

public enum ProductEnum {
    NORMAL(1.2),
    SLIGHTLYBAD(0.95),
    HALFBAD(0.55),
    ALMOSTALLBAD(0.25),
    ALLBAD(0.1);

    private Double quality;

    ProductEnum(Double quality) {
        this.quality = quality;
    }

    public Double getQuality() {
        return quality;
    }
}

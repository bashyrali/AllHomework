package com.company;

public enum City {
    ALMATY,
    ASTANA,
    EKIBASTUZ,
    PAVLODAR,
    URALSK,
    SEMEY;
    int cityRoad;

    public void setCityRoad(int cityRoad) {
        this.cityRoad = cityRoad;
    }

    public int getCityRoad() {
        return cityRoad;
    }
}

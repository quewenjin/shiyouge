package com.example.shiyouge.bean;

public class Dormitory {
    private int dormitoryId;//宿舍ID
    private int numberOfMate;//宿舍人数
    private int flowerGrowthValue;//花的成长值
    private int flowerWateringTimes;//浇水总次数
    private int flowerFertilizationTimes;//施肥总次数
    private int soilMoisture;//土壤湿度(今日浇水次数)
    private int soilFertility;//土壤肥度（今日施肥次数）
    private String joinPassward;//加入宿舍密码

    public int getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(int dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public int getNumberOfMate() {
        return numberOfMate;
    }

    public void setNumberOfMate(int numberOfMate) {
        this.numberOfMate = numberOfMate;
    }

    public int getFlowerGrowthValue() {
        return flowerGrowthValue;
    }

    public void setFlowerGrowthValue(int flowerGrowthValue) {
        this.flowerGrowthValue = flowerGrowthValue;
    }

    public int getFlowerWateringTimes() {
        return flowerWateringTimes;
    }

    public void setFlowerWateringTimes(int flowerWateringTimes) {
        this.flowerWateringTimes = flowerWateringTimes;
    }

    public int getFlowerFertilizationTimes() {
        return flowerFertilizationTimes;
    }

    public void setFlowerFertilizationTimes(int flowerFertilizationTimes) {
        this.flowerFertilizationTimes = flowerFertilizationTimes;
    }

    public int getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(int soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public int getSoilFertility() {
        return soilFertility;
    }

    public void setSoilFertility(int soilFertility) {
        this.soilFertility = soilFertility;
    }

    public String getJoinPassward() {
        return joinPassward;
    }

    public void setJoinPassward(String joinPassward) {
        this.joinPassward = joinPassward;
    }
}

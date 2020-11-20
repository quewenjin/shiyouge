package com.example.shiyouge.bean;

public class Report {
    private int postIdOfReport;//对应的帖子ID
    private int vulgar;//色情低俗
    private int sensitivity;//政治敏感
    private int illegal;//违法
    private int advertisement;//广告
    private int virus;//病毒木马
    private int others;//其他

    public int getPostIdOfReport() {
        return postIdOfReport;
    }

    public void setPostIdOfReport(int postIdOfReport) {
        this.postIdOfReport = postIdOfReport;
    }

    public int getVulgar() {
        return vulgar;
    }

    public void setVulgar(int vulgar) {
        this.vulgar = vulgar;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(int sensitivity) {
        this.sensitivity = sensitivity;
    }

    public int getIllegal() {
        return illegal;
    }

    public void setIllegal(int illegal) {
        this.illegal = illegal;
    }

    public int getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(int advertisement) {
        this.advertisement = advertisement;
    }

    public int getVirus() {
        return virus;
    }

    public void setVirus(int virus) {
        this.virus = virus;
    }

    public int getOthers() {
        return others;
    }

    public void setOthers(int others) {
        this.others = others;
    }
}

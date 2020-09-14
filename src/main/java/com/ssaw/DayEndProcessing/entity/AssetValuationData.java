package com.ssaw.DayEndProcessing.entity;

/**
 *@program: FA
 *@description: 资产估值前端显示页面
 *@author: 瞿平
 *@create: 2020-09-13 18:29
 **/
public class AssetValuationData {
    private Integer assetValuationId; //估值编号
    private String assetValuationType; // 估值类型
    private String state; //估值类型
    private boolean checked;

    public AssetValuationData() {
    }

    public AssetValuationData(Integer assetValuationId, String assetValuationType, String state, boolean checked) {
        this.assetValuationId = assetValuationId;
        this.assetValuationType = assetValuationType;
        this.state = state;
        this.checked = checked;
    }

    public Integer getAssetValuationId() {
        return assetValuationId;
    }

    public void setAssetValuationId(Integer assetValuationId) {
        this.assetValuationId = assetValuationId;
    }

    public String getAssetValuationType() {
        return assetValuationType;
    }

    public void setAssetValuationType(String assetValuationType) {
        this.assetValuationType = assetValuationType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "AssetValuationData{" +
                "assetValuationId=" + assetValuationId +
                ", assetValuationType='" + assetValuationType + '\'' +
                ", state='" + state + '\'' +
                ", checked=" + checked +
                '}';
    }
}

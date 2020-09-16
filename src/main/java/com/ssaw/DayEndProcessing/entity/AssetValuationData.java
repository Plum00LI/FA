package com.ssaw.DayEndProcessing.entity;

/**
 *@program: FA
 *@description: 资产估值前端显示页面
 *@author: 瞿平
 *@create: 2020-09-13 18:29
 **/
public class AssetValuationData {
    private String assetValuationType; // 估值类型
    private String state; //状态

    public AssetValuationData() {
    }

    public AssetValuationData( String assetValuationType, String state) {
        this.assetValuationType = assetValuationType;
        this.state = state;

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



    @Override
    public String toString() {
        return "AssetValuationData{" +
                ", assetValuationType='" + assetValuationType + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

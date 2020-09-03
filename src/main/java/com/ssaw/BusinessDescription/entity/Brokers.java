package com.ssaw.BusinessDescription.entity;

/**
 * @program:TescComment 券商信息表brokers
 * @Description:实体类
 * @author:邓玺中
 * @create:2020-09-01
 */
public class Brokers {
    private String brokersId; //券商编号
    private String brokersName; //券商名称
    private String brokersInstructions; //说明
    private String desc; //备注

    public Brokers() {
    }

    public Brokers(String brokersId, String brokersName, String brokersInstructions, String desc) {
        this.brokersId = brokersId;
        this.brokersName = brokersName;
        this.brokersInstructions = brokersInstructions;
        this.desc = desc;
    }

    public String getBrokersId() {
        return brokersId;
    }

    public void setBrokersId(String brokersId) {
        this.brokersId = brokersId;
    }

    public String getBrokersName() {
        return brokersName;
    }

    public void setBrokersName(String brokersName) {
        this.brokersName = brokersName;
    }

    public String getBrokersInstructions() {
        return brokersInstructions;
    }

    public void setBrokersInstructions(String brokersInstructions) {
        this.brokersInstructions = brokersInstructions;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Brokers{" +
                "brokersId='" + brokersId + '\'' +
                ", brokersName='" + brokersName + '\'' +
                ", brokersInstructions='" + brokersInstructions + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

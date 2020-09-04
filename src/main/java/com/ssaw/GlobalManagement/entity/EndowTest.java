package com.ssaw.GlobalManagement.entity;

import java.util.List;

/**
 * create by: 佘高鹏
 * description: TODO
 * 权限模块加载测试实体类
 * create time: 2020/9/4 17:01
 * version number 1.0
  * @Param: null
 * @return
 */

/**
 *     功能ID  主键  int    funId;
 *     功能名       String  funName;
 *     引用地址     String  href;
 *     图片        String  image;
 *     图标        String  icon;
 *     打开方式     String  target;
 *     角色ID      int     roldId;
 *     子功能集合   List<EndowTest> child=null;
 */
public class EndowTest {
    private  int    funId;
    private String  funName;
    private String  href;
    private String  image;
    private String  icon;
    private String  target;
    private int     roldId;
    private List<EndowTest> child=null;

    public EndowTest(int funId, String funName, String href, String image, String icon, String target, int roldId, List<EndowTest> child) {
        this.funId = funId;
        this.funName = funName;
        this.href = href;
        this.image = image;
        this.icon = icon;
        this.target = target;
        this.roldId = roldId;
        this.child = child;
    }

    public EndowTest() {
    }

    public EndowTest(int funId, String funName, String href, String image, String icon, String target, int roldId) {
        this.funId = funId;
        this.funName = funName;
        this.href = href;
        this.image = image;
        this.icon = icon;
        this.target = target;
        this.roldId = roldId;
    }

    public EndowTest(int funId, String funName, String href, String image, String icon, String target) {
        this.funId = funId;
        this.funName = funName;
        this.href = href;
        this.image = image;
        this.icon = icon;
        this.target = target;
    }

    public EndowTest(int funId, String funName, String href, String image, String icon, String target, List<EndowTest> child) {
        this.funId = funId;
        this.funName = funName;
        this.href = href;
        this.image = image;
        this.icon = icon;
        this.target = target;
        this.child = child;
    }

    public int getFunId() {
        return funId;
    }

    public void setFunId(int funId) {
        this.funId = funId;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getRoldId() {
        return roldId;
    }

    public void setRoldId(int roldId) {
        this.roldId = roldId;
    }

    public List<EndowTest> getChild() {
        return child;
    }

    public void setChild(List<EndowTest> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "EndowTest{" +
                "funId=" + funId +
                ", funName='" + funName + '\'' +
                ", href='" + href + '\'' +
                ", image='" + image + '\'' +
                ", icon='" + icon + '\'' +
                ", target='" + target + '\'' +
                ", roldId=" + roldId +
                ", child=" + child +
                '}';
    }
}

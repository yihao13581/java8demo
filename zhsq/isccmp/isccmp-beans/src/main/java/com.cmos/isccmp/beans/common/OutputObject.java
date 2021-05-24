package com.cmos.isccmp.beans.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputObject implements Serializable {
    private static final long serializableUID=22222222222222L;
    private String returnCode;
    private String returnMessage;
    private String timeStamp;//时间戳防止加密内容一致
    private Map<String ,String> bean;
    private Map<String ,Object> images;

    private Map<String,Object> ext1;
    private List<Map<String,String>> beans;
    private List<Map<String,Object>> ext2;

    public OutputObject(String returnCode,String returnMessage){
        this.bean=new HashMap<String, String>();
        this.returnCode=returnCode;
        this.returnMessage=returnMessage;
        this.timeStamp=String.valueOf(System.currentTimeMillis());

    }
    public OutputObject(){};

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Map<String, String> getBean() {
        return bean;
    }

    public void setBean(Map<String, String> bean) {
        this.bean = bean;
    }

    public Map<String, Object> getImages() {
        return images;
    }

    public void setImages(Map<String, Object> images) {
        this.images = images;
    }

    public Map<String, Object> getExt1() {
        return ext1;
    }

    public void setExt1(Map<String, Object> ext1) {
        this.ext1 = ext1;
    }

    public List<Map<String, String>> getBeans() {
        return beans;
    }

    public void setBeans(List<Map<String, String>> beans) {
        this.beans = beans;
    }

    public List<Map<String, Object>> getExt2() {
        return ext2;
    }

    public void setExt2(List<Map<String, Object>> ext2) {
        this.ext2 = ext2;
    }
}

package com.it.java8demo.util.utils.consts;

public class FileUpDownConstants {
    public static final String ONEST_URL_PREFIX="oNEST";//onest上传下载 url固定前缀

    /**
     * 图片后缀
     */
    public enum IMAGE_SUFFIX{
        PNG(".png"),JPG(".jpg"),JPEG(".jpeg");
        String suffix;
        public String getSuffix(){return suffix;}
        public void setSuffix(String suffix){
            this.suffix=suffix;
        }
        private IMAGE_SUFFIX(String suffix){
            this.suffix=suffix;
        }

    }
}

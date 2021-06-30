package com.uestc.myapplication.bean;

public class HomeArticleBean {

    private ArticleData data;
    private int resultCode;
    private String resultMsg;

    public ArticleData getData() {
        return data;
    }

    public void setData(ArticleData data) {
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }


    public static class ArticleData{
        public ArticleData(String testString) {
            this.testString = testString;
        }

        private String testString;

        public String getTestString() {
            return testString;
        }

        public void setTestString(String testString) {
            this.testString = testString;
        }
    }
}

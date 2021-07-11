package com.uestc.myapplication.bean;

import java.util.List;

public class HomeDetailCommentBean {

    private List<CommentData> data;
    private int errorCode;
    private String errorMsg;

    public List<CommentData> getData() {
        return data;
    }

    public void setData(List<CommentData> data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class CommentData {
        private int id;
        private String created_at;
        private String text;
        private UserBean user;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * "user": {
             * "id": 87654321,
             * "screen_name": "搞笑大奇葩",
             * "profile_image_url": "http://XXX.XXX.XXX"
             * }
             */

            private int userid;
            private String screen_name;
            private String profile_image_url;

            public int getUserid() {
                return userid;
            }

            public void setUserid(int userid) {
                this.userid = userid;
            }

            public String getScreen_name() {
                return screen_name;
            }

            public void setScreen_name(String screen_name) {
                this.screen_name = screen_name;
            }

            public String getProfile_image_url() {
                return profile_image_url;
            }

            public void setProfile_image_url(String profile_image_url) {
                this.profile_image_url = profile_image_url;
            }
        }
    }

}

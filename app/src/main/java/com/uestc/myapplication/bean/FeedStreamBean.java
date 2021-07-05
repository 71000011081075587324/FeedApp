package com.uestc.myapplication.bean;

public class FeedStreamBean {

    private ArticleData data;
    private int errorCode;
    private String errorMsg;

    public ArticleData getData() {
        return data;
    }

    public void setData(ArticleData data) {
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


    public static class ArticleData{

        private int id;
        private String created_at;
        private String text;
        private String source;
        private boolean favorited;
        private int comments_count;
        private int like_count;
        private String thumbnail_pic;
        private String original_pic;
        private Object pic_ids;
        private String video;
        private UserBean userData;

        public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        public String getCreated_at () {
            return created_at;
        }

        public void setCreated_at (String created_at){
            this.created_at = created_at;
        }

        public String getText () {
            return text;
        }

        public void setText (String text){
            this.text = text;
        }

        public String getSource () {
            return source;
        }

        public void setSource (String source){
            this.source = source;
        }

        public boolean isFavorited () {
            return favorited;
        }

        public void setFavorited ( boolean favorited){
            this.favorited = favorited;
        }

        public int getComments_count () {
            return comments_count;
        }

        public void setComments_count ( int comments_count){
            this.comments_count = comments_count;
        }

        public int getLike_count () {
            return like_count;
        }

        public void setLike_count ( int like_count){
            this.like_count = like_count;
        }

        public String getThumbnail_pic () {
            return thumbnail_pic;
        }

        public void setThumbnail_pic (String thumbnail_pic){
            this.thumbnail_pic = thumbnail_pic;
        }

        public String getOriginal_pic () {
            return original_pic;
        }

        public void setOriginal_pic (String original_pic){
            this.original_pic = original_pic;
        }

        public Object getPic_ids () {
            return pic_ids;
        }

        public void setPic_ids (Object pic_ids){
            this.pic_ids = pic_ids;
        }

        public String getVideo () {
            return video;
        }

        public void setVideo (String video){
            this.video = video;
        }

        public Object  getUserData() {
            return userData;
        }

        public void setUserData(UserBean userData){
            this.userData = userData;
        }


        /**
         * "user": {
         * "id": 87654321,
         * "screen_name": "搞笑大奇葩",
         * "profile_image_url": "http://XXX.XXX.XXX",
         * "friended": false
         * }
         */
        public static class UserBean {

            private int user_id;
            private String screen_name;
            private String profile_image_url;
            private boolean friended;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
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

            public boolean isFriended() {
                return friended;
            }

            public void setFriended(boolean friended) {
                this.friended = friended;
            }
        }

    }
}

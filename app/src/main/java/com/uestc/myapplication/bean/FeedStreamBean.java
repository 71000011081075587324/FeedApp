package com.uestc.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class FeedStreamBean implements Parcelable {


    private List<ArticleData> datas;
    private int errorCode;
    private String errorMsg;

    protected FeedStreamBean(Parcel in) {
        datas = in.createTypedArrayList(ArticleData.CREATOR);
        errorCode = in.readInt();
        errorMsg = in.readString();
    }


    public static final Creator<FeedStreamBean> CREATOR = new Creator<FeedStreamBean>() {
        @Override
        public FeedStreamBean createFromParcel(Parcel in) {
            return new FeedStreamBean(in);
        }

        @Override
        public FeedStreamBean[] newArray(int size) {
            return new FeedStreamBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(datas);
        dest.writeInt(errorCode);
        dest.writeString(errorMsg);
    }


    public List<ArticleData> getDatas() {
        return datas;
    }

    public void setDatas(List<ArticleData> datas) {
        this.datas = datas;
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



    public static class ArticleData implements Parcelable{

        private int id;
        private String created_at;
        private String text;
        private String source;
        private boolean favorited;
        private int comments_count;
        private int like_count;
        private String thumbnail_pic;
//        private String original_pic;
        private String pic_ids;
        private String video;
        private UserBean user;


        protected ArticleData(Parcel in) {
            id = in.readInt();
            created_at = in.readString();
            text = in.readString();
            source = in.readString();
            favorited = in.readByte() != 0;
            comments_count = in.readInt();
            like_count = in.readInt();
            thumbnail_pic = in.readString();
            pic_ids = in.readString();
            video = in.readString();
            user = in.readParcelable(UserBean.class.getClassLoader());
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(created_at);
            dest.writeString(text);
            dest.writeString(source);
            dest.writeByte((byte) (favorited ? 1 : 0));
            dest.writeInt(comments_count);
            dest.writeInt(like_count);
            dest.writeString(thumbnail_pic);
            dest.writeString(pic_ids);
            dest.writeString(video);
            dest.writeParcelable(user, flags);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<ArticleData> CREATOR = new Creator<ArticleData>() {
            @Override
            public ArticleData createFromParcel(Parcel in) {
                return new ArticleData(in);
            }

            @Override
            public ArticleData[] newArray(int size) {
                return new ArticleData[size];
            }
        };

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

//        public String getOriginal_pic () {
//            return original_pic;
//        }
//
//        public void setOriginal_pic (String original_pic){
//            this.original_pic = original_pic;
//        }

        public String getPic_ids () {
            return pic_ids;
        }

        public void setPic_ids (String pic_ids){
            this.pic_ids = pic_ids;
        }

        public String getVideo () {
            return video;
        }

        public void setVideo (String video){
            this.video = video;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user){
            this.user = user;
        }


        /**
         * "user": {
         * "id": 87654321,
         * "screen_name": "搞笑大奇葩",
         * "profile_image_url": "http://XXX.XXX.XXX",
         * "friended": false
         * }
         */
        public static class UserBean implements Parcelable{

            private int user_id;
            private String screen_name;
            private String profile_image_url;
            private boolean friended;

            protected UserBean(Parcel in) {
                user_id = in.readInt();
                screen_name = in.readString();
                profile_image_url = in.readString();
                friended = in.readByte() != 0;
            }

            public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
                @Override
                public UserBean createFromParcel(Parcel in) {
                    return new UserBean(in);
                }

                @Override
                public UserBean[] newArray(int size) {
                    return new UserBean[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(user_id);
                dest.writeString(screen_name);
                dest.writeString(profile_image_url);
                dest.writeByte((byte) (friended ? 1 : 0));
            }

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

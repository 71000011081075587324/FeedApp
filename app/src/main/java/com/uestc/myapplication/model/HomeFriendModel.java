package com.uestc.myapplication.model;

import android.util.Log;

import com.google.gson.Gson;
import com.uestc.myapplication.bean.FeedStreamBean;
import com.uestc.myapplication.contract.Home.HomeFriendContract;

import java.util.ArrayList;
import java.util.List;

public class HomeFriendModel implements HomeFriendContract.IHomeModel {


    private static HomeFriendModel sHomeFriendModel = null;
    private Gson mGson;
    private String mString = "{\n" +
            "    \"datas\": [\n" +
            "        {\n" +
            "            \"id\": 0,  \n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"学校在2021年“平安成电”建设安全教育月中，持续开展以“预防电信诈骗，共建无诈校园”为主题的各类活动，在全校营造了防范电信网络诈骗的良好氛围，使得全校师生的防诈识诈能力得到有效提升。为巩固成绩，由学校保卫处、四川省公安厅反诈中心、成都市公安局高新分局反诈中心、成都市公安局高新分局合作派出所、中国移动高新西区分公司联合举办的防范电信网络诈骗专题讲座和线上有奖问答活动，将于6月3日下午4:20在双校区同步举办，活动将宣告“安全教育月”的完美落幕！此次活动奖品丰厚，欢迎全体学生报名参加。\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\", \n" +
            "            \"pic_ids\": \"0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 10,\n" +
            "                \"screen_name\": \"搞笑大奇葩\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_0\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"参加活动的本科学生还将获得安全教育实践类学分0.2分\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 13,\n" +
            "            \"like_count\": 56,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\", \n" +
            "            \"pic_ids\": \"0,0,0,0,0,0,0,0,0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 11,\n" +
            "                \"screen_name\": \"学生活动中心\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_1\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"前段时间的讲座大家都参加了吗？那些防不胜防的骗局你是否都已知晓？新一期“预防电信诈骗，共建无诈校园”讲座又来了，快来报名参加吧！\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\", \n" +
            "            \"pic_ids\": \"0,0,0,0,0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 12,\n" +
            "                \"screen_name\": \"知识大百科\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_2\",\n" +
            "                \"friended\": true\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 3,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"所有课程均由同学们在教务系统里自主选择（仅“毕业设计”无需选课）。\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\", \n" +
            "            \"pic_ids\": \"0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 13,\n" +
            "                \"screen_name\": \"教务处\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_3\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        },\n" +
            "        \n" +
            "        {\n" +
            "            \"id\": 0,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"学校在2021年“平安成电”建设安全教育月中，持续开展以“预防电信诈骗，共建无诈校园”为主题的各类活动，在全校营造了防范电信网络诈骗的良好氛围，使得全校师生的防诈识诈能力得到有效提升。为巩固成绩，由学校保卫处、四川省公安厅反诈中心、成都市公安局高新分局反诈中心、成都市公安局高新分局合作派出所、中国移动高新西区分公司联合举办的防范电信网络诈骗专题讲座和线上有奖问答活动，将于6月3日下午4:20在双校区同步举办，活动将宣告“安全教育月”的完美落幕！此次活动奖品丰厚，欢迎全体学生报名参加。\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\",\n" +
            "            \"pic_ids\": \"0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 10,\n" +
            "                \"screen_name\": \"搞笑大奇葩\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_0\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"参加活动的本科学生还将获得安全教育实践类学分0.2分\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 13,\n" +
            "            \"like_count\": 56,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\",\n" +
            "            \"pic_ids\": \"0,0,0,0,0,0,0,0,0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 11,\n" +
            "                \"screen_name\": \"学生活动中心\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_1\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"前段时间的讲座大家都参加了吗？那些防不胜防的骗局你是否都已知晓？新一期“预防电信诈骗，共建无诈校园”讲座又来了，快来报名参加吧！\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\",\n" +
            "            \"pic_ids\": \"0,0,0,0,0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 12,\n" +
            "                \"screen_name\": \"知识大百科\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_2\",\n" +
            "                \"friended\": true\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 3,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"所有课程均由同学们在教务系统里自主选择（仅“毕业设计”无需选课）。\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\",\n" +
            "            \"pic_ids\": \"0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 13,\n" +
            "                \"screen_name\": \"教务处\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_3\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        },\n" +
            "        \n" +
            "        {\n" +
            "            \"id\": 0,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"学校在2021年“平安成电”建设安全教育月中，持续开展以“预防电信诈骗，共建无诈校园”为主题的各类活动，在全校营造了防范电信网络诈骗的良好氛围，使得全校师生的防诈识诈能力得到有效提升。为巩固成绩，由学校保卫处、四川省公安厅反诈中心、成都市公安局高新分局反诈中心、成都市公安局高新分局合作派出所、中国移动高新西区分公司联合举办的防范电信网络诈骗专题讲座和线上有奖问答活动，将于6月3日下午4:20在双校区同步举办，活动将宣告“安全教育月”的完美落幕！此次活动奖品丰厚，欢迎全体学生报名参加。\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\",\n" +
            "            \"pic_ids\": \"0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 10,\n" +
            "                \"screen_name\": \"搞笑大奇葩\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_0\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"参加活动的本科学生还将获得安全教育实践类学分0.2分\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 13,\n" +
            "            \"like_count\": 56,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\",\n" +
            "            \"pic_ids\": \"0,0,0,0,0,0,0,0,0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 11,\n" +
            "                \"screen_name\": \"学生活动中心\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_1\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"前段时间的讲座大家都参加了吗？那些防不胜防的骗局你是否都已知晓？新一期“预防电信诈骗，共建无诈校园”讲座又来了，快来报名参加吧！\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\",\n" +
            "            \"pic_ids\": \"0,0,0,0,0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 12,\n" +
            "                \"screen_name\": \"知识大百科\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_2\",\n" +
            "                \"friended\": true\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 3,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"所有课程均由同学们在教务系统里自主选择（仅“毕业设计”无需选课）。\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\",\n" +
            "            \"pic_ids\": \"0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 13,\n" +
            "                \"screen_name\": \"教务处\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_3\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        }\n" +
            "    ],\n" +
            "    \"errorCode\": 0,\n" +
            "    \"errorMsg\": \"\"\n" +
            "}\n";


    public static HomeFriendModel getInstance(){
        if(sHomeFriendModel == null){
            sHomeFriendModel = new HomeFriendModel();
        }
        return sHomeFriendModel;
    }

    public static void test(){

    }

    @Override
    public void loadArticle(OnLoadArticleListener onLoadArticleListener) {
        onLoadArticleListener.onSuccess(getArticleData());
    }

    @Override
    public void refreshArticle(OnLoadArticleListener onLoadArticleListener) {
        onLoadArticleListener.onSuccess(getArticleData());
    }

    //获得数据
    private List<FeedStreamBean.ArticleData> getArticleData(){
        List<FeedStreamBean.ArticleData> datas = new ArrayList<FeedStreamBean.ArticleData>();
        if(mGson == null){
            mGson = new Gson();
        }
        FeedStreamBean feedStreamBean = mGson.fromJson(mString,FeedStreamBean.class);
//        datas =  feedStreamBean.getDatas();
//        Log.e(getClass().getSimpleName(),"feedStreamBean : " + feedStreamBean.toString());
//        Log.e(getClass().getSimpleName(),"datas : " + datas.toString());
        return feedStreamBean.getDatas();
    }


}

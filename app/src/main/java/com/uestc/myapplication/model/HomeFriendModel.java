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

    private String mRefreshString = "{\n" +
            "    \"datas\": [\n" +
            "        {\n" +
            "            \"id\": 0,  \n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"4月27-28日及5月25-26日，由电子科技大学青年志愿者协会红十字会（下文统称“红会”）策划并组织，由成都市血液中心协助开展的“献血车进校园”活动两次在银桦食堂及学子食堂门口展开，本次活动共有500余名师生参与。\\n活动期间，红会的志愿者们在8：30至10：00携带活动所需物资并布置活动场地。随后，引导两辆献血车分别前往对应的食堂门口，布置采血前所需的区域，包括填表区、体检区、检验区及献血区。\\n\\n10：30左右，便开始有想要献血的同学陆续前来，人流量在中午12:30-13:30达到顶峰，即使是当空的灼日也无法阻止同学们献血的热情。红会的志愿者们热情地引导每位献血者进行献血前的流程，并为献血结束的同学们提供了免费的糖果和饮品。\\n\\n每日的采血活动持续到了傍晚17：30，此时，红会的志愿者们开始清理场地，并协助医护人员整理物资。\\n\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\", \n" +
            "            \"pic_ids\": \"0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 10,\n" +
            "                \"screen_name\": \"电子科大校青协\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_0\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"5月6日晚\\n第六届全国大学生艺术展演活动\\n在成都城市音乐厅拉开帷幕\\n\\n本次大艺展\\n面向11所重点招募高校\\n招募会展服务志愿者\\n在蓉35所高校\\n招募对口接待保障志愿者\\n以及成渝双城经济圈重庆高校志愿者\\n共计1200余名\\n\\n今天\\n熊猫侠们早已做好准备\\n\\n迎“战”大艺展开幕式！\\n\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 13,\n" +
            "            \"like_count\": 56,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\", \n" +
            "            \"pic_ids\": \"\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 11,\n" +
            "                \"screen_name\": \"志愿四川\",\n" +
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
            "\n" +
            "        {\n" +
            "            \"id\": 0,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"4月27-28日及5月25-26日，由电子科技大学青年志愿者协会红十字会（下文统称“红会”）策划并组织，由成都市血液中心协助开展的“献血车进校园”活动两次在银桦食堂及学子食堂门口展开，本次活动共有500余名师生参与。\\n活动期间，红会的志愿者们在8：30至10：00携带活动所需物资并布置活动场地。随后，引导两辆献血车分别前往对应的食堂门口，布置采血前所需的区域，包括填表区、体检区、检验区及献血区。\\n\\n10：30左右，便开始有想要献血的同学陆续前来，人流量在中午12:30-13:30达到顶峰，即使是当空的灼日也无法阻止同学们献血的热情。红会的志愿者们热情地引导每位献血者进行献血前的流程，并为献血结束的同学们提供了免费的糖果和饮品。\\n\\n每日的采血活动持续到了傍晚17：30，此时，红会的志愿者们开始清理场地，并协助医护人员整理物资。\\n\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 7,\n" +
            "            \"like_count\": 30,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\",\n" +
            "            \"pic_ids\": \"0\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 10,\n" +
            "                \"screen_name\": \"电子科大校青协\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_0\",\n" +
            "                \"friended\": false\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"created_at\": \"2021-06-13 21:33\",\n" +
            "            \"text\": \"5月6日晚\\n第六届全国大学生艺术展演活动\\n在成都城市音乐厅拉开帷幕\\n\\n本次大艺展\\n面向11所重点招募高校\\n招募会展服务志愿者\\n在蓉35所高校\\n招募对口接待保障志愿者\\n以及成渝双城经济圈重庆高校志愿者\\n共计1200余名\\n\\n今天\\n熊猫侠们早已做好准备\\n\\n迎“战”大艺展开幕式！\\n\",\n" +
            "            \"source\": \"来自 nova8\",\n" +
            "            \"favorited\": false,\n" +
            "            \"comments_count\": 13,\n" +
            "            \"like_count\": 56,\n" +
            "            \"thumbnail_pic\": \"R.drawable.uestc_picture_\",\n" +
            "            \"pic_ids\": \"\",\n" +
            "            \"video\": \"\",\n" +
            "            \"user\": {\n" +
            "                \"id\": 11,\n" +
            "                \"screen_name\": \"志愿四川\",\n" +
            "                \"profile_image_url\": \"R.drawable.profile_image_1\",\n" +
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

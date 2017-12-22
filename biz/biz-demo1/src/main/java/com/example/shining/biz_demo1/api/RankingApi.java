package com.example.shining.biz_demo1.api;

import com.example.shining.biz_demo1.bean.Huoquhaoyou;
import com.example.shining.libglin.glin.annotation.JSON;
import com.example.shining.libglin.glin.call.Call;
import com.example.shining.libvariants.NetConfig;



public interface RankingApi {

//    //个人段位信息
//    @JSON(NetConfig.URL_ZHIDAO_V1 + "user/get.user.fration")
//    Call<RankingResponse> getRanking(String json);
//
//
//    //好友（微信）排行榜
//    @JSON(NetConfig.URL_ZHIDAO_V1 + "user/rank/friends")
//    Call<FriendsListInfo> getFriendsRanking(String json);
//
//    //切换称号
//    @JSON(NetConfig.URL_ZHIDAO_V1 + "user/update.user.show.fration")
//    Call<UpdataRankingResponse> updataRanking(String json);
//
//    //关注、粉丝列表
//    @JSON(NetConfig.URL_ZHIDAO_V1 + "user/followers")
//    Call<FollowListInfo> getFollow(String json);

    //biz-demo1
    @JSON(NetConfig.SERVER_ISERVICE + "方法名")
    Call<Huoquhaoyou> get_biz_demo1(String json);
}

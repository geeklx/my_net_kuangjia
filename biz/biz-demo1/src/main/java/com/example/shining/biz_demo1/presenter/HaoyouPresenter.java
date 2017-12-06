package com.example.shining.biz_demo1.presenter;


import com.example.shining.biz_demo1.view.IHaoyouView;
import com.example.shining.libmvp.mvp.Presenter;

/**
 * 发表评论
 */

public class HaoyouPresenter extends Presenter<IHaoyouView> {

    public void huoquhaoyou(String topic_id){
//        JSONObject p = new JSONObject();
//        p.put("topic_id", topic_id);
////        p.put("first_parent_id", first_parent_id);
////        p.put("parent_comment_id", parent_comment_id);
////        p.put("content", content);
////        p.put("pic_url", pic_url);
////        p.put("vidio_url", vidio_url);
////        p.put("audio_url", audio_url);
//        Http.select(Http.XCOOK).create(AnswerApi.class, getIdentifier()).huoquhaoyou(ParamsUtils.just(p))
//                .enqueue(new Callback<List<Huoquhaoyou>>() {
//                    @Override
//                    public void onResponse(Result<List<Huoquhaoyou>> result) {
//                        if (!hasView()){
//                            return;
//                        }
//                        if (!result.isOK()){
//                            getView().onHaoyouError(result.getMessage());
//                            return;
//                        }
//                        getView().onHaoyouSuccess(result.getResult());
//                    }
//                });
    }
}

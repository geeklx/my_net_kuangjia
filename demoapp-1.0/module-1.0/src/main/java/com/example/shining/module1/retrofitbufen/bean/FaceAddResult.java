package com.example.shining.module1.retrofitbufen.bean;

import java.util.List;

/**
 * Created by cpl on 2017/8/30.
 */

public class FaceAddResult {

    /**
     * faceset_token : 1347343eac0bb909497f0840431ebbf4
     * time_used : 672
     * face_count : 2
     * face_added : 2
     * request_id : 1504068341,803b7be0-4506-4e09-bbb1-96210ba111ae
     * outer_id : sairobo_face_id
     * failure_detail : []
     */

    private String faceset_token;
    private int time_used;
    private int face_count;
    private int face_added;
    private String request_id;
    private String outer_id;
    private List<?> failure_detail;

    public String getFaceset_token() {
        return faceset_token;
    }

    public void setFaceset_token(String faceset_token) {
        this.faceset_token = faceset_token;
    }

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public int getFace_count() {
        return face_count;
    }

    public void setFace_count(int face_count) {
        this.face_count = face_count;
    }

    public int getFace_added() {
        return face_added;
    }

    public void setFace_added(int face_added) {
        this.face_added = face_added;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getOuter_id() {
        return outer_id;
    }

    public void setOuter_id(String outer_id) {
        this.outer_id = outer_id;
    }

    public List<?> getFailure_detail() {
        return failure_detail;
    }

    public void setFailure_detail(List<?> failure_detail) {
        this.failure_detail = failure_detail;
    }
}

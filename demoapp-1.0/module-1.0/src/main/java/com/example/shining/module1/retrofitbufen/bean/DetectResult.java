package com.example.shining.module1.retrofitbufen.bean;

import java.util.List;

/**
 * Created by cpl on 2017/8/30.
 */

public class DetectResult {


    /**
     * image_id : mDHsZoCjAI662OjEZrH+ZA==
     * request_id : 1504064260,0c2452af-27ac-4bb3-8465-cf57148420e6
     * time_used : 206
     * faces : [{"face_rectangle":{"width":81,"top":85,"left":97,"height":81},"face_token":"b7e93c13bec8023efed08d599a3a457a"},{"face_rectangle":{"width":77,"top":103,"left":332,"height":77},"face_token":"c2b96f28dcfcc036f716a691d757e37b"}]
     */

    private String image_id;
    private String request_id;
    private int time_used;
    private List<FacesBean> faces;

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public int getTime_used() {
        return time_used;
    }

    public void setTime_used(int time_used) {
        this.time_used = time_used;
    }

    public List<FacesBean> getFaces() {
        return faces;
    }

    public void setFaces(List<FacesBean> faces) {
        this.faces = faces;
    }

    public static class FacesBean {
        /**
         * face_rectangle : {"width":81,"top":85,"left":97,"height":81}
         * face_token : b7e93c13bec8023efed08d599a3a457a
         */

        private FaceRectangleBean face_rectangle;
        private String face_token;

        public FaceRectangleBean getFace_rectangle() {
            return face_rectangle;
        }

        public void setFace_rectangle(FaceRectangleBean face_rectangle) {
            this.face_rectangle = face_rectangle;
        }

        public String getFace_token() {
            return face_token;
        }

        public void setFace_token(String face_token) {
            this.face_token = face_token;
        }

        public static class FaceRectangleBean {
            /**
             * width : 81
             * top : 85
             * left : 97
             * height : 81
             */

            private int width;
            private int top;
            private int left;
            private int height;

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }
}

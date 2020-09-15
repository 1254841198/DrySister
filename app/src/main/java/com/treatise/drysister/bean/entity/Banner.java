package com.treatise.drysister.bean.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Banner {
    //{
    //	"data": [{
    //		"image": "http://gank.io/images/cfb4028bfead41e8b6e34057364969d1",
    //		"title": "\u5e72\u8d27\u96c6\u4e2d\u8425\u65b0\u7248\u66f4\u65b0",
    //		"url": "https://gank.io/migrate_progress"
    //	}, {
    //		"image": "http://gank.io/images/aebca647b3054757afd0e54d83e0628e",
    //		"title": "- \u6625\u6c34\u521d\u751f\uff0c\u6625\u6797\u521d\u76db\uff0c\u6625\u98ce\u5341\u91cc\uff0c\u4e0d\u5982\u4f60\u3002",
    //		"url": "https://gank.io/post/5e51497b6e7524f833c3f7a8"
    //	}, {
    //		"image": "https://pic.downk.cc/item/5e7b64fd504f4bcb040fae8f.jpg",
    //		"title": "\u76d8\u70b9\u56fd\u5185\u90a3\u4e9b\u514d\u8d39\u597d\u7528\u7684\u56fe\u5e8a",
    //		"url": "https://gank.io/post/5e7b5a8b6d2e518fdeab27aa"
    //	}],
    //	"status": 100
    //}

    private ArrayList<Data> dataList;
    private int status;

    public Banner(JSONObject json) {
        dataList = new ArrayList<>();
        JSONArray jsonArray = json.optJSONArray("data");
        status= json.optInt("status");

        if (jsonArray == null){
            return;
        }
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.optJSONObject(i);
            String image = object.optString("image");
            String title = object.optString("title");
            String url = object.optString("url");
            dataList.add(new Data(image,title,url));
        }
    }

    public Banner() {
    }

    public ArrayList<Data> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<Data> dataList) {
        this.dataList = dataList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   public class Data{
        private String image;
        private String title;
        private String url;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Data(String image, String title, String url) {
            this.image = image;
            this.title = title;
            this.url = url;
        }
    }
}

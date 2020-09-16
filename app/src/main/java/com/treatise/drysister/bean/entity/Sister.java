package com.treatise.drysister.bean.entity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Sister {
    //{
    //    "data": [{
    //        "_id": "5e959250808d6d2fe6b56eda",
    //        "author": "\u9e22\u5a9b",
    //        "category": "Girl",
    //        "createdAt": "2020-05-25 08:00:00",
    //        "desc": "\u4e0e\u5176\u5b89\u6170\u81ea\u5df1\u5e73\u51e1\u53ef\u8d35\uff0c\n\u4e0d\u5982\u62fc\u5c3d\u5168\u529b\u6d3b\u5f97\u6f02\u4eae\u3002 \u200b \u200b\u200b\u200b\u200b",
    //        "images": ["http://gank.io/images/f4f6d68bf30147e1bdd4ddbc6ad7c2a2"],
    //        "likeCounts": 4,
    //        "publishedAt": "2020-05-25 08:00:00",
    //        "stars": 1,
    //        "title": "\u7b2c96\u671f",
    //        "type": "Girl",
    //        "url": "http://gank.io/images/f4f6d68bf30147e1bdd4ddbc6ad7c2a2",
    //        "views": 6979
    //    },
    //    {
    //        "_id": "5e95915f808d6d2fe6b56ed3",
    //        "author": "\u9e22\u5a9b",
    //        "category": "Girl",
    //        "createdAt": "2020-05-16 08:00:00",
    //        "desc": "\u82e5\u4e0d\u662f\u60c5\u6df1\u4f3c\u6d77\uff0c\u601d\u5ff5\u53c8\u600e\u4f1a\u6cdb\u6ee5\u6210\u707e\u3002",
    //        "images": ["http://gank.io/images/bdb35e4b3c0045c799cc7a494a3db3e0"],
    //        "likeCounts": 2,
    //        "publishedAt": "2020-05-16 08:00:00",
    //        "stars": 1,
    //        "title": "\u7b2c87\u671f",
    //        "type": "Girl",
    //        "url": "http://gank.io/images/bdb35e4b3c0045c799cc7a494a3db3e0",
    //        "views": 2489
    //    }],
    //    "page": 1,
    //    "page_count": 10,
    //    "status": 100,
    //    "total_counts": 96
    //}

    private ArrayList<Data> dataArrayList;
    private int page;
    private int page_count;
    private int status;
    private int total_counts;

    public Sister(String data) {
        if (data == null) {
            return;
        }
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = jsonObject.optJSONArray("data");
        page = jsonObject.optInt("page");
        page_count = jsonObject.optInt("page_count");
        status = jsonObject.optInt("status");
        total_counts = jsonObject.optInt("total_counts");

        if (array == null) {
            return;
        }
        dataArrayList = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            dataArrayList.add(new Data(array.optJSONObject(i)));
        }
    }

    @Override
    public String toString() {
        return "Sister{" +
                "dataArrayList=" + dataArrayList +
                '}';
    }

    public ArrayList<Data> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal_counts() {
        return total_counts;
    }

    public void setTotal_counts(int total_counts) {
        this.total_counts = total_counts;
    }

    public class Data {
        private String _id;
        private String author;
        private String category;
        private String createdAt;
        private String desc;
        private String images;
        private int likeCounts;
        private String publishedAt;
        private int stars;
        private String title;
        private String type;
        private String url;
        private int views;

        public Data(JSONObject object) {
            _id = object.optString("_id");
            author = object.optString("author");
            category = object.optString("category");
            createdAt = object.optString("createdAt");
            desc = object.optString("desc");

            JSONArray imageArray = object.optJSONArray("images");
            try {
                if (imageArray != null) {
                    images = imageArray.getString(0);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            likeCounts = object.optInt("likeCounts");
            publishedAt = object.optString("publishedAt");
            stars = object.optInt("stars");
            title = object.optString("title");
            type = object.optString("type");
            url = object.optString("url");
            views = object.optInt("views");
        }

        @Override
        public String toString() {
            return "Data{" +
                    "images='" + images + '\'' +
                    '}';
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public int getLikeCounts() {
            return likeCounts;
        }

        public void setLikeCounts(int likeCounts) {
            this.likeCounts = likeCounts;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public int getStars() {
            return stars;
        }

        public void setStars(int stars) {
            this.stars = stars;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }
    }
}

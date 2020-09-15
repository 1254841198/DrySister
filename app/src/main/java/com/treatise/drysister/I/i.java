package com.treatise.drysister.I;

//数据接口
public interface i {

    //首页轮播窗口
    String bannerUrl =  "https://gank.io/api/v2/banners";

    //分类
    //https://gank.io/api/v2/categories/<category_type>
    String sortUrl = "https://gank.io/api/v2/categories/";
    //category_type 可接受参数 Article | GanHuo | Girl
    //Article: 专题分类、 GanHuo: 干货分类 、 Girl:妹子图

    //分类数据
    //https://gank.io/api/v2/data/category/<category>/type/<type>/page/<page>/count/<count>
//    String sortDetailUrl = "https://gank.io/api/v2/data/category/<category>/type/<type>/page/<page>/count/<count>";
    //前期测试用
    String sortDetailUrl = "https://gank.io/api/v2/data/category/Girl/type/Girl/page/1/count/10";
    //category 可接受参数 All(所有分类) | Article | GanHuo | Girl
    //type 可接受参数 All(全部类型) | Android | iOS | Flutter | Girl ...，即分类API返回的类型数据
    //count: [10, 50]
    //page: >=1

    //随机
    //https://gank.io/api/v2/random/category/<category>/type/<type>/count/<count>
    //category 可接受参数 Article | GanHuo | Girl
    //type 可接受参数 Android | iOS | Flutter | Girl，即分类API返回的类型数据
    //count: [1, 50]

    //文章详情 API
    //https://gank.io/api/v2/post/<post_id>
    //post_id 可接受参数 文章id[分类数据API返回的_id字段]

    //本周最热
    //https://gank.io/api/v2/hot/<hot_type>/category/<category>/count/<count>
    //hot_type 可接受参数 views（浏览数） | likes（点赞数） | comments（评论数）❌
    //category 可接受参数 Article | GanHuo | Girl
    //count: [1, 20]

    //文章评论获取
    //https://gank.io/api/v2/post/comments/<post_id>
    //post_id 可接受参数 文章Id

    //搜索
    //https://gank.io/api/v2/search/<search>/category/<category>/type/<type>/page/<page>/count/<count>
    //search 可接受参数 要搜索的内容
    //category 可接受参数 All[所有分类] | Article | GanHuo
    //type 可接受参数 Android | iOS | Flutter ...，即分类API返回的类型数据
    //count: [10, 50]
    //page: >=1

}

package cn.com.hatech.sharding.common.page;

import java.util.Map;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @Program: hatech-framework
 * @Package: cn.com.hatechframework.data.page
 * @ClassName: Pagination
 * @Description: 分页信息类
 * @Author: JiangXincan
 * @Create: 2019/12/18 13:12
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/18 13:12             1.0                         分页信息类
 */
public class Pagination{

    // 当前页
    public static Integer page = 0;

    // 每页展示条数
    public static Integer limit = 10;

    /**
     * @Description: 分页信息
     * @param map   包含page，limit属性信息
     * @Author: JiangXincan
     * @Date: 2019/12/18 13:14
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page
     */
    public static HPage page(Map<String, Object> map){

        if(map.containsKey("page") && map.containsKey("limit")){
            Integer p = Integer.parseInt(map.get("page").toString());
            Integer s = Integer.parseInt(map.get("limit").toString());
            Pagination.page = p;
            Pagination.limit = s;
        }
        return new HPage(Pagination.page, Pagination.limit);
    }

    /**
     * @Description: 分页信息
     * @param page   包含page，limit属性信息
     * @Author: JiangXincan
     * @Date: 2019/12/18 13:14
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page
     */
    public static <T extends PaginationQuery> HPage page(T page){
        Pagination.page =  page.getPage();
        Pagination.limit = page.getLimit();
        return new HPage(Pagination.page, Pagination.limit);
    }

    /**
     * @Description: 分页信息
     * @param page   当前页
     * @param limit  每页显示条数
     * @Author: JiangXincan
     * @Date: 2019/12/18 13:14
     * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page
     */
    public static HPage page(Integer page, Integer limit){
        if(limit > 0){
            Pagination.page = page;
            Pagination.limit = limit;
        }
        return new HPage(Pagination.page, Pagination.limit);
    }

}

package cn.bite.travel.domain;

import lombok.Data;

import java.util.List;

/**
 * 自定义分页实体类
 */

@Data
public class PageBean<T> {
    private int totalCount; //总记录数
    private  int totalPage;   //总页数
    private int currentPage; //每页显示条数
    private int PageSize;
    //当前具体列表数据集合
    private List<T> list;
}

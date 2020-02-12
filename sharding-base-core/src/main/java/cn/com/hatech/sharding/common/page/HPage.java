package cn.com.hatech.sharding.common.page;

import com.baomidou.mybatisplus.core.metadata.OrderItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @Program: mswang-sharding-jdbc
 * @Package: com.mswang.learn.common.page
 * @ClassName: HPage
 * @Description: 自定义分页类
 * @Author: WangMingShuai
 * @Create: 2020/1/3 17:53
 * @Version: 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2020/1/3 17:53             1.0                         自定义分页类
 */
public class HPage<T> {

    private List<T> records;
    private Integer total;
    private Integer size;
    private Integer current;
    private List<OrderItem> orders;
    private boolean optimizeCountSql;
    private boolean isSearchCount;

    public HPage() {
        this.records = Collections.emptyList();
        this.total = 0;
        this.size = 10;
        this.current = 1;
        this.orders = new ArrayList();
        this.optimizeCountSql = true;
        this.isSearchCount = true;
    }

    public HPage(Integer current, Integer size) {
        this(current, size, 0);
    }

    public HPage(Integer current, Integer size, Integer total) {
        this(current, size, total, true);
    }

    public HPage(Integer current, Integer size, boolean isSearchCount) {
        this(current, size, 0, isSearchCount);
    }

    public HPage(Integer current, Integer size, Integer total, boolean isSearchCount) {

        this.records = Collections.emptyList();
        this.total = 0;
        this.size = 10;
        this.current = 1;
        this.orders = new ArrayList();
        this.optimizeCountSql = true;
        this.isSearchCount = true;
        if (current > 1L) {
            this.current = current;
        }

        this.size = size;
        this.total = total;
        this.isSearchCount = isSearchCount;
    }

    public boolean hasPrevious() {
        return this.current > 1L;
    }

    public boolean hasNext() {
        return this.current < this.getPages();
    }

    public List<T> getRecords() {
        return this.records;
    }

    public HPage<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    public Integer getTotal() {
        return this.total;
    }

    public HPage<T> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getSize() {
        return this.size;
    }

    public HPage<T> setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Integer getCurrent() {
        return this.current;
    }

    public HPage<T> setCurrent(Integer current) {
        this.current = current;
        return this;
    }

    private String[] mapOrderToArray(Predicate<OrderItem> filter) {
        List<String> columns = new ArrayList(this.orders.size());
        this.orders.forEach((i) -> {
            if (filter.test(i)) {
                columns.add(i.getColumn());
            }

        });
        return (String[])columns.toArray(new String[0]);
    }

    private void removeOrder(Predicate<OrderItem> filter) {
        for(int i = this.orders.size() - 1; i >= 0; --i) {
            if (filter.test(this.orders.get(i))) {
                this.orders.remove(i);
            }
        }

    }

    public HPage<T> addOrder(OrderItem... items) {
        this.orders.addAll(Arrays.asList(items));
        return this;
    }

    public HPage<T> addOrder(List<OrderItem> items) {
        this.orders.addAll(items);
        return this;
    }

    public List<OrderItem> orders() {
        return this.getOrders();
    }

    public List<OrderItem> getOrders() {
        return this.orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }

    public boolean optimizeCountSql() {
        return this.optimizeCountSql;
    }

    public boolean isSearchCount() {
        return this.total < 0L ? false : this.isSearchCount;
    }

    public HPage<T> setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
        return this;
    }

    public HPage<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        return this;
    }

    public Integer getPages() {
        if (this.getSize() == 0L) {
            return 0;
        } else {
            Integer pages = this.getTotal() / this.getSize();
            if (this.getTotal() % this.getSize() != 0L) {
                ++pages;
            }

            return pages;
        }
    }
}

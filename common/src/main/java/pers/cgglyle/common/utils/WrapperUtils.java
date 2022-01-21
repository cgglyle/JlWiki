package pers.cgglyle.common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import pers.cgglyle.common.base.model.BaseEntity;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.response.PageResult;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author cgglyle
 * @date 2022-01-21 09:01
 */
public class WrapperUtils {
    /**
     * 打包器
     * <p> 用于打包Page对象成PageResult对象
     * 并且会做类型转换
     *
     * @param data      Page对象
     * @param baseQuery 请求参数
     * @param clazz     要转换成的类型
     * @return PageResult对象
     */
    public static PageResult wrapper(Page<? extends BaseEntity> data, BaseQuery baseQuery, Class<?> clazz) {
        List<?> collect = data.getRecords().stream().map(o -> {
            try {
                Constructor<?> constructor = clazz.getConstructor();
                Object obj = constructor.newInstance();
                BeanUtils.copyProperties(o, obj);
                return obj;
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        return new PageResult(baseQuery.getPageNum(), baseQuery.getPageSize(), data.getTotal(), data.getPages(), collect);
    }

    /**
     * 函数式打包器
     * <p> 用于打包Page对象成PageResult对象
     * 并且会做类型转换
     * <p> 特别的是：本方法支持函数是编程，可以在consumer参数初传递一个函数
     *
     * @param data      Page对象
     * @param baseQuery 请求参数
     * @param clazz     转换类型
     * @param consumer  函数接口
     * @return PageResult对象
     */
    public static PageResult wrapper(Page<? extends BaseEntity> data, BaseQuery baseQuery, Class<?> clazz, Consumer<Object> consumer) {
        List<?> collect = data.getRecords().stream().map(o -> {
            try {
                Constructor<?> constructor = clazz.getConstructor();
                Object obj = constructor.newInstance();
                BeanUtils.copyProperties(o, obj);
                consumer.accept(obj);
                return obj;
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        return new PageResult(baseQuery.getPageNum(), baseQuery.getPageSize(), data.getTotal(), data.getPages(), collect);
    }
}

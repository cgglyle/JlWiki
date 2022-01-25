package pers.cgglyle.common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import pers.cgglyle.common.base.model.BaseEntity;
import pers.cgglyle.common.base.model.BaseQuery;
import pers.cgglyle.common.base.service.impl.BaseFactory;
import pers.cgglyle.common.base.service.impl.BaseFactoryImpl;
import pers.cgglyle.common.response.PageResult;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author cgglyle
 * @date 2022-01-21 09:01
 */
public class WrapperUtils {
    /**
     * 打包器
     * <p> 用于将{@code Page}对象打包成{@code PageResult}对象
     * 并且会做类型转换
     *
     * @param data      Page对象
     * @param baseQuery 请求参数
     * @param clazz     要转换成的类型
     * @return PageResult对象
     */
    public static PageResult wrapper(Page<? extends BaseEntity> data, BaseQuery baseQuery, Class<?> clazz){
        BaseFactory factory = new BaseFactoryImpl();
        List<?> collect = data.getRecords().stream().map(o -> {
            Object obj = null;
            try {
                obj = factory.create(clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(o, obj);
            return obj;
        }).collect(Collectors.toList());
        return new PageResult(baseQuery.getPageNum(), baseQuery.getPageSize(), data.getTotal(), data.getPages(), collect);
    }

    /**
     * 函数式打包器
     * <p> 用于将{@code Page}对象打包成{@code PageResult}对象
     * 并且会做类型转换
     * <p> 特别的是：本方法支持函数是编程，可以在consumer参数初传递一个函数
     *
     * @param data      Page对象
     * @param baseQuery 请求参数
     * @param clazz     转换类型
     * @param consumer  (o, obj) o 是未转换之前的对象，也就是实体对象，obj 是转换后的对象，也就是显示对象。
     * @return PageResult对象
     */
    public static PageResult wrapper(Page<? extends BaseEntity> data, BaseQuery baseQuery, Class<?> clazz, BiConsumer<Object, Object> consumer) {
        BaseFactory factory = new BaseFactoryImpl();
        List<?> collect = data.getRecords().stream().map(o -> {
            Object obj = null;
            try {
                obj = factory.create(clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
            consumer.accept(o, obj);
            BeanUtils.copyProperties(o, obj);
            return obj;
        }).collect(Collectors.toList());
        return new PageResult(baseQuery.getPageNum(), baseQuery.getPageSize(), data.getTotal(), data.getPages(), collect);
    }
}

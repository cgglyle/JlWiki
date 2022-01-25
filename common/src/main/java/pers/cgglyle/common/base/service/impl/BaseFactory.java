package pers.cgglyle.common.base.service.impl;

/**
 * 抽象工厂
 *
 * @author cgglyle
 * @date 2022-01-24 16:34
 */
public abstract class BaseFactory {
    /**
     * 通过工厂创建一个类对象
     *
     * @param clazz 类名
     * @param <T>   类
     * @return 对象
     */
    public abstract <T extends Object> T create(Class<T> clazz) throws Exception;
}

package pers.cgglyle.common.base.service.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 提供一个默认的抽象工厂的实现
 *
 * @author cgglyle
 * @date 2022-01-24 16:43
 */
public class BaseFactoryImpl extends BaseFactory {
    /**
     * 通过工厂创建一个类对象
     *
     * @param clazz 类名
     * @return 对象
     */
    @Override
    public <T> T create(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = clazz.getConstructor();
        return constructor.newInstance();
    }
}

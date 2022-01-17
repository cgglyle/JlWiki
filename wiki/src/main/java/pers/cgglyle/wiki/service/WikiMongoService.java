package pers.cgglyle.wiki.service;

import org.springframework.data.mongodb.core.query.Query;
import pers.cgglyle.wiki.model.entity.WikiEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author cgglyle
 * @date 2022-01-13 11:46
 */
public interface WikiMongoService {

    /**
     * 获取所有集合名称列表
     *
     * @return 集合名称列表
     */
    Object getCollectionName();

    /**
     * 判断集合是否存在
     *
     * @param collectionName 集合名字
     * @return 是否
     */
    boolean hasCollection(String collectionName);

    /**
     * 删除集合
     *
     * @param collectionName 集合名字
     * @return 成功失败
     */
    boolean deleteCollection(String collectionName);

    /**
     * 存储一个文档
     *
     * @param entity     文档添加类
     * @param collection 集合名
     * @return wikiID
     */
    String save(WikiEntity entity, String collection);

    /**
     * 根据请求获取文档
     *
     * @param query      请求
     * @param clazz      实体类型
     * @param collection 集合名
     * @return 文档列表
     */
    List<?> find(Query query, Class<?> clazz, String collection);

    /**
     * 查询所有文档
     *
     * @return 文档列表
     */
    List<?> findAll();

    /**
     * 查询所有文档根据集合名字
     *
     * @param collectionName 集合名字
     * @return 文档列表
     */
    List<?> findAll(String collectionName);

    /**
     * 查询文档根据id
     *
     * @param id 文档id
     * @return 文档
     */
    Object findById(Serializable id);

    /**
     * 删除文档根据id
     *
     * @param id 文档id
     * @return 文档
     */
    boolean deleteById(Serializable id);

    /**
     * 查询符合条件的文档数目
     *
     * @param query      查询条件
     * @param clazz      实体类型
     * @param collection 集合名
     * @return 数目
     */
    Long count(Query query, Class<?> clazz, String collection);
}

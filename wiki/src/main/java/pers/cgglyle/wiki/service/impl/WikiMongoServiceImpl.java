package pers.cgglyle.wiki.service.impl;

import com.mongodb.client.result.DeleteResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import pers.cgglyle.wiki.model.entity.WikiEntity;
import pers.cgglyle.wiki.service.intf.WikiMongoService;

import java.io.Serializable;
import java.util.List;

/**
 * @author cgglyle
 * @date 2022-01-13 11:46
 */
@Slf4j
@Service
public class WikiMongoServiceImpl implements WikiMongoService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 获取所有集合名称列表
     *
     * @return 集合名称列表
     */
    @Override
    public Object getCollectionName() {
        return mongoTemplate.getCollectionNames();
    }

    /**
     * 判断集合是否存在
     *
     * @param collectionName 集合名字
     * @return 是否
     */
    @Override
    public boolean hasCollection(String collectionName) {
        return mongoTemplate.collectionExists(collectionName);
    }

    /**
     * 删除集合
     *
     * @param collectionName 集合名字
     * @return 成功失败
     */
    @Override
    public boolean deleteCollection(String collectionName) {
        mongoTemplate.getCollection(collectionName).drop();
        return hasCollection(collectionName);
    }

    /**
     * 存储一个文档
     *
     * @param entity 文档添加类
     * @return 成功失败
     */
    @Override
    public String save(WikiEntity entity, String collection) {
        WikiEntity save = mongoTemplate.save(entity, collection);
        return save.getId();
    }

    /**
     * 根据请求获取文档
     *
     * @param query      请求
     * @param clazz      实体类型
     * @param collection 集合名
     * @return 文档列表
     */
    @Override
    public List<?> find(Query query, Class<?> clazz, String collection) {
        return mongoTemplate.find(query, clazz, collection);
    }

    /**
     * 查询所有文档
     *
     * @return 文档列表
     */
    @Override
    public List<?> findAll() {
        return mongoTemplate.findAll(WikiEntity.class);
    }

    /**
     * 查询所有文档根据集合名字
     *
     * @param collectionName 集合名字
     * @return 文档列表
     */
    @Override
    public List<?> findAll(String collectionName) {
        return mongoTemplate.findAll(WikiEntity.class, collectionName);
    }

    /**
     * 查询文档根据id
     *
     * @param id 文档id
     * @return 文档
     */
    @Override
    public Object findById(Serializable id) {
        return mongoTemplate.findById(id, WikiEntity.class);
    }

    /**
     * 删除文档根据id
     *
     * @param id 文档id
     * @return 文档
     */
    @Override
    public boolean deleteById(Serializable id) {
        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        DeleteResult remove = mongoTemplate.remove(query, "testWikiCollection");
        log.info("移除" + remove.getDeletedCount() + "条");
        return true;
    }

    /**
     * 查询符合条件的文档数目
     *
     * @param query      查询条件
     * @param clazz      实体类型
     * @param collection 集合名
     * @return 数目
     */
    @Override
    public Long count(Query query, Class<?> clazz, String collection) {
        return mongoTemplate.count(query, clazz, collection);
    }
}

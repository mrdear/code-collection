package cn.mrdear.collection.spring.memcache.refresh;

import lombok.Data;

import cn.mrdear.collection.spring.memcache.CacheType;

/**
 * 缓存刷新指令
 * @author Quding Ding
 * @since 2019/11/22
 */
@Data
public class CacheRefreshCmd {

    /**
     * 缓存类型
     */
    private CacheType cacheType;

    /**
     * 缓存操作
     */
    private OpType op;

    /**
     * 缓存key
     */
    private String cacheKey;

    /**
     * 版本
     */
    private Integer version;


}

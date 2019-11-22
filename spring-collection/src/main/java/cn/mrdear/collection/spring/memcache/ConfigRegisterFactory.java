package cn.mrdear.collection.spring.memcache;

import cn.mrdear.collection.spring.memcache.refresh.CacheRefreshCmd;

/**
 * 缓存注册接口
 *
 * @author Quding Ding
 * @since 2019/11/22
 */
public interface ConfigRegisterFactory<T> {

    /**
     * 支持的缓存类型
     * @return 缓存类型
     */
    CacheType support();


    /**
     * 根据缓存key,获取对应的值
     * @param cacheKey 缓存key
     * @return 缓存值
     */
    T getCache(String cacheKey);

    /**
     * 刷新指令
     * @param cmd 刷新命令
     */
    void refresh(CacheRefreshCmd cmd);

}

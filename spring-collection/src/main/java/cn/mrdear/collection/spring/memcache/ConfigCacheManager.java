package cn.mrdear.collection.spring.memcache;

import cn.mrdear.collection.spring.memcache.refresh.CacheRefreshCmd;

import java.util.List;

/**
 * 缓存管理器, 根据业务需要,写获取对应缓存的方法
 * @author Quding Ding
 * @since 2019/11/19
 */
public interface ConfigCacheManager {


    /**
     * 通用获取缓存接口
     * @param type 缓存类型
     * @param key 缓存key
     * @param <T> 缓存结果
     * @return 结果
     */
    <T> T getCache(CacheType type, String key);

    /**
     * 缓存刷新操作
     * @param cmds 刷新指令
     */
    void refresh(List<CacheRefreshCmd> cmds);

}

package cn.mrdear.collection.spring.memcache;

/**
 * 缓存类型
 * @author Quding Ding
 * @since 2019/11/22
 */
public enum CacheType {

    /**
     * 测试key
     */
    TEST_CONFIG_BEAN("TCB")
    ;

    /**
     * 缓存类型简称
     */
    public final String shortKey;


    CacheType(String shortKey) {
        this.shortKey = shortKey;
    }


}

package cn.cnsjwx.common.core.mybatis.dao;
import cn.cnsjwx.common.utils.UUIDUitl;
/**
 * Created by Nathan on 2016-08-23.
 * 流水号产生器
 */
public class KeyGenerator {

    private KeyGenerator() {
    }

    /**
     * 获取随机主键
     *
     */
    public static String randomSeqNum() {
        return UUIDUitl.randomUUID();
    }

}

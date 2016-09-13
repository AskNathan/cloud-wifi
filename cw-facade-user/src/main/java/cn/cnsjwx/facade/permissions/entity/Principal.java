package cn.cnsjwx.facade.permissions.entity;
import java.util.Map;
/**
 * 主体的定义
 * Created by Nathan on 2016-09-08.
 */
public interface Principal {

    /**
     * 获得主体的Id
     * @return
     */
    public String getPrincipalId();

    /**
     * 获得主体的类型
     * @return
     */
    public String getPrincipalType();

    /**
     * key:父主体的类型
     * value:父主体的Id
     * @return
     */
    public Map<Object,String> getParentPrincipal();

}

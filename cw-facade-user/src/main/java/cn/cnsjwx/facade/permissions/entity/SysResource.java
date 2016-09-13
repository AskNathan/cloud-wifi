package cn.cnsjwx.facade.permissions.entity;
import java.util.Map;
/**
 * 资源的定义
 * Created by Nathan on 2016-09-08.
 */
public interface SysResource {

    /**
     * 获得资源的Id
     * @return
     */
    public String getResourceId();

    /**
     * 获得资源的Type
     * @return
     */
    public String getResourceType();

    /**
     * 获得操作的索引值
     * @return
     */
    public int[] getOpersIndex();


    /**
     * 获得操作的唯一标示Sn
     * @param operSn
     * @return
     */
    public int getOperIndexBySn(String operSn);


    /**
     * 获得所有操作的子资源
     * @return
     */
    public Map<Object,String> getChildrenResource();

}

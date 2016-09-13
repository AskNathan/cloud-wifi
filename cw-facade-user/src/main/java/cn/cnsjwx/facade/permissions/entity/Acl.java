package cn.cnsjwx.facade.permissions.entity;

import cn.cnsjwx.common.entity.BaseEntity;
import cn.cnsjwx.common.exceptions.NestedException;

/**
 * 控制访问列表
 * Created by Nathan on 2016-09-08.
 */
public class Acl extends BaseEntity {

    /** 主体的类型 */
    private String principalType;

    /** 主体的ID */
    private String principalId;

    /** 资源的ID */
    private String resourceId;

    /** 资源的类型 */
    private String resourceType;

    /** Acl的操作位 */
    private int aclState;

    /** Acl的继承位 */
    private int aclTriState;

    /**
     * 设置对于的位操作
     * @param index
     * @param permit
     * @param ext
     * @return void 返回类型
     */
    public void setPermission(int index, boolean permit, boolean ext) {
        if (index < 0 || index > 31) {
            throw new NestedException("操作索引值有误！");
        }
        if (ext) {
            // 要设置aclTriState相应的位为1，以示继承
            aclTriState = setBit(aclTriState, index, true);
        } else {
            // 要设置aclTriState相应的位为0，以示不继承
            aclTriState = setBit(aclTriState, index, false);
        }

        // 设置aclState相应位的取值！
        aclState = setBit(aclState, index, permit);
    }

    /**
     * 将某个int类型的值的第index位改为1或0
     * @param i 某个需要改变的值
     * @param index 第几位
     * @param value true表示改为1，false表示改为0
     * @return
     */
    private int setBit(int i, int index, boolean value) {
        int temp = 1;
        temp = temp << index;
        if (value) { // 如果要把这一位设置为1
            i = i | temp;
        } else { // 如果要把这一位设置为0
            temp = ~temp;
            i = i & temp;
        }
        return i;
    }

    private boolean getBit(int i, int index) {
        int temp = 1;
        temp = temp << index;
        temp = i & temp;
        if (temp == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 是否允许
     * @param index
     * @return boolean 返回类型
     */
    public boolean isPermit(int index) {
        return getBit(aclState, index);
    }

    /**
     * 是否继承
     * @param index
     * @return boolean 返回类型
     */
    public boolean isExt(int index) {
        return getBit(aclTriState, index);
    }

    public String getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(String principalType) {
        this.principalType = principalType;
    }

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getAclState() {
        return aclState;
    }

    public void setAclState(int aclState) {
        this.aclState = aclState;
    }

    public int getAclTriState() {
        return aclTriState;
    }

    public void setAclTriState(int aclTriState) {
        this.aclTriState = aclTriState;
    }
}

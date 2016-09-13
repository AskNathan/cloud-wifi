package cn.cnsjwx.facade.permissions.vo;
import java.io.Serializable;
/**
 * 授权的信息
 * Created by Nathan on 2016-09-08.
 */
public class AuthVO implements Serializable {

    private static final long serialVersionUID = 300856628514768212L;

    /**资源的ID*/
    private String resourceId;


    /**操作存储索引*/
    private int operIndex;

    /**
     * 是否允许
     * 允许:true，
     * 拒绝:false
     */
    private boolean permit;

    /**
     * 是否继承
     * 继承:true
     * 不继承:false
     */
    private boolean ext;


    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public int getOperIndex() {
        return operIndex;
    }

    public void setOperIndex(int operIndex) {
        this.operIndex = operIndex;
    }

    public boolean isPermit() {
        return permit;
    }

    public void setPermit(boolean permit) {
        this.permit = permit;
    }

    public boolean isExt() {
        return ext;
    }

    public void setExt(boolean ext) {
        this.ext = ext;
    }
}

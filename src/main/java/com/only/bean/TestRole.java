package com.only.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：用户表
 * 表名：test_role
 */
public class TestRole implements Serializable
{
    //<editor-fold desc="属性">    

    /**
     * 描述：创建时间
     * 列名：create_time
     * 数据类型：datetime
     * 是否为NULL：YES
     */
    private Date createTime;

    /**
     * 描述：状态
     * 列名：state
     * 数据类型：int
     * 是否为NULL：NO
     */
    private Integer state;
    
    //</editor-fold>
    
    //<editor-fold desc="getter,setter">    
    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    //</editor-fold>

    //<editor-fold desc="常量">    

    /**
     * SqlMap文件对应的命名空间
     */
    public static String NAMESPACE="test_role";

    /**
     * 表名
     */
    public static String TABLE_NAME="test_role";

    /**
     * 创建时间对应的列名
     */
    public static String FIELD_CREATETIME="create_time";

    //</editor-fold>  
}

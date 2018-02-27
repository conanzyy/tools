
import java.io.Serializable;
import java.util.Date;

/**
* 描述：${tableDesc}
* 表名：${tableName}
*/
public class ${beanName} implements Serializable
{
    private static final long serialVersionUID = 1L;
    //region 属性

   <#list columnMapList as item>
    /**
    * 描述：${item.fieldDesc}
    * 列名：${item.fieldName}
    * 数据类型：${item.fieldType}
    * 是否为NULL：${item.fieldNullState}
    */
    private ${item.propertyType} ${item.propertyName};
   
   </#list>
    //endregion

    //region getter,setter
   <#list columnMapList as item>
    public ${item.propertyType} get${item.propertyNameFirstUpperCase}()
    {
        return ${item.propertyName};
    }

    public void set${item.propertyNameFirstUpperCase}(${item.propertyType} ${item.propertyName})
    {
        this.${item.propertyName} = ${item.propertyName};
    }
   </#list>
     //endregion

    
}

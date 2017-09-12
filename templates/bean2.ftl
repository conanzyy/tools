
import java.io.Serializable;
import java.util.Date;

/**
* 描述：${tableDesc}
* 表名：${tableName}
*/
public class ${beanName} implements Serializable
{
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

    //region 常量

    /**
    * SqlMap文件对应的命名空间
    */
    public static String NAMESPACE="${tableName}";

    /**
    * 表名
    */
    public static String TABLE_NAME="${tableName}";

    <#list columnMapList as item>
    /**
    * ${item.fieldDesc}对应的列名
    */
    public static String FIELD_${item.propertyNameFullUpperCase}="${item.propertyName}";
    </#list>

    //endregion
}

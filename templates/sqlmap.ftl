<sqlMap namespace="${tableName}" jdbcTimeout="5">
    <sql id="insert">
        <![CDATA[
        INSERT INTO ${tableName} 
        (
       <#list columnMapList as item>
       ${item.columnName},
       </#list>
        )
        VALUE
        (
    <#list columnMapList as item>
       :${item.propertyName},
    </#list>
        )
        ]]>
    </sql>

    <sql id="update">
        <![CDATA[
        UPDATE ${tableName}
        SET
    <#list columnMapList as item>
    ${item.columnName}=:${item.propertyName},
    </#list>
        ]]>
    </sql>

    <sql id="getAllList">
        <![CDATA[
        SELECT
    <#list columnMapList as item>
       ${item.columnName} ${item.propertyName},
    </#list>
        FROM
       ${tableName}
   
        ]]>
    </sql>

    


</sqlMap>
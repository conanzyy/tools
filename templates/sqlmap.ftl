<sqlMap namespace="${tableName}" jdbcTimeout="5">
    <sql id="insert${daoName}">
        <![CDATA[
        INSERT INTO ${tableName} 
        (
        <#list columnMapList as item>
            ${ifstr} ${item.propertyName}?exists && ${item.propertyName}!=""${rightkuohao}
                ${item.columnName},
            ${ifstrEnd}
        </#list>
        )
        VALUE
        (
        <#list columnMapList as item>
            ${ifstr} ${item.propertyName}?exists && ${item.propertyName}!=""${rightkuohao}
                :${item.propertyName},
            ${ifstrEnd}
        </#list>
        )
        ]]>
    </sql>

    <sql id="update${daoName}">
        <![CDATA[
        UPDATE ${tableName}
        SET
        <#list columnMapList as item>
            ${ifstr} ${item.propertyName}?exists && ${item.propertyName}!=""${rightkuohao}
                ${item.columnName}=:${item.propertyName},
            ${ifstrEnd}
        </#list>

        ]]>
    </sql>

    <sql id="getAllList${daoName}">
        <![CDATA[
        SELECT
        <#list columnMapList as item>
            a.${item.columnName} ${item.propertyName},
        </#list>
        FROM
            ${tableName} a
   
        ]]>
    </sql>


</sqlMap>
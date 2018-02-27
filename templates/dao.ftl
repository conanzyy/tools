 

 
 
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("${daoLowName}Business")
public class ${daoName}Business{
private static final String NAMESPACE = "${tableName}.";

public boolean insert${daoName}(${daoName}Entity ${daoLowName}Entity)
{
    Map<String, Object> paramMap =beanToMap(${daoLowName}Entity);
    int result= dalClient.execute(NAMESPACE+"insert${daoName}", paramMap);
    return result>0;
}



public boolean update${daoName}(${daoName}Entity ${daoLowName}Entity)
{
    Map<String, Object> paramMap =beanToMap(${daoLowName}Entity);
    int result= dalClient.execute(NAMESPACE+"update${daoName}", paramMap);
    return result>0;
}

 public List<${daoName}Entity> get${daoName}EntityList(${daoName}Entity ${daoLowName}Entity)
    {
    Map<String, Object> paramMap =beanToMap(${daoLowName}Entity);
    return dalClientRead.queryForList(NAMESPACE+"getAllList${daoName}",paramMap,${daoName}Entity.class);
    }

private Map<String,Object> beanToMap(${daoName}Entity entity) {
        Map<String,Object> paramMap= new HashMap<>();
        <#list columnMapList as item>
        paramMap.put("${item.key}",${item.value});
        </#list>
        return paramMap;
    }
}

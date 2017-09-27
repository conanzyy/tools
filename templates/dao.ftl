 

 
 
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("${daoLowName}Dao")
public class ${daoName}Dao{
private static final String NAMESPACE = "${tableName}.";

public boolean add(${daoName}Entity ${daoLowName}Entity)
{
Map<String, Object> paramMap =beanToMap(${daoLowName}Entity);
int result= dalClient.execute(NAMESPACE+"insert", paramMap);
return result>0;
}



public boolean update(${daoName}Entity ${daoLowName}Entity)
{
Map<String, Object> paramMap =beanToMap(${daoLowName}Entity);
int result= dalClient.execute(NAMESPACE+"update", paramMap);
return result>0;
}

 

private Map<String,Object> beanToMap(${daoName}Entity entity) {
Map<String,Object> paramMap= new HashMap<>();
<#list columnMapList as item>
paramMap.put("${item.key}",${item.value});
</#list>
return paramMap;
}
}

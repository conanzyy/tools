import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单元测试模版
 * @author 17021690 
 */
public class TemplateTest {
    
    
    @Test
    public void testCreateBean()
    {
        Class c=TaskOrd1erEntity1.class;
        //  TaskOrderEntity taskOrderEntity=new TaskOrderEntity();
        String modelName=toLowerCase(c.getSimpleName());
        String className=c.getSimpleName();
        StringBuilder sb= new StringBuilder(className+" "+modelName+" = new "+className+"();\r\n");
        Field[] fields= c.getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            String type=field.getType().getName();
            //        taskOrderEntity.setTaskStatus("");
            if ("java.lang.Integer".equals(type) || "int".equals(type)){
                sb.append(modelName+".set"+toUpperCase(field.getName())+"(0);\r\n");
            }
            else if ("java.lang.Long".equals(type) || "long".equals(type)){
                sb.append(modelName+".set"+toUpperCase(field.getName())+"(0L);\r\n");
            }
            else if ("java.lang.Short".equals(type) || "short".equals(type)){
                sb.append(modelName+".set"+toUpperCase(field.getName())+"(0L);\r\n");
            }
            else if ("java.lang.Byte".equals(type) || "byte".equals(type)){
                sb.append(modelName+".set"+toUpperCase(field.getName())+"(0L);\r\n");
            }
            else if ("java.lang.Double".equals(type) || "double".equals(type)){
                sb.append(modelName+".set"+toUpperCase(field.getName())+"(0);\r\n");
            }
            else if ("java.lang.Float".equals(type) || "float".equals(type)){
                sb.append(modelName+".set"+toUpperCase(field.getName())+"(0);\r\n");
            }
            else if ("java.lang.Boolean".equals(type) || "boolean".equals(type)){
                sb.append(modelName+".set"+toUpperCase(field.getName())+"(false);\r\n");
            }
            else if ("java.lang.Character".equals(type) || "char".equals(type)){
                sb.append(modelName+".set"+toUpperCase(field.getName())+"('');\r\n");
            }
            else if ("java.lang.String".equals(type)){
                sb.append(modelName+".set"+toUpperCase(field.getName())+"(\"\");\r\n");
            }
            else if ("java.util.Date".equals(type)){
                sb.append(modelName+".set"+toUpperCase(field.getName())+"(new Date());\r\n");
               
            }
            else{
                sb.append(modelName+".set"+toUpperCase(field.getName())+"();\r\n");
            }
            
        }
        System.out.println(sb.toString());
    }

    /**
     * 单元测试工具类模版
     */
    @Test
    public void testUtil(){
        Class c= AES.class;
        Map<String,Object> root=  new HashMap<>(16);
        List<Map<String,Object>> methodMapList= new ArrayList<>();
        root.put("packageName",c.getPackage().getName());
        root.put("methodMapList",methodMapList);
        root.put("className",c.getSimpleName());
        Method[] methods= c.getDeclaredMethods();
        for (Method method:methods) {
            if (method.getModifiers()== Modifier.PUBLIC){
                Map<String,Object> methodMap=  new HashMap<>(16);
                methodMap.put("testMethodName",toUpperCase(method.getName()));
                methodMap.put("methodName",method.getName());
                methodMapList.add(methodMap);
            }

        }
        System.out.println(FreeMarkerUtil.print("util.ftl",root));
    }


    /**
     * 单元测试Business模版
     */
    @Test
    public void testBusiness() {
        Class c= ExecuteTaskAlarmJob.class;
        Map<String,Object> root=  new HashMap<>(16);
        List<Map<String,Object>> methodMapList= new ArrayList<>();
        List<Map<String,Object>> fieldMapList= new ArrayList<>();
        root.put("packageName",c.getPackage().getName());
        root.put("className",c.getSimpleName());
        root.put("lowerClassName",toLowerCase(c.getSimpleName()));
        Method[] methods= c.getDeclaredMethods();
        Field[] fields=c.getDeclaredFields();
        for (Method method:methods) {
            if (method.getModifiers()== Modifier.PUBLIC){
                Map<String,Object> methodMap=  new HashMap<>(16);
                methodMap.put("testMethodName",toUpperCase(method.getName()));
                methodMap.put("methodName",method.getName());
                methodMapList.add(methodMap);
            }
           
        }
        root.put("methodMapList",methodMapList);
        for (Field field:fields){
            Annotation[] annotations=field.getAnnotations();
            if (annotations!=null &&annotations.length>0){
                Map<String,Object> fieldMap=  new HashMap<>(16);
                fieldMap.put("fieldClassName",field.getType().getSimpleName());
                fieldMap.put("fieldName",field.getName());
                fieldMapList.add(fieldMap);
            }
        }
        root.put("fieldMapList",fieldMapList);
        System.out.println(FreeMarkerUtil.print("business.ftl",root));
    }


    /**
     * 单元测试Controller模版
     */
    @Test
    public void testController() {
        Class c= HandleOrganizationConfController.class;
        Map<String,Object> root=  new HashMap<>(16);
        List<Map<String,Object>> methodMapList= new ArrayList<>();
        List<Map<String,Object>> fieldMapList= new ArrayList<>();
        root.put("packageName",c.getPackage().getName());
        root.put("className",c.getSimpleName());
        root.put("lowerClassName",toLowerCase(c.getSimpleName()));
        Method[] methods= c.getDeclaredMethods();
        Field[] fields=c.getDeclaredFields();
        for (Method method:methods) {
            if (method.getModifiers()== Modifier.PUBLIC){
                Map<String,Object> methodMap=  new HashMap<>(16);
                methodMap.put("testMethodName",toUpperCase(method.getName()));
                methodMap.put("methodName",method.getName());
                methodMapList.add(methodMap);
            }
    
        }
        root.put("methodMapList",methodMapList);
        for (Field field:fields){
            Annotation[] annotations=field.getAnnotations();
            if (annotations!=null &&annotations.length>0){
                Map<String,Object> fieldMap=  new HashMap<>(16);
                fieldMap.put("fieldClassName",field.getType().getSimpleName());
                fieldMap.put("fieldName",field.getName());
                fieldMapList.add(fieldMap);
            }
        }
        root.put("fieldMapList",fieldMapList);
        System.out.println(FreeMarkerUtil.print("controller.ftl",root));
    }
    

    /**
     * 将单词的首字母大写
     * @param old
     * @return
     */
    private  String toUpperCase(String old){
        String str = old.substring(0,1).toUpperCase() + old.substring(1) ;
        return str ;
    }

    /**
     * 将单词的首字母小写
     * @param old
     * @return
     */
    private  String toLowerCase(String old){
        String str = old.substring(0,1).toLowerCase() + old.substring(1) ;
        return str ;
    }

 
}
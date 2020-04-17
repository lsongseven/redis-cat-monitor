package club.tinysme.lsongseven.redis.cat.monitor;

import java.util.HashMap;
import java.util.Map;


public class ClassConfig {

    private static Map<String, ClassMethodNameInfo> classMethodNameInfoList = new HashMap<>();

    static {
        classMethodNameInfoList.put(ValueOperationsInfo.getInfo().getClassName(), ValueOperationsInfo.getInfo());
        classMethodNameInfoList.put(ListOperationsInfo.getInfo().getClassName(), ListOperationsInfo.getInfo());
        classMethodNameInfoList.put(SetOperationsInfo.getInfo().getClassName(), SetOperationsInfo.getInfo());
        classMethodNameInfoList.put(ZsetOperationsInfo.getInfo().getClassName(), ZsetOperationsInfo.getInfo());
        classMethodNameInfoList.put(HashOperationsInfo.getInfo().getClassName(), HashOperationsInfo.getInfo());
        classMethodNameInfoList.put(RedisTemplateInfo.getInfo().getClassName(), RedisTemplateInfo.getInfo());
        classMethodNameInfoList.put(ScriptExecutorInfo.getInfo().getClassName(), ScriptExecutorInfo.getInfo());

    }

    public static ClassMethodNameInfo get(String className) {
        return classMethodNameInfoList.get(className);
    }
}

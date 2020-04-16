package club.tinysme.lsongseven.redis.cat.monitor;

public class RedisTemplate {
    public static ClassMethodNameInfo getInfo() {
        ClassMethodNameInfo classMethodNameInfo = new ClassMethodNameInfo("org/springframework/data/redis/core/RedisTemplate;", "other");
        classMethodNameInfo.addMethodName("execute");
        classMethodNameInfo.addMethodName("delete");
        classMethodNameInfo.addMethodName("hasKey");
        classMethodNameInfo.addMethodName("expire");
        classMethodNameInfo.addMethodName("rename");
        classMethodNameInfo.addMethodName("type");
        classMethodNameInfo.addMethodName("keys");
        return classMethodNameInfo;
    }
}

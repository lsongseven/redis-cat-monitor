package club.tinysme.lsongseven.redis.cat.monitor;

public class ValueOperationsInfo {

    public static ClassMethodNameInfo getInfo() {
        ClassMethodNameInfo classMethodNameInfo = new ClassMethodNameInfo("org/springframework/data/redis/core/DefaultValueOperations", "string");
        classMethodNameInfo.addMethodName("set");
        classMethodNameInfo.addMethodName("setIfAbsent");
        classMethodNameInfo.addMethodName("multiSet");
        classMethodNameInfo.addMethodName("multiSetIfAbsent");
        classMethodNameInfo.addMethodName("get");
        classMethodNameInfo.addMethodName("getAndSet");
        classMethodNameInfo.addMethodName("multiGet");
        classMethodNameInfo.addMethodName("increment");
        classMethodNameInfo.addMethodName("decrement");
        classMethodNameInfo.addMethodName("append");
        classMethodNameInfo.addMethodName("size");
        classMethodNameInfo.addMethodName("setBit");
        classMethodNameInfo.addMethodName("getBit");
        classMethodNameInfo.addMethodName("bitField");
        return classMethodNameInfo;
    }
}

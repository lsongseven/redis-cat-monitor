package club.tinysme.lsongseven.redis.cat.monitor;

public class ScriptExecutorInfo {
    public static ClassMethodNameInfo getInfo() {
        ClassMethodNameInfo classMethodNameInfo = new ClassMethodNameInfo("org/springframework/data/redis/core/script/DefaultScriptExecutor", "script");
        classMethodNameInfo.addMethodName("execute");
        return classMethodNameInfo;
    }
}

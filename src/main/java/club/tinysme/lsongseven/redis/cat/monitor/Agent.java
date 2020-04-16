package club.tinysme.lsongseven.redis.cat.monitor;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;

import java.io.ByteArrayInputStream;
import java.lang.instrument.Instrumentation;

public class Agent {

    static String packageName = "club.tinysme.lsongseven.hello.world";

    public static void premain(String agentArgs, Instrumentation inst) {


        inst.addTransformer((classLoader, s, aClass, protectionDomain, bytes) -> {
            byte[] transformed = null;
            CtClass cl = null;
            try {
                ClassPool pool = new ClassPool();
                pool.insertClassPath(new LoaderClassPath(Thread.currentThread().getContextClassLoader()));
                pool.importPackage(packageName);
                cl = pool.makeClass(new ByteArrayInputStream(bytes));
                CtMethod[] methods = cl.getDeclaredMethods();

                for (CtMethod method : methods) {
                    if ("main".equals(method.getName())) {
                        method.insertBefore("System.out.println(\"<-----------before------->\");");
                        method.insertAfter("System.out.println(\"<-----------end------->\");");
                    }
                }
                transformed = cl.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (cl != null) {
                    cl.detach();
                }
            }
            return transformed;

        });
    }
}

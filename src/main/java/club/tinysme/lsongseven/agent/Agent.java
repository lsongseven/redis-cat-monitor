package club.tinysme.lsongseven.agent;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;

import java.io.ByteArrayInputStream;
import java.lang.instrument.Instrumentation;
import java.util.Objects;

public class Agent {

    static String packageName = "club.tinysme.lsongseven.hello.world";

    public static void premain(String agentArgs, Instrumentation inst) {

//        inst.addTransformer((loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
//            CtClass cl = null;
//            byte[] transformed = null;
//            try {
//                ClassPool pool = new ClassPool();
////                pool.insertClassPath(new LoaderClassPath(loader));
//                pool.insertClassPath(new LoaderClassPath(Thread.currentThread().getContextClassLoader()));
//                pool.importPackage(packageName);
//                cl = pool.makeClass(new ByteArrayInputStream(classfileBuffer));
//                CtMethod[] methods = cl.getDeclaredMethods();
//
//                for(CtMethod method:methods){
//                    if("main".equals(method.getName())){
//                        method.insertBefore(before("hello world what to do before"));
//                        method.insertAfter(after());
//                    }
//                }
//                transformed = cl.toBytecode();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (cl != null) {
//                    cl.detach();
//                }
//            }
//            return  transformed;
//        });


        inst.addTransformer((classLoader, s, aClass, protectionDomain, bytes) -> {
            if (Objects.nonNull(ClassConfig.get(s))) {
                ClassMethodNameInfo classMethodNameInfo = ClassConfig.get(s);
                byte[] transformed = null;
                CtClass cl = null;
                try {
                    ClassPool pool = new ClassPool();
                    pool.insertClassPath(new LoaderClassPath(Thread.currentThread().getContextClassLoader()));
                    pool.appendClassPath(new LoaderClassPath(classLoader));
                    pool.importPackage(packageName);
                    cl = pool.makeClass(new ByteArrayInputStream(bytes));
                    CtMethod[] methods = cl.getDeclaredMethods();
                    System.out.println(cl.getName());
                    for (int i = 0; i < methods.length; i++) {
                        if (classMethodNameInfo.containsMethod(methods[i].getName())) {
                            String methodName = methods[i].getName();
                            CtClass etype = ClassPool.getDefault().get("java.lang.Throwable");
                            methods[i].addCatch("{ RedisCatMonitor.end(false); throw $e; }", etype);
                            methods[i].insertBefore(before(classMethodNameInfo.getType() + "-" + methodName));
                            methods[i].insertAfter(after());
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
            }
            return null;
        });
    }

    public static String before(String action) {
        return String.format("try { RedisCatMonitor.start(\"%s\", $1); } catch (Throwable e) {}", action);
    }

    public static String after() {
        return "try{ RedisCatMonitor.end(true);} catch (Throwable e) {}";
    }

}

//package club.tinysme.lsongseven.agent;
//
//import java.util.Objects;
//
//
//public class RedisCatMonitor {
//
//    public static final ThreadLocal<RedisCatMonitor> THREAD_LOCAL_CAT_LOG = new ThreadLocal<>();
//
//    public static void start(String action, Object data) {
//        THREAD_LOCAL_CAT_LOG.remove();
//        RedisCatMonitor redisCatMonitor = new RedisCatMonitor(action);
//        redisCatMonitor.before(String.valueOf(data));
//        THREAD_LOCAL_CAT_LOG.set(redisCatMonitor);
//    }
//
//    public static void end(boolean success) {
//        RedisCatMonitor redisCatMonitor = THREAD_LOCAL_CAT_LOG.get();
//        if (Objects.nonNull(redisCatMonitor)) {
//            redisCatMonitor.after(success);
//            THREAD_LOCAL_CAT_LOG.remove();
//        }
//    }
//
//    private String action;
//    private Transaction tranx;
//
//    public RedisCatMonitor(String action) {
//        this.action = action;
//    }
//
//    public void before(String data) {
//        this.tranx = Cat.newTransaction("RedisTemplateInfo.", this.action);
//        this.tranx.addData("key", data);
//    }
//
//    public void after(boolean success) {
//        if (!success) {
//            this.tranx.setStatus("failed");
//        } else {
//            this.tranx.setStatus("0");
//        }
//        this.tranx.complete();
//    }
//}

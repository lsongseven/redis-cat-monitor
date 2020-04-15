This repository is used to track the method invocation of RedisTemplate using CAT(inspired by https://github.com/zhyzhyzhy/CatRedisLogAspect).

Actually the repositroy produce a agent.jar. Developers should place the RedisCatMonitor.class into their project. And then start the project either by using commandline "java -javaagent:xxx/agent.jar -jar YourJar.jar" or by adding "-javaagent:xxx/agent.jar" to your IDE's vmoptions.

Note that the RedisCatMonitor.class should be unecessary in this project. It should be placed into your own project.



This repository is used to track the method invocation of RedisTemplate using CAT(inspired by https://github.com/zhyzhyzhy/CatRedisLogAspect).

Actually the repositroy produce a agent.jar. Developers should place the RedisCatMonitor.class into their project. And then start the project either by using commandline "java -javaagent:xxx/agent.jar=agentArgs -jar YourJar.jar" or by adding "-javaagent:xxx/agent.jarr=agentArgs" to your IDE's vmoptions. Here the agentArgs is a package name, and the package contains RedisCatMonitor.class. The agent first import the package, and then insert some codes into the method in the target class. Here the "some code" may be like
```
  RedisCatMonitor.start(someString);
```
Because the agent has imported the package which RedisCatMonitor.class reside in, the generated class won't complain that it cannot resolving something.

Note that the RedisCatMonitor.class should be unecessary in this project. It should be placed into your own project.



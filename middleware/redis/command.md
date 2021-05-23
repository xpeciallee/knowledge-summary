https://www.redis.net.cn/order/3546.html

```
redis-server.exe redis.windows.conf
redis-cli.exe
```
https://www.cnblogs.com/javalanguage/p/12401829.html
https://zhuanlan.zhihu.com/p/58038188
`
1. Redis是纯内存数据库，一般都是简单的存取操作，线程占用的时间很多，时间的花费主要集中在IO上，所以读取速度快。

2. 再说一下IO，Redis使用的是非阻塞IO，IO多路复用，使用了单线程来轮询描述符，将数据库的开、关、读、写都转换成了事件，减少了线程切换时上下文的切换和竞争。

3. Redis采用了单线程的模型，保证了每个操作的原子性，也减少了线程的上下文切换和竞争。

4. 另外，数据结构也帮了不少忙，Redis全程使用hash结构，读取速度快，还有一些特殊的数据结构，对数据存储进行了优化，如压缩表，对短数据进行压缩存储，再如，跳表，使用有序的数据结构加快读取的速度。

5. 还有一点，Redis采用自己实现的事件分离器，效率比较高，内部采用非阻塞的执行方式，吞吐能力比较大。
`
![img_2.png](img_2.png)

Stack(栈)=LPUSH + LPOP
Queue(队列)=LPUSH + RPOP
Blocking MQ(阻塞队列) + LPUSH + BRPOP
![img.png](img.png)
![img_3.png](img_3.png)
![img_1.png](img_1.png)
![img_4.png](img_4.png)
![img_5.png](img_5.png)
![img_6.png](img_6.png)
![img_7.png](img_7.png)
![img_8.png](img_8.png)
![img_9.png](img_9.png)
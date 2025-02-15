
#### 这是一个非官方的社区维护的库。有bug欢迎朋友们指出，互相学习。本项目基于 [chatgpt-java增加了对o系列模型的支持](https://github.com/Grt1228/chatgpt-java)
#### 本项目会一直随着OpenAi模型的更新一直更新

### 💬 联系我，VX:YPK00101 ChatGPT相关学习交流咨询全部免费。

- [📖 项目简介](#-项目简介)
- [🚩 特性](#-特性)
- [📑 更新日志](#-更新日志)
- [🚀 快速开始](#-快速开始)
    - [方式一](#方式一)
        - [1、导入pom依赖](#1导入pom依赖)
        - [2、流式客户端使用示例：](#2流式客户端使用示例)
            - [默认OkHttpClient](#默认okhttpclient)
            - [自定义OkHttpClient客户端使用示例：](#自定义okhttpclient客户端使用示例)
        - [3、默认客户端使用示例（支持全部API）：](#3默认客户端使用示例支持全部api)
            - [默认OkHttpClient](#默认okhttpclient-1)
            - [自定义OkHttpClient客户端使用示例：](#自定义okhttpclient客户端使用示例-1)
    - [方式二（下载源码直接运行）](#方式二下载源码直接运行)
- [❔ QA](#-qa)
- [🙏 鸣谢](#-鸣谢)
- [☕ 打赏](#-打赏)

# 📖 项目简介

**ChatGPT的Java客户端**
OpenAI官方Api的Java SDK，可以快速接入项目使用。支持OpenAI官方全部接口，**同时支持Tokens计算。参考文档：[Tokens_README.md](https://github.com/Grt1228/chatgpt-java/blob/main/Tokens_README.md)**。

| Assistant | Dall-e-3 | FineTuneJob | TTS | ChatCompletionWithPicture |
| --- | --- | --- | --- | --- |
| 自定义知识库、AI助理 | AI生成图片 | 微调job | 文本转语音 | 附加图片的ChatCompletion |

| TikToken | Chat | Completions | Images | Speech To Text | 余额查询 |
| --- | --- | --- | --- | --- | --- |
| Token计算 | GPT-3.5、4.0对话模型 | GPT-3.0对话 | 图片模型 | 语音转文字，语音翻译 | 余额查询


| Embeddings | Files | Moderations | Fine-tune | Models |
| --- | --- | --- | --- | --- |
| 嵌入 | 自定义训练模型 | 文本审核，敏感词鉴别 | 微调 | 模型检索相关 |

支持流式输出：
流式输出实现方式 | 小程序 | 安卓 | ios | H5
---|---|---|---|---
SSE参考：[OpenAISSEEventSourceListener](https://github.com/Grt1228/chatgpt-steam-output/blob/main/src/main/java/com/unfbx/chatgptsteamoutput/listener/OpenAISSEEventSourceListener.java) | 不支持| 支持| 支持 | 支持
WebSocket参考：[OpenAIWebSocketEventSourceListener](https://github.com/Grt1228/chatgpt-steam-output/blob/main/src/main/java/com/unfbx/chatgptsteamoutput/listener/OpenAIWebSocketEventSourceListener.java) | 支持| 支持| 支持| 支持

基于本SDK开发的Demo项目，整合Spring Boot 实现CahtGPT对话模式，思路可以参考：
**https://github.com/Grt1228/chatgpt-steam-output**

# 🚩 特性
- 支持附加图片的ChatCompletion、指定返回数据格式、Tool Call、Dall-e-3生成图片、FineTuneJob、文本转语音TTS。
- 支持GPT插件模式 参考实现[PluginTest](https://github.com/Grt1228/chatgpt-java/blob/develop/src/test/java/com/unfbx/chatgpt/PluginTest.java)
- 支持当key异常（失效、过期、封禁）时，自定义动态处理key 参考实现[DynamicKeyOpenAiAuthInterceptor](https://github.com/Grt1228/chatgpt-java/blob/main/src/main/java/com/unfbx/chatgpt/interceptor/DynamicKeyOpenAiAuthInterceptor.java)
- 支持当key异常时的告警处理（钉钉、飞书、email、企业微信等等需要自定义开发）参考实现[DynamicKeyOpenAiAuthInterceptor](https://github.com/Grt1228/chatgpt-java/blob/main/src/main/java/com/unfbx/chatgpt/interceptor/DynamicKeyOpenAiAuthInterceptor.java)
- 支持多种Tokens计算方式
- 支持自定义OkhttpClient
- 支持自定义多Apikey
- 支持自定义ApiKey的获取策略
- 支持余额查询
- 支持个人账户信息查询
- 支持GPT3、GPT3.5、GPT4.0、GPT3.5—0614、GPT4.0—0614...
- 支持全部OpenAI的Api

# 📑 更新日志
- [x] 2.0.1   支持对o系类模型的支持（o1 o1-mini o3-mini）使用O系列模型只需要把 ChatCompletion类替换为  ChatOCompletion 其它地方不变 O系类模型目前不支持提示词

# 🚀 快速开始
本项目支持**默认输出**和**流式输出**。完整SDK测试案例参考：

SDK测试案例 | Tokens计算测试案例 | 完整Function-Call调用案例
---| --- | ---
[OpenAiClientTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/OpenAiClientTest.java) 和[OpenAiStreamClientTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/OpenAiStreamClientTest.java) | Tokens计算参考：[TikTokensTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/TikTokensTest.java) | [OpenAiClientFunctionTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/OpenAiClientFunctionTest.java)

## 方式一

### 1、导入pom依赖
```
        <dependency>
            <groupId>io.github.xu768212312</groupId>
            <artifactId>chatgpt-java-sdk</artifactId>
            <version>2.0.1</version>
        </dependency>
```
### 2、流式客户端使用示例：
更多SDK示例参考：[OpenAiStreamClientTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/OpenAiStreamClientTest.java)
#### 默认OkHttpClient
```
public class Test {
    public static void main(String[] args) {
        OpenAiStreamClient client = OpenAiStreamClient.builder()
                .apiKey(Arrays.asList("sk-********","sk-********"))
                //自定义key的获取策略：默认KeyRandomStrategy
                //.keyStrategy(new KeyRandomStrategy())
                .keyStrategy(new FirstKeyStrategy())
                //自己做了代理就传代理地址，没有可不不传
//                .apiHost("https://自己代理的服务器地址/")
                .build();
        //聊天模型：gpt-3.5
        ConsoleEventSourceListener eventSourceListener = new ConsoleEventSourceListener();
        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(Arrays.asList(message)).build();
        client.streamChatCompletion(chatCompletion, eventSourceListener);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
#### 自定义OkHttpClient客户端使用示例：
```
public class Test {
    public static void main(String[] args) {
        //国内访问需要做代理，国外服务器不需要
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
        //！！！！千万别再生产或者测试环境打开BODY级别日志！！！！
        //！！！生产或者测试环境建议设置为这三种级别：NONE,BASIC,HEADERS,！！！
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .proxy(proxy)//自定义代理
                .addInterceptor(httpLoggingInterceptor)//自定义日志
                .connectTimeout(30, TimeUnit.SECONDS)//自定义超时时间
                .writeTimeout(30, TimeUnit.SECONDS)//自定义超时时间
                .readTimeout(30, TimeUnit.SECONDS)//自定义超时时间
                .build();
        OpenAiStreamClient client = OpenAiStreamClient.builder()
                .apiKey(Arrays.asList("sk-********","sk-********"))
                //自定义key的获取策略：默认KeyRandomStrategy
                //.keyStrategy(new KeyRandomStrategy())
                .keyStrategy(new FirstKeyStrategy())
                .okHttpClient(okHttpClient)
                //自己做了代理就传代理地址，没有可不不传
//                .apiHost("https://自己代理的服务器地址/")
                .build();
    }
}
```
输出日志（text是持续输出的）：
```
23:03:59.158 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI建立sse连接...
23:03:59.160 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\n", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.172 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\n", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.251 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\u5fc3", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.313 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\u60c5", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.380 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\u8212", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.439 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\u7545", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.532 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\uff0c", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.579 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\u5fc3", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.641 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\u65f7", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.673 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\u795e", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.751 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\u6021", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.782 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：{"id": "cmpl-6pIHnOOJiiUEVMesXwxzzcSQFoZHj", "object": "text_completion", "created": 1677683039, "choices": [{"text": "\u3002", "index": 0, "logprobs": null, "finish_reason": null}], "model": "text-davinci-003"}
23:03:59.815 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据：[DONE]
23:03:59.815 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI返回数据结束了
23:03:59.815 [省略无效信息] INFO com.unfbx.chatgpt.sse.ConsoleEventSourceListener - OpenAI关闭sse连接...
```
### 3、默认客户端使用示例（支持全部API）：
更多SDK示例参考：[OpenAiClientTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/OpenAiClientTest.java)
#### 默认OkHttpClient
```
public class Test {
    public static void main(String[] args) {
        OpenAiClient openAiClient = OpenAiClient.builder()
                .apiKey(Arrays.asList("sk-********","sk-********"))
                //自定义key的获取策略：默认KeyRandomStrategy
                //.keyStrategy(new KeyRandomStrategy())
                .keyStrategy(new FirstKeyStrategy())
                //自己做了代理就传代理地址，没有可不不传
//                .apiHost("https://自己代理的服务器地址/")
                .build();
                //聊天模型：gpt-3.5
        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(Arrays.asList(message)).build();
        ChatCompletionResponse chatCompletionResponse = openAiClient.chatCompletion(chatCompletion);
        chatCompletionResponse.getChoices().forEach(e -> {
            System.out.println(e.getMessage());
        });
    }
}
```
#### 自定义OkHttpClient客户端使用示例：
```
public class Test {
    public static void main(String[] args) {
        //国内访问需要做代理，国外服务器不需要
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
        //！！！！千万别再生产或者测试环境打开BODY级别日志！！！！
        //！！！生产或者测试环境建议设置为这三种级别：NONE,BASIC,HEADERS,！！！
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .proxy(proxy)//自定义代理
                .addInterceptor(httpLoggingInterceptor)//自定义日志输出
                .addInterceptor(new OpenAiResponseInterceptor())//自定义返回值拦截
                .connectTimeout(10, TimeUnit.SECONDS)//自定义超时时间
                .writeTimeout(30, TimeUnit.SECONDS)//自定义超时时间
                .readTimeout(30, TimeUnit.SECONDS)//自定义超时时间
                .build();
        //构建客户端
        OpenAiClient openAiClient = OpenAiClient.builder()
                .apiKey(Arrays.asList("sk-********","sk-********"))
                //自定义key的获取策略：默认KeyRandomStrategy
                //.keyStrategy(new KeyRandomStrategy())
                .keyStrategy(new FirstKeyStrategy())
                .okHttpClient(okHttpClient)
                //自己做了代理就传代理地址，没有可不不传
//                .apiHost("https://自己代理的服务器地址/")
                .build();
                //聊天模型：gpt-3.5
        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(Arrays.asList(message)).build();
        ChatCompletionResponse chatCompletionResponse = openAiClient.chatCompletion(chatCompletion);
        chatCompletionResponse.getChoices().forEach(e -> {
            System.out.println(e.getMessage());
        });
    }
}
```
## 方式二（下载源码直接运行）
下载源码打包
#  QA
Q | A
---|---
如何实现连续对话？ | issues：https://github.com/Grt1228/chatgpt-java/issues/8
如何实现流式输出？ | 升级1.0.2版本，参考源码：[OpenAiStreamClientTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/OpenAiStreamClientTest.java/)
如何整合SpringBoot实现流式输出的Api接口？ | 参考另外一个项目：[chatgpt-steam-output](https://github.com/Grt1228/chatgpt-steam-output)
最新版GPT-3.5-TURBO是否支持？ | 升级1.0.3 已经支持ChatCompletion, 参考测试案例：[OpenAiStreamClientTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/OpenAiStreamClientTest.java/) 和[OpenAiStreamClientTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/OpenAiClientTest.java/)
最新版语言转文字和语言翻译是否支持？ | 升级1.0.3 已经支持whisper参考测试案例：[OpenAiStreamClientTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/OpenAiStreamClientTest.java/) 和[OpenAiStreamClientTest](https://github.com/Grt1228/chatgpt-java/blob/main/src/test/java/com/unfbx/chatgpt/OpenAiClientTest.java/)





# 🙏 鸣谢
站在巨人的肩膀：
- OpenAi：https://openai.com/
- [knuddelsgmbh](https://github.com/knuddelsgmbh) 的[jtokkit](https://github.com/knuddelsgmbh/jtokkit) 的开源计算算法。


# ☕ 打赏
如果项目对你有帮助，可以选择请我喝杯奶茶

<img width="180" alt="微信截图_20230405222411" src="https://img.wilmer.com.cn/fp/44f373a2-e523-41b0-8d8b-407f11108ce0.jpg">  <img width="164" alt="微信截图_20230405222357" src="https://img.wilmer.com.cn/fp/17d706a8-8713-4724-96b5-3805ecdcbd6d.jpg">

开源协议：[LICENSE](https://github.com/Grt1228/chatgpt-java/blob/main/LICENSE) 

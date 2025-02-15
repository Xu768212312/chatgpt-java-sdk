package com.unfbx.chatgpt.sse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import java.util.Objects;

/**
 * 描述： sse
 */
@Slf4j
public class ConsoleEventSourceListener extends EventSourceListener {

    @Override
    public void onOpen(EventSource eventSource, Response response) {
        log.info("OpenAI建立sse连接...");
    }

    @SneakyThrows
    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
//        log.info("OpenAI返回数据：{}", data);
        if ("[DONE]".equals(data)) {
            log.info("OpenAI返回数据结束了");
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        // 读取Json
        ChatCompletionResponse completionResponse = mapper.readValue(data, ChatCompletionResponse.class);
        String returnData = mapper.writeValueAsString(completionResponse.getChoices().get(0).getDelta());
        System.err.println(mapper.writeValueAsString(completionResponse.getChoices().get(0)));
//        String content = completionResponse.getChoices().get(0).getDelta().getContent();
//        System.err.println(returnData);
//        System.err.println(content);
    }

    @Override
    public void onClosed(EventSource eventSource) {
        log.info("OpenAI关闭sse连接...");
    }

    @SneakyThrows
    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        if(Objects.isNull(response)){
            log.error("OpenAI  sse连接异常:{}", t);
            eventSource.cancel();
            return;
        }
        ResponseBody body = response.body();
        if (Objects.nonNull(body)) {
            log.error("OpenAI  sse连接异常data：{}，异常：{}", body.string(), t);
        } else {
            log.error("OpenAI  sse连接异常data：{}，异常：{}", response, t);
        }
        eventSource.cancel();
    }
}

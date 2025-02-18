package com.unfbx.chatgpt.entity.engines;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Engine implements Serializable {

    private String id;
    private String object;
    private String owner;
    private boolean ready;
    private Object permissions;
    private long created;

}

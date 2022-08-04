package com.ljl.zhsx.pojo.key_;

import lombok.Data;

/**
 * @author L.J.L
 * @QQ 963314043
 * @date 2022/8/4 12:06
 */
@Data
public class CodeLoginKey {
    private Long id;
    private String eventKey;
    private String openId;

    public CodeLoginKey(String eventKey, String openId) {
        this.eventKey = eventKey;
        this.openId = openId;
    }


}

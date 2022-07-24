package com.ljl.zhsx.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author L.J.L
 * @qq 963314043
 * @date 2022/6/13 21:42
 */
public interface OssService {

    String uploadFileAvatar(MultipartFile file);

}

package com.ula.content.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class StorageUtil
{

    @Value("${content.path}")
    private String contentPath;

    @Value("${content.folders}")
    private String[] folders;

}

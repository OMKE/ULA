package org.ula.core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseController
{

    @Autowired
    private Sanitizer sanitizer;


    protected String sanitize(String unsafeString)
    {
        return sanitizer.sanitize(unsafeString);
    }
}

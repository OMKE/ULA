package com.ula.teacher.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreAndUpdateSubjectNotificationRequest
{
    // validation is done in Faculty Service and we're only returning Response object from faculty service
    private Long subjectId;
    private Long typeId;
    private String text;
}

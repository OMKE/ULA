package com.ula.faculty.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreAndUpdateSubjectNotificationRequest
{
    @NotNull(message = "Subject id is required")
    @Min(value = 1, message = "Subject id can not be lower than 1")
    private Long subjectId;


    @NotNull(message = "Type id is required")
    @Min(value = 1, message = "Type id can not be lower than 1")
    private Long typeId;

    @NotEmpty(message = "Notification message is required")
    @Size(min = 10, message = "Notification message must be at least 10 characters long")
    @Size(max = 64, message = "Notification message can not be longer than 64 characters")
    private String text;
}

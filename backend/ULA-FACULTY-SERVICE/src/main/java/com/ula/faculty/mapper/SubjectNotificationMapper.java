package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.SubjectNotification;
import com.ula.faculty.dto.model.SubjectNotificationDTO;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectNotificationMapper
{
    public static SubjectNotificationDTO map(SubjectNotification subjectNotification)
    {
        return new SubjectNotificationDTO()
                    .setId(subjectNotification.getId())
                    .setSubjectName(subjectNotification.getSubjectRealization().getSubject().getName())
                    .setText(subjectNotification.getText())
                    .setType(subjectNotification.getType().getName())
                    .setTime(subjectNotification.getCreatedAt());
    }

    public static List<SubjectNotificationDTO> map(List<SubjectNotification> subjectNotifications)
    {
        return subjectNotifications.stream().map(SubjectNotificationMapper::map).collect(Collectors.toList());
    }
}

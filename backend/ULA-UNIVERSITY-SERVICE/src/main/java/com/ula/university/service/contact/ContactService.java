package com.ula.university.service.contact;

import com.ula.university.dto.model.ContactDTO;
import com.ula.university.service.exception.LocationNotFoundException;

public interface ContactService
{
    ContactDTO index() throws LocationNotFoundException;
}

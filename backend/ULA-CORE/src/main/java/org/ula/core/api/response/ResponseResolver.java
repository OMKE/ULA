package org.ula.core.api.response;

public class ResponseResolver
{

    public static <T> Response<Object> resolve(T object)
    {
        if (object == null)
        {
            return Response.exception().setErrors("Not found");
        } else {
            return Response.ok().setPayload(object);
        }
    }
}

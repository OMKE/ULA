package com.ula.authentication.util;

import java.util.ArrayList;
import java.util.Arrays;

public class RoleResolver
{
    // Gets roles in form:
    // case-1: USER
    // case-2: [USER,ADMIN]
    // case-3: USER,ADMIN
    private String value;

    private ArrayList<String> roles = new ArrayList<>();

    public RoleResolver(String value)
    {
        this.value = value;
        this.resolve();
    }

    private void resolve()
    {
        // Check if it's list (separated by comma, or it's closed with brackets), else if there is just one role add as one role
        if(this.value.contains("[") && this.value.contains(",") && this.value.contains("]")) {
            this.value = this.value.replace("[", "").replace("]", "");

            this.roles.addAll(Arrays.asList(Arrays.stream(this.value.split(",")).map(String::trim).toArray(String[]::new)));
        } else if (!this.value.contains("[") && this.value.contains("]"))
        {
            throw new IllegalArgumentException("@Authorized annotation is missing opening bracket");
        } else if (this.value.contains("[") && !this.value.contains("]"))
        {
            throw new IllegalArgumentException("@Authorized annotation is missing closing bracket");
        } else if (this.value.contains(",") && !this.value.contains("[") && !this.value.contains("]"))
        {
            // if for some reason we only separated roles with commas (without brackets) throwing exception would be unnecessary
            this.roles.addAll(Arrays.asList(this.value.split(",")));
        }
        else {
            this.roles.add(this.value);
        }
    }


    public ArrayList<String> getRoles() { return this.roles; }


}

package com.ula.dtos;

import com.ula.models.User;

public class UserDTO
{
    private Long id;
    private String username;
    private String email;
    private String profileImage;
    private String firstName;
    private String lastName;
    

    public UserDTO()
    {
        super();
    }

    public UserDTO(User user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.profileImage = user.getProfileImage();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        
    }
    public UserDTO(Long id, String username, String email, String profileImage, String firstName, String lastName)
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.profileImage = profileImage;
        this.firstName = firstName;
        this.lastName = lastName;
        
    }

    
    public Long getId() { return id; }
    public void setId (Long id){ this.id = id; }
    public String getUsername() { return username; }
    public void setUsername (String username){ this.username = username; }
    public String getEmail() { return email; }
    public void setEmail (String email){ this.email = email; }
    public String getProfileImage() { return profileImage; }
    public void setProfileImage (String profileImage){ this.profileImage = profileImage; }
    public String getFirstName() { return firstName; }
    public void setFirstName (String firstName){ this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName (String lastName){ this.lastName = lastName; }
    

    
}
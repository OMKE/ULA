    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("/me")
    public Response<Object> updateFirstAndLastName
    (
            Authentication authentication,
            @Valid @RequestBody UpdateUserFirstAndLastNameRequest updateUserFirstAndLastNameRequest,
            Errors errors
    )
    {
        UserDTO userDTO = new UserDTO()
                    .setUsername(authentication.getName())
                    .setFirstName(this.sanitize(updateUserFirstAndLastNameRequest.getFirstName()))
                    .setLastName(this.sanitize(updateUserFirstAndLastNameRequest.getLastName()));
        try {
            return Response.ok().setPayload(this.userService.update(userDTO));
        } catch (UserNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }

    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("/me/change-password")
    public Response<Object> updatePassword
    (
                    Authentication authentication,
                    @Valid @RequestBody UpdateUserPasswordRequest updateUserPasswordRequest,
                    Errors errors
    )
    {
        UserDTO userDTO = new UserDTO()
                    .setUsername(authentication.getName())
                    .setPassword(passwordEncoder.encode(updateUserPasswordRequest.getPassword()));

        try {
            userService.checkForPasswords(updateUserPasswordRequest.getPassword(), updateUserPasswordRequest.getConfirmPassword());
            userService.checkForOldPassword(authentication.getName(), updateUserPasswordRequest.getOldPassword());
            return Response.ok().setPayload(userService.updatePassword(userDTO));
        } catch (PasswordsDontMatchException | UserException | UserNotFoundException | WrongOldPasswordException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

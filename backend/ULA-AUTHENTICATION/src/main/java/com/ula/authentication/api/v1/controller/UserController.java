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

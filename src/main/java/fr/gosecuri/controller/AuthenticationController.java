package fr.gosecuri.controller;

import fr.gosecuri.view.AuthenticationPage;

public class AuthenticationController {
    private AuthenticationPage authenticationPage;

    public AuthenticationController(AuthenticationPage authenticationPage) {
        this.authenticationPage = authenticationPage;
    }

    public AuthenticationPage getAuthenticationPage() {
        return authenticationPage;
    }
    public void setAuthenticationPage(AuthenticationPage authenticationPage) {
        this.authenticationPage = authenticationPage;
    }
}

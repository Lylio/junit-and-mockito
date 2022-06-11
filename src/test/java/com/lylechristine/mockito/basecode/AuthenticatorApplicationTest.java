package com.lylechristine.mockito.basecode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthenticatorApplicationTest {

    @Test
    public void isAuthenticated() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        String username = "Soda";
        String password = "easypass";

        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);

        when(authenticatorMock.authenticateUser(username, password))
                .thenReturn(false);

        boolean actual = authenticator.authenticate(username, password);
        Assertions.assertFalse(actual);

        verify(authenticatorMock).authenticateUser(username, password);

        // Verify that method has been called n times
        verify(authenticatorMock, times(1)).authenticateUser(username, password);
        verify(authenticatorMock, atLeastOnce()).authenticateUser(username, password);
        verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
        verify(authenticatorMock, atMost(1)).authenticateUser(username, password);

        // Verify the call order of the authenticator's methods
        InOrder inOrder = inOrder(authenticatorMock);
        inOrder.verify(authenticatorMock).emptyMethod();
        inOrder.verify(authenticatorMock).authenticateUser(username, password);
    }
}

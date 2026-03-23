package io.github.mattheusffalbuquerque.duma.domains.user;

import org.springframework.stereotype.Service;

@Service
public class KeycloakService {
    
    public void updateUserInKeycloak(String keycloakId, String name, String email) {
        // Aqui você implementaria a lógica para atualizar o usuário no Keycloak
        // Isso pode envolver fazer uma chamada HTTP para a API do Keycloak
        // usando um cliente HTTP como RestTemplate ou WebClient.
    }
}

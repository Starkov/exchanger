package com.example.viewpreparer;

import com.example.entity.ClientEntity;
import com.example.repository.ClientRepository;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component(value = "menuPreparer")
public class MenuPreparer implements ViewPreparer {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void execute(Request request, AttributeContext attributeContext) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        ClientEntity client = clientRepository.findByEmail(email);
        attributeContext.putAttribute("items", new Attribute(client.getPurses()));
    }
}

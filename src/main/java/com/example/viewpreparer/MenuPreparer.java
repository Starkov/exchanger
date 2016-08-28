package com.example.viewpreparer;

import com.example.entity.ClientEntity;
import com.example.entity.PersonEntity;
import com.example.service.PersonService;
import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "menuPreparer")
public class MenuPreparer implements ViewPreparer {
    @Autowired
    private PersonService personService;

    @Override
    public void execute(Request request, AttributeContext attributeContext) {
        PersonEntity person = personService.getCurrentPerson();
        if (person instanceof ClientEntity) {
            attributeContext.putAttribute("items", new Attribute(((ClientEntity) person).getPurses()));
        }
    }
}

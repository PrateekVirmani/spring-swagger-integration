package com.learning.springswaggerintegration.controllers;

import com.learning.springswaggerintegration.models.Contact;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/contacts")
public class AddressController {

    ConcurrentHashMap<String, Contact> contactsMap = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Contact by Id", notes = "LookUp to get a Contact by its Id")
    public Contact getContact(@PathVariable String id){
        return contactsMap.get(id);
    }

    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return new ArrayList<>(contactsMap.values());

    }

    @PostMapping("/")
    public String addContact(@RequestBody Contact contact){
        contactsMap.put(contact.getId(), contact);
        return "Contact Added successfully for -" + contact.getName();
    }

}

package com.example.homework10and11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {
    private final com.example.homework10and11.ContactRepository contactRepository;
    private final com.example.homework10and11.GroupRepository groupRepository;

    public ContactService(ContactRepository contactRepository, GroupRepository groupRepository) {
        this.contactRepository = contactRepository;
        this.groupRepository = groupRepository;
    }

    @Transactional
    public void addContact(com.example.homework10and11.Contact contact) {
        contactRepository.save(contact);
    }

    @Transactional
    public void addGroup(com.example.homework10and11.Group group) {
        groupRepository.save(group);
    }

    @Transactional
    public void deleteContacts(long[] idList) {
        for (long id : idList)
            contactRepository.deleteById(id);
    }

    @Transactional
    public void deleteContact(com.example.homework10and11.Contact contact) {
        contactRepository.delete(contact);
    }

    @Transactional
    public void deleteGroup(com.example.homework10and11.Group group) {
        groupRepository.deleteById(group.getId());
    }

    @Transactional(readOnly = true)
    public List<com.example.homework10and11.Group> findGroups() {
        return groupRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<com.example.homework10and11.Contact> findAll(Pageable pageable) {
        return contactRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly = true)
    public List<com.example.homework10and11.Contact> findByGroup(com.example.homework10and11.Group group, Pageable pageable) {
        return contactRepository.findByGroup(group, pageable);
    }

    public List<com.example.homework10and11.Contact> findContactsByGroup(com.example.homework10and11.Group group) {
        return contactRepository.findContactsByGroup(group);
    }

    @Transactional(readOnly = true)
    public long countByGroup(com.example.homework10and11.Group group) {
        return contactRepository.countByGroup(group);
    }

    @Transactional(readOnly = true)
    public List<com.example.homework10and11.Contact> findByPattern(String pattern, Pageable pageable) {
        return contactRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly = true)
    public long count() {
        return contactRepository.count();
    }

    @Transactional(readOnly = true)
    public com.example.homework10and11.Group findGroup(long id) {
        return groupRepository.findById(id).get();
    }

    @Transactional
    public void reset() {
        groupRepository.deleteAll();
        contactRepository.deleteAll();

        com.example.homework10and11.Group group = new Group("Test");
        com.example.homework10and11.Contact contact;

        addGroup(group);

        for (int i = 0; i < 13; i++) {
            contact = new com.example.homework10and11.Contact(null, "Contact Name " + i, "Surname " + i, "1234567 " + i, "user " + i + " @test.com");
            addContact(contact);
        }
        for (int i = 0; i < 10; i++) {
            contact = new Contact(group, "Other Contact " + i, "OtherSurname " + i, "7654321 " + i, "user " + i + " @other.com");
            addContact(contact);
        }
    }
}

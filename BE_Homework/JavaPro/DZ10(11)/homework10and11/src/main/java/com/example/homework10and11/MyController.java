package com.example.homework10and11;

import ch.qos.logback.core.net.server.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.bytebuddy.description.method.MethodDescription;
import org.hibernate.jpa.internal.JpaComplianceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class MyController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 8;

    private final com.example.homework10and11.ContactService contactService;

    public MyController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<com.example.homework10and11.Contact> contacts = contactService
                .findAll(PageRequest.of(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("groups", contactService.findGroups());
        model.addAttribute("contacts", contacts);
        model.addAttribute("allPages", getPageCount());

        return "index";
    }

    @GetMapping("/reset")
    public String reset() {
        contactService.reset();
        return "redirect:/";
    }

    @GetMapping("/contact_add_page")
    public String contactAddPage(Model model) {
        model.addAttribute("groups", contactService.findGroups());
        return "contact_add_page";
    }

    @GetMapping("/group_add_page")
    public String groupAddPage() {
        return "group_add_page";
    }

    @GetMapping("/group/{id}")
    public String listGroup(
            @PathVariable(value = "id") long groupId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model) {
        com.example.homework10and11.Group group = (groupId != DEFAULT_GROUP_ID) ? contactService.findGroup(groupId) : null;
        if (page < 0) page = 0;

        List<com.example.homework10and11.Contact> contacts = contactService
                .findByGroup(group, PageRequest.of(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        model.addAttribute("groups", contactService.findGroups());
        model.addAttribute("contacts", contacts);
        model.addAttribute("byGroupPages", getPageCount(group));
        model.addAttribute("groupId", groupId);

        return "index";
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam String pattern, Model model) {
        model.addAttribute("groups", contactService.findGroups());
        model.addAttribute("contacts", contactService.findByPattern(pattern, null));

        return "index";
    }

    @PostMapping(value = "/contact/delete")
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            contactService.deleteContacts(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/contact/add")
    public String contactAdd(@RequestParam(value = "group") long groupId,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String phone,
                             @RequestParam String email) {
        com.example.homework10and11.Group group = (groupId != DEFAULT_GROUP_ID) ? contactService.findGroup(groupId) : null;

        com.example.homework10and11.Contact contact = new com.example.homework10and11.Contact(group, name, surname, phone, email);
        contactService.addContact(contact);

        return "redirect:/";
    }

    @PostMapping(value = "/group/add")
    public String groupAdd(@RequestParam String name) {
        contactService.addGroup(new com.example.homework10and11.Group(name));
        return "redirect:/";
    }

    // ДЗ 1 Удаление групы и контактов ChooseDeleteGroup страница выбора групи на удаление, deleteGroup удаление.
    @GetMapping("/delete_group")
    private String ChooseDeleteGroup(Model model) {
        model.addAttribute("groups", contactService.findGroups());
        return "delete_group";
    }

    @GetMapping("/delete_group/{id}")
    private String deleteGroup(Model model, @PathVariable(value = "id") long groupId) {
        com.example.homework10and11.Group group = contactService.findGroup(groupId);
        List<com.example.homework10and11.Contact> listOfContacts = contactService.findContactsByGroup(group);
        for (com.example.homework10and11.Contact c : listOfContacts) {
            contactService.deleteContact(c);
        }
        contactService.deleteGroup(group);
        return "redirect:/";
    }

    // ДЗ 2 добавление Контактов из JSON файла
    @GetMapping("/json")
    private String chooseJsonFile() {
        File json = new File("E:\\json.txt");
        try (Scanner sc = new Scanner(json)) {
            String temp = "";

            while (sc.hasNextLine()) {
                temp += sc.nextLine() + System.lineSeparator();
            }

            Gson gson = new GsonBuilder().create();
            Type type = new TypeToken<ArrayList<com.example.homework10and11.Contact>>() {
            }.getType();
            List<com.example.homework10and11.Contact> contactList = gson.fromJson(temp, type);

            for (Contact c: contactList) {
                System.out.println(c.toString());
                contactService.addContact(c);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/";
    }

    private long getPageCount() {
        long totalCount = contactService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getPageCount(Group group) {
        long totalCount = contactService.countByGroup(group);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
}

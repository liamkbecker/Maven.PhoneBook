package com.zipcodewilmington.phonebook;

import java.lang.reflect.Array;
import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<String, List<String>>();
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(phoneNumber);
        this.phonebook.put(name, temp);
    }

    public void addAll(String name, String... phoneNumbers) {
        ArrayList<String> temp = new ArrayList<String>();
        for(int i = 0; i < phoneNumbers.length; i++) {
            temp.add(phoneNumbers[i]);
        }
        this.phonebook.put(name, temp);
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber){
        for (Map.Entry<String, List<String>> entry : this.phonebook.entrySet()) {
            if(entry.getValue().contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> returnList = new ArrayList<>();
        for (String entry : this.phonebook.keySet()){
            returnList.add(entry);
        }
        return returnList;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}

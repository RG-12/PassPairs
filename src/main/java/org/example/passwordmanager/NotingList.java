package org.example.passwordmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotingList {
    private List<String> userID;
    private Map<String, String> passwords;

    public NotingList() {
        this.userID = new ArrayList<>();
        this.passwords = new HashMap<>();

    }

    public String get(String word) {
        return this.passwords.get(word);
    }

    public void add(String ids, String password) {
        if (!this.passwords.containsKey(ids)) {
            this.userID.add(ids);
        }

        this.passwords.put(ids, password);
    }


}

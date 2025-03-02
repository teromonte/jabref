package org.jabref.model.entry;

import org.jabref.model.database.BibDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntryLinkList {

    private static String SEPARATOR = ",";

    private EntryLinkList() {
    }

    public static List<ParsedEntryLink> parse(String fieldValue, BibDatabase database) {
        List<ParsedEntryLink> result = new ArrayList<>();
        if ((fieldValue != null) && !fieldValue.isEmpty()) {
            String[] entries = fieldValue.split(SEPARATOR);

            for (String entry : entries) {
                System.out.println(entry);
                result.add(new ParsedEntryLink(entry, database));
            }
        }
        return result;
    }

    public static String serialize(List<ParsedEntryLink> list) {
        return String.join(SEPARATOR, list.stream().map(link -> link.getKey()).collect(Collectors.toList()));
    }
}

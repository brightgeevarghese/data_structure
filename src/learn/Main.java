package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        DirectoryEntry entry = new DirectoryEntry();
        System.out.println(entry.addOrChangeDirectoryEntry("Sanjay", "1234567890", "sanjay@mail.com"));
        System.out.println(entry.addOrChangeDirectoryEntry("Jane", "234567890", "jane@mail.com"));
        System.out.println(entry.addOrChangeDirectoryEntry("Sanjay", "6412331234", "sanjay@mail.com"));
        System.out.println(entry.getDirectoryEntries());
        System.out.println(entry.removeDirectoryEntry("sanjay@mail.com"));
        System.out.println(entry.getDirectoryEntries());

    }
}

class DirectoryEntry{
    private String name;
    private String number;
    private String email;

    public DirectoryEntry() {
    }

    private List<DirectoryEntry> directoryEntries = new ArrayList<>();

    private DirectoryEntry(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public String removeDirectoryEntry(String email){
        for (DirectoryEntry entry : directoryEntries) {
            if (entry.email.equals(email)) {
                directoryEntries.remove(entry);
                return "Directory entry for "+ email + " is removed";
            }
        }
        return "No Directory entry for "+ email;
    }

    public String addOrChangeDirectoryEntry(String name, String number, String email){
        for (DirectoryEntry entry : directoryEntries) {
            if (entry.email.equals(email)) {
                entry.name = name;
                entry.number = number;
//                entry.email = email;
                return "Directory entry for "+ email + " is updated";
            }
        }
        directoryEntries.add(new DirectoryEntry(name, number, email));
        return "Directory entry for "+ email + " is added";
    }

    @Override
    public String toString() {
        return "DirectoryEntry{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public List<DirectoryEntry> getDirectoryEntries() {
        return directoryEntries;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DirectoryEntry that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(number, that.number) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, email);
    }
}
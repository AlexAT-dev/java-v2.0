import java.util.TreeSet;

class Contact {

  private String surname;
  private TreeSet<String> phones;

  public Contact(String surname, TreeSet<String> phones) {
    this.surname = surname;
    this.phones = phones;
  }

  public String getSurname() {
    return surname;
  }

  public TreeSet<String> getPhones() {
    return phones;
  }
}

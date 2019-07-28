package lesson3;

import java.util.Objects;

public class Person {// extends Object implements Comparable
   // private String lastName;
    public String phoneNumber;
    public String email;

    Person(String  phoneNumber, String email ){
        this.email = email;
        //this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

   /* public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

   @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person per = (Person) obj;
        return this.getPhoneNumber() == per.getPhoneNumber()
                && this.getEmail() == per.getEmail();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhoneNumber());
    }
    @Override
    public int compareTo(Object o) {
        return (this == o) ? 0 :  (this.getPhoneNumber().hashCode() - ((Person) o).getPhoneNumber().hashCode());
    }*/
}

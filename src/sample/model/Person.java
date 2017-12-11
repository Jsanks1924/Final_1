
package sample.model;

import javafx.collections.ObservableList;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.time.LocalDate;

/**
 You must create a Person class with the following attributes:

 *first name
 *last name
 *SSN
 *dob
 * gender
*/

public class Person{
    //attributes
 String first,last, gender, birth;
 int ssn;

    public Person(String newFirst, String newLast, String newGender, String newBirth,int newSsn)
    {
        this.first = newFirst;
        this.last = newLast;
        this.gender = newGender;
        this.birth = newBirth;
        this.ssn = newSsn;
    }
    public Person(String first, String last) {
        this.first = null;
        this.last = null;
        gender = null;
        birth = null;
        ssn = 0;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                ", ssn=" + ssn +
                '}';
    }

}

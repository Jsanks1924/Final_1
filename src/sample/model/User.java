package sample.model;

/**You must create a user class, which is inherited from Person class with the following attributes:
 * first
 * last
 *Username
 *email
 *phone number (country code + area code + phone number)
 *password
 * confirm passcode
 *profile photo
 *
 * methods
 * login
 * exit
 * Validate Sign up
 * Validate password and confirm password field must be the same,
 * to include at least 1 number, 1 upper case letter, 1 lower case letter, 1 special character
 *Validate email field
 */


public class User extends Person {

    String user, email, password, confirm;
    int phoneNum;

    //constructor

    public User(String newFirst, String newLast, String newGender, String newBirth, String user, String email, String password, String confirm, int phoneNum) {
        super(newFirst, newLast, newGender, newBirth);
        this.user = user;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.phoneNum = phoneNum;
    }


    public User(String first, String last, String user, String email, String password, String confirm, int phoneNum) {
        super(first, last);
        this.user = user;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.phoneNum = phoneNum;

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }


    @Override
    public String toString() {
        return "User{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                ", ssn=" + ssn + '\'' +
                ", user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirm='" + confirm + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user1 = (User) o;

        if (phoneNum != user1.phoneNum) return false;
        if (user != null ? !user.equals(user1.user) : user1.user != null) return false;
        if (email != null ? !email.equals(user1.email) : user1.email != null) return false;
        if (password != null ? !password.equals(user1.password) : user1.password != null) return false;
        return confirm != null ? confirm.equals(user1.confirm) : user1.confirm == null;
    }

    public boolean validateEmail() {
        boolean format = false;
        if (email.contains("@") && email.contains("mail.com")) {
            format = true;
        }
        return format;
    }

    public boolean confirmPassword() {

        //2. consists of only letters and digits.
        //3. must contain at least two digits.
        char c;
        int count = 1;
        for (int i = 0; i < password.length() - 1; i++) {
            c = password.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            } else if (Character.isDigit(c)) {
                count++;
                if (count < 1) {
                    return false;
                }
            }
        }
        return true;
    }
}


















































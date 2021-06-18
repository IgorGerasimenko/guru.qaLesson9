package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SubmitedFormPage {

    private SelenideElement title = $("#example-modal-sizes-title-lg");
    private SelenideElement studentName = $x("//td[text()='Student Name']").parent();
    private SelenideElement studentEmail = $x("//td[text()='Student Email']").parent();
    private SelenideElement gender = $x("//td[text()='Gender']").parent();
    private SelenideElement phoneNumber = $x("//td[text()='Mobile']").parent();
    private SelenideElement dateOfBirth = $x("//td[text()='Date of Birth']").parent();
    private SelenideElement subject = $x("//td[text()='Subjects']").parent();
    private SelenideElement hobbies = $x("//td[text()='Hobbies']").parent();
    private SelenideElement studentAdress = $x("//td[text()='Address']").parent();
    private SelenideElement stateAndCity = $x("//td[text()='State and City']").parent();

    public void assertTitle() {
        title.shouldHave(text("Thanks for submitting the form"));
    }

    public void assertStudentName(String firstName, String lastName) {
        studentName.shouldHave(text(firstName + " " + lastName));
    }

    public void assertEmail(String email) {
        studentEmail.shouldHave(text(email));
    }

    public void assertGender(String gender1) {
        gender.shouldHave(text(gender1));
    }

    public void assertPhoneNumber(String phoneNbr) {
        phoneNumber.shouldHave(text(phoneNbr));
    }

    public void assertDateOfBirth(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        dateOfBirth.shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
    }

    public void assertSubject(String subject1, String subject2) {
        subject.shouldHave(text(subject1 + "," + " " + subject2));
    }

    public void assertHobby(String hobby) {
        hobbies.shouldHave(text(hobby));
    }

    public void assertAddress(String address) {
        studentAdress.shouldHave(text(address));
    }

    public void assertStateAndCity(String state, String sity) {
        stateAndCity.shouldHave(text(state + " " + sity));
    }

}

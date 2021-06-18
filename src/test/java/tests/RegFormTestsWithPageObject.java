package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.CalendarForm;
import pages.RegFormPage;
import pages.SubmitedFormPage;

public class RegFormTestsWithPageObject extends TestBase {

    RegFormPage regFormPage = new RegFormPage();
    CalendarForm calandarForm = new CalendarForm();
    SubmitedFormPage submitedFormPage = new SubmitedFormPage();

    String firstName = "Igor";
    String lastName = "Gerasimenko";
    String email = "1@1.ru";
    String phoneNumber = "9271234567";
    String adress = "ulitsa Pushkina, dom Kolotushkina";
    String state = "Haryana";
    String sity = "Karnal";
    String gender = "Other";
    String subject1 = "english";
    String subject2 = "math";
    String hobby = "Music";

    String dayOfBirth = "24".toString();
    String monthOfBirth = "June".toString();
    String yearOfBirth = "2010".toString();


    @Test
    void succesfullSubmitFormTest() {
        regFormPage.open();

        regFormPage.fillFirstName(firstName);
        regFormPage.fillLastName(lastName);
        regFormPage.fillEmail(email);
        regFormPage.clickGenderOther();
        regFormPage.fillPhoneNumber(phoneNumber);

        calandarForm.setDate(dayOfBirth, monthOfBirth, yearOfBirth);

        regFormPage.fillSubject("english");
        regFormPage.fillSubject("math");
        regFormPage.checkMusicHobby();
        regFormPage.fillAddress(adress);
        regFormPage.fillStateList(state);
        regFormPage.fillSityList(sity);
        regFormPage.clickSubmitButton();

        submitedFormPage.assertTitle();
        submitedFormPage.assertStudentName(firstName, lastName);
        submitedFormPage.assertEmail(email);
        submitedFormPage.assertGender(gender);
        submitedFormPage.assertPhoneNumber(phoneNumber);
        submitedFormPage.assertDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        submitedFormPage.assertSubject(subject1, subject2);
        submitedFormPage.assertHobby(hobby);
        submitedFormPage.assertAddress(adress);
        submitedFormPage.assertStateAndCity(state, sity);

    }


}



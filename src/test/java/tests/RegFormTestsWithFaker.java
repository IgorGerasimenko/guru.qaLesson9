package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.CalendarForm;
import pages.RegFormPage;
import pages.SubmitedFormPage;

public class   RegFormTestsWithFaker extends TestBase {

    RegFormPage regFormPage = new RegFormPage();
    CalendarForm calendarForm = new CalendarForm();
    SubmitedFormPage submitedFormPage = new SubmitedFormPage(); // вынести в компоненты
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String adress = faker.address().fullAddress();
    String state = "Haryana";
    String sity = "Karnal";
    String gender = "Other";
    String subject1 = "english";
    String subject2 = "math";
    String hobby = "Music";

    String dayOfBirth = "24".toString(); // ту стринг не надо
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

        calendarForm.setDate(dayOfBirth, monthOfBirth, yearOfBirth);

        regFormPage.fillSubject(subject1);
        regFormPage.fillSubject(subject2);
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



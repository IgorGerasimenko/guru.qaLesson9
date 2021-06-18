package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegFormPage {

    public SelenideElement firstNameInput = $("#firstName");
    public SelenideElement lastNameInput = $("#lastName");
    public SelenideElement emailInput = $("#userEmail");
    public SelenideElement subjectInput = $("#subjectsInput");
    public SelenideElement addressInput = $("#currentAddress");
    public SelenideElement phoneNumberInput = $("#userNumber");

    public SelenideElement radioButtonGenderOther = $("[for='gender-radio-3']");
    public SelenideElement hobbiesCheckBoxMusic = $("[for='hobbies-checkbox-3']");

    public SelenideElement selectStateList = $("#react-select-3-input");
    public SelenideElement selectCityList = $("#react-select-4-input");

    public SelenideElement submitButton = $("#submit");


    public void open() {
        Selenide.open("https://demoqa.com/automation-practice-form");
    }

    public void fillFirstName(String value) {
        firstNameInput.val(value);
    }

    public void fillLastName(String value) {
        lastNameInput.val(value);
    }

    public void fillEmail(String value) {
        emailInput.val(value);
    }

    public void fillPhoneNumber(String value) {
        phoneNumberInput.val(value);
    }

    public void fillSubject(String value) {
        subjectInput.val(value).pressEnter();
    }

    public void fillAddress(String value) {
        addressInput.val(value);
    }

    public void clickGenderOther() {
        radioButtonGenderOther.click();
    }

    public void checkMusicHobby() {
        hobbiesCheckBoxMusic.click();
    }

    public void fillStateList(String value) {
        selectStateList.setValue(value).pressEnter();
    }

    public void fillSityList(String value) {
        selectCityList.setValue(value).pressEnter();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}

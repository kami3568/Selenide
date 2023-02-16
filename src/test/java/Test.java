package ru.netology.ru;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {


  private String generateDate (int addDays, String pattern) {
      return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
  }


        @Test
                 void shouldBeSuccessfulForm() {
            open("http://localhost:9999");

            $("[data-test-id=city] input").setValue("Санк-Петербург");
            $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
            String currentDate = generateDate(3, "dd.mm.yyyy");
            $("[data-test-id=date] input").sendKeys(currentDate);
            $("[data-test-id=name] input").setValue("Петров Петр Петрович";
            $("[data-test-id=phone] input").setValue("+79211234567");
            $("[data-test-id=agreement]").click();
            $(byText("Успешно!")).shouldBe(Condition.visible, Duration.ofSeconds(15));
            $("[data-test-id='success-notification'] .notification__content")
                    .shouldHave(Condition.exactText("Встреча успешно запланирована на " + currentDate));


        }



}
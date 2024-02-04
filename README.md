# OrangeHRM
Web Automation <br>

<b> Situs uji : </b> https://opensource-demo.orangehrmlive.com/web/index.php/auth/login <br>

<b>Note :</b> <u>Branch Information</u>
<li><b>master : </b>inisialisasi project</li>
<li><b>SelJav : </b>Selenium Java</li>
<li><b>Bdd-Tdd : </b>Cucumber Java (BDD & TDD)</li>
<li><b>GeRaTa : </b>Generate Random Data &rarr; Automate Registration Form</li>
<li><b>POM : </b>Page Object Modelling</li>

### Problems & Solutions
___
#### 1. Resolving java: cannot access org.openqa.selenium.WebDriver
- `Issue details` : class file has wrong version 55.0, should be 52.0
- `Solution` : Di file *pom.xml* &rarr; *dependencies* &rarr; *dependency selenium-java* &rarr; **Downgrade the Version**

#### 2. Resolving //*[contains(text(), 'string')] not working in XPath
- `Solution` : //button[text()[contains(., 'Login')]]
- `References` : [Ref 1](https://stackoverflow.com/questions/71253563/why-is-containstext-string-not-working-in-xpath) dan [Ref 2](https://stackoverflow.com/questions/3655549/xpath-containstext-some-string-doesnt-work-when-used-with-node-with-more/71255563#71255563)

#### 3. Resolving wait.until(ExpectedConditions.visibilityOf Element1 OR Element2)
- `Solution` : wait.until(
  ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.xpath("blabla1")),
  ExpectedConditions.visibilityOfElementLocated(By.xpath("blabla2")))
  );
- `References` : [Klik di sini](https://stackoverflow.com/questions/14840884/wait-untilexpectedconditions-visibilityof-element1-or-element2)

#### 4. Resolving Inspect disappearing elements
- `Issue details` : dropdown element missing when inspect click
- `Solution` : on page &rarr; inspect &rarr; **Ctrl + Shift + P** &rarr; **focus** &rarr; **Rendering : Emulate a focused page** &rarr; done
- `References` : [Klik di sini](https://www.youtube.com/watch?v=m7wAPcHzD0E)

#### 5. Resolving Inspect TOAST message
- `Solution` : on page &rarr; inspect &rarr; **Sources** &rarr; **Pause** &rarr; done
-  `References` : [Klik di sini](https://youtu.be/lDAM30L1Mkw?si=rj6LROeWHUQej9dO)

#### 6. Resolving cannot ".clear()" / delete data in input form
- `Solution` : using the libraries **import org.openqa.selenium.Keys;** and **import org.openqa.selenium.interactions.Actions;** then design the action you want to perform
-  `References` : [Klik di sini](https://youtu.be/g3GHW5dNZq4?si=ssoaqZE_q15PMIpm)

#### 7. Resolving conditions if/else with web-elements
- `Solution` :  **driver.findElement(By.xpath("blabla")).isDisplayed()** or **driver.findElement(By.xpath("blabla")).getText().contains("blabla11")**
- `References` : [Klik di sini](https://youtu.be/qpIyq4QGOyg?si=I8ECN1zjLka5Azc8)

#### 8. Resolving Uploading Files
- `Solution` : Previously, for wait.until( ExpectedConditions.visibilityOfElementLocated(**do not use input file type tag element located from the form**) );,
               input file type tag element located from the form, and find the path of the file to upload, then use the sendkeys
- `References` : [Klik di sini](https://youtu.be/3jS-GAHZsR0?si=G8DNNcGQZ2ZsKyrm)
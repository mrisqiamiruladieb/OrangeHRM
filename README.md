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
- `References` : [Ref 1](https://stackoverflow.com/questions/71253563/why-is-containstext-string-not-working-in-xpath) 
dan [Ref 2](https://stackoverflow.com/questions/3655549/xpath-containstext-some-string-doesnt-work-when-used-with-node-with-more/71255563#71255563)

#### 3. Resolving wait.until(ExpectedConditions.visibilityOf Element1 OR Element2)
- `Solution` : wait.until(
  ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.xpath("blabla1")),
  ExpectedConditions.visibilityOfElementLocated(By.xpath("blabla2")))
  );
- `References` : [Klik di sini](https://stackoverflow.com/questions/14840884/wait-untilexpectedconditions-visibilityof-element1-or-element2)
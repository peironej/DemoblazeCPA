package dmb;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Steps {
    private WebDriver FirefoxDriver;


    @Dado("Que defino mi (.*) y (.*)")
    @Cuando("^Que abro la pagina de Demoblaze$")
    public void abrirWeb () {
        //Encontrar el archivo ejecutable de GeckoDriver
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        //Creamos opciones sobre nuestro navegador
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette",  false);
        //Creamos nueva instancia del navegador FirefoxDriver
        FirefoxDriver = new FirefoxDriver(options);
        //Definimos tiempo de espera hasta que aceptemos un timeout
        FirefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Abrimos una URL
        FirefoxDriver.get("https://www.demoblaze.com/index.html");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Cuando("^Ingresamos con (.*) y (.*)$")
    public void singIn(String User, String Password) {
        FirefoxDriver.findElement(By.xpath("//a[@id='login2']")).sendKeys(Keys.ENTER);
        FirefoxDriver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys(User);
        FirefoxDriver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys(Password);
        FirefoxDriver.findElement(By.xpath("//button[contains(text(),'Log in')]")).sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Cuando("^Me registro con (.*) y (.*)$")
    public void singUp(String User, String Password) {
        FirefoxDriver.findElement(By.xpath("//a[@id='signin2']")).sendKeys(Keys.ENTER);
        FirefoxDriver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys(User);
        FirefoxDriver.findElement(By.xpath("//input[@id='sign-password']")).sendKeys(Password);
        FirefoxDriver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Y("^Seleccionamos Sony Vaio I5$")
    public void agregarProducto(){
        FirefoxDriver.findElement(By.xpath("//a[contains(text(),'Sony vaio i5')]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Entonces("^El Alertbox devuelve (.*)$")
    public void aceptarAlertBox(String alertbox){
        FirefoxDriver.switchTo().alert();
        Alert alert = FirefoxDriver.switchTo().alert();
        String Result = alert.getText();
        System.out.println("El resultado fue: "+Result);
        assert Result.equals(alertbox);
        alert.accept();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FirefoxDriver.close();
    }
    @Y("^Agregamos Sony Vaio I5 al carrito$")
    public void addToCart(){
        FirefoxDriver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
        FirefoxDriver.switchTo().alert();
        Alert alert = FirefoxDriver.switchTo().alert();
        String Result = alert.getText();
        System.out.println("El resultado fue: "+Result);
        assert Result.equals("Product added.");
        alert.accept();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Y("^Ingresamos al carrito$")
            public void inToCart(){
        FirefoxDriver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Entonces("^Deberia mostrar el precio total correcto correspondiente al de Sony Vaio i5: (.*)$")
    public void validateCart(String totalPrice) {
        Assert.assertTrue(FirefoxDriver.findElement(By.id("totalp")).getText().contains(totalPrice));
        System.out.println("Test laptopAlCarrito Passed. Se procede a cerrar el explorador");
        FirefoxDriver.close();
    }

    @Entonces("^Se realiza correctamente el Logout$")
    public void logOut() {
        FirefoxDriver.findElement(By.id("logout2")).click();
        System.out.println("Se cerro sesion correctamente.");
        System.out.println("Test logInLogOut Passed. Se procede a cerrar el explorador");
        FirefoxDriver.close();
    }
}

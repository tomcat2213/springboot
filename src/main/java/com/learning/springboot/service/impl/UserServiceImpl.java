package com.learning.springboot.service.impl;

import com.learning.springboot.appium.MainDispch;
import com.learning.springboot.bean.UserBean;
import com.learning.springboot.mapper.UserMapper;
import com.learning.springboot.service.UserService;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public static AppiumDriver apDriver;

    private WebDriverWait wait;
    @Override
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }

    @Override
    public void testLink() {
        DesiredCapabilities caps = new DesiredCapabilities();//
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "xxx");
        caps.setCapability("uid", "127.0.0.1:7555");
        caps.setCapability("appPackage", "com.tencent.wework");
        caps.setCapability("noReset", "true");
        caps.setCapability("appActivity", ".launch.WwMainActivity");
        try {
            apDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);//?
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        apDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        wait = new WebDriverWait(apDriver, 30, 1);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.settings:id/title")));//?
        // 通讯录
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();
        /*// 添加成员
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[6]/android.widget.RelativeLayout")).click();
        // 手动添加
        apDriver.findElement(By.id("cox")).click();//
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.EditText"))
                .sendKeys("王磊9");
        apDriver.findElement(By.id("fow")).sendKeys("13212780856");
        apDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.EditText"))
                .sendKeys("445282673@qq.com");
        apDriver.findElement(By.id("iy")).click();
        apDriver.findElement(By.id("iz")).sendKeys("11abc");
        apDriver.findElement(By.id("i6k")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        apDriver.findElement(By.id("i6k")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        apDriver.findElement(By.id("i63")).click();*/
    }
}

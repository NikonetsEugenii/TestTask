package UI.testNG;

import UI.holders.Holder;
import UI.holders.Init;
import UI.objects.ExceptionTask;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main extends Init {

    //first
    public static void main(String[] args) {
        ExceptionTask exceptionTask = new ExceptionTask().catchException();
    }
    //third
    @Test
    public void tabsTask(){
        Holder holder = new Holder(driver);
        holder.goToMainPage();
        holder.openInNewTab(holder.getSecondUrl());
        holder.changeTab(0);
//        ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(list.get(0));

    }
}

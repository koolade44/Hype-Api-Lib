package com.koolade446.hypeapi;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URI;

public class Help {
    public static void main(String[] args) throws Exception {
        Desktop dt = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (dt != null && dt.isSupported(Desktop.Action.BROWSE)) {
            dt.browse(new URI("https://koolade44.github.io/Hype-Api-Lib/"));
        }
        
        //TODO: eventually have jframe window for help here
        else {
            File f = new File("help.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            BufferedWriter br = new BufferedWriter(new FileWriter(f));
            String s = "For help go to https://koolade44.github.io/Hype-Api-Lib/";
            br.write(s);
            br.close();
        }
    }
}

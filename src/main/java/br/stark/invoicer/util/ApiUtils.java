/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer.util;

import com.starkbank.Project;
import com.starkbank.Settings;

/**
 *
 * @author lucas
 */
public class ApiUtils {

    public static void setProject() throws Exception {
        String privateKeyContent = "-----BEGIN EC PRIVATE KEY-----\n"
                + "MHQCAQEEIBCUgqBo7v84iMpoyciqqe8pabsv5vh7VjBaXYM5XbEroAcGBSuBBAAK\n"
                + "oUQDQgAElvMZeKIdKxTeNQ398gmBj9/Txii7Sf71irgxW2UHzsgedgTbm6LcLAju\n"
                + "hB5AVxt9A/yZWsnSi+nz4J3NaXV0Dw==\n"
                + "-----END EC PRIVATE KEY-----";

        Project project = new Project("sandbox", "4750343523008512", privateKeyContent);

        Settings.user = project;
    }
}

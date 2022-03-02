/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.stark.invoicer;

import br.stark.invoicer.SchedulerTest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.internal.TextListener;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

/**
 *
 * @author lucas
 */
public class TestRunner extends Runner {

    private SchedulerTest test;

    public TestRunner(SchedulerTest test) {
        super();
        this.test = test;
    }

    @Override
    public Description getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void run(RunNotifier arg0) {
        try {
            JUnitCore junit = new JUnitCore();
            junit.addListener(new TextListener(System.out));
            junit.run(SchedulerTest.class);
        } catch (Exception ex) {
            Logger.getLogger(TestRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

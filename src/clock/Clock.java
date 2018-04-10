/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Dominik
 */
public class Clock extends JFrame{

    public Clock(){

        super("Clock");
        this.setBounds(300, 300, 300, 300);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        initComponents();

    }

    public void initComponents(){
        panel.add(timelabel);
        panel.add(currentTime);
        this.getContentPane().add(panel);

        ActionListener clockListener = new ClockListener();
        Timer timer = new Timer(1000,clockListener);
        timer.start();
        this.pack();

    }
    JLabel timelabel = new JLabel("Time");
    JLabel currentTime = new JLabel(CurrentTime());
    JPanel panel = new JPanel();


    private class ClockListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            currentTime.setText(CurrentTime());
        }
    }
    public String CurrentTime(){
        GregorianCalendar calendar = new GregorianCalendar();
        String h = "" + calendar.get(Calendar.HOUR_OF_DAY);
        String min = "" + calendar.get(Calendar.MINUTE);
        String sec = "" + calendar.get(Calendar.SECOND);
        
        if(Integer.parseInt(h) < 10)
            h = "0" + h;
        if(Integer.parseInt(min) < 10)
            min = "0" + min;
        if(Integer.parseInt(sec) < 10)
            sec = "0" + sec;
        
        
        return h + " : " + min + " : " + sec;
    }

    public static void main(String[] args) {
        new Clock();
    }

}

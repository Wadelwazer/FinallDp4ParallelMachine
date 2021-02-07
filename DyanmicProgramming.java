/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyanmicprogramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Admin
 */
public class DyanmicProgramming {

    public static String getpath() {
        String filename = "";
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            filename = chooser.getSelectedFile().getAbsolutePath();
        }
        return filename;
    }

    static void getjob(int numfiles, int prange, int qrange, int size) {
        JobsGenerate Newjobs = new JobsGenerate(size, prange, qrange, numfiles);
        try {
            Newjobs.GenJobs();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        getjob(1, 1000, 500, 1000);
        File file = new File(getpath());
        ReadingFromFile read = new ReadingFromFile(file);
        read.readToArray();

    }

}

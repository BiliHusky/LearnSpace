package com.yjw.utlearn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yjw on 19-2-25.
 */
public class FsT {
    private FileSystem fs;
    private LocalFileSystem lfs;
    public FsT() {
        System.out.println("OMG");
    }
    public FsT(Configuration conf) {
        try {
            fs = FileSystem.get(conf);
            lfs = FileSystem.getLocal(conf);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void down() throws IOException {
        System.out.println("fs");
//        BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(new Path("/"))));
//        System.out.println(br.readLine());
//        br.close();
    }

}

package leetcode;

import java.io.*;
import java.util.Arrays;

public class ReadNCharactersGivenRead4 extends Reader4{

    public static void main(String[] args) throws FileNotFoundException {
        StringReader reader = new StringReader("abcde");
        char[] buffer = new char[4];
        int ret = new ReadNCharactersGivenRead4(reader).read(buffer,2);
        System.out.println(ret);
        System.out.println(Arrays.toString(buffer));
    }

    public ReadNCharactersGivenRead4(StringReader reader) throws FileNotFoundException {
        super(reader);
    }

    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int ret = 0;
        int writePos = 0;
        while((ret = read4(buffer)) > 0){
            for (int i = 0; i < ret; i++) {
                buf[writePos++] = buffer[i];
                if(writePos == n){
                    return n;
                }
            }
        }
        return writePos;
    }

}
class Reader4 {
    StringReader reader;

    public Reader4(StringReader reader) throws FileNotFoundException {
        this.reader = reader;
    }

    public int read4(char[] buf4) {
        try {
            return reader.read(buf4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

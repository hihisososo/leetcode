package leetcode.year_2022.february;

import java.util.HashMap;

public class LoggerRateLimiter {

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();
        System.out.println(logger.shouldPrintMessage(1, "foo"));  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        System.out.println(logger.shouldPrintMessage(2, "bar"));  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        System.out.println(logger.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
        System.out.println(logger.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
    }

    HashMap<String, Integer> logTimeMap;
    public LoggerRateLimiter() {
        logTimeMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(logTimeMap.containsKey(message)){
            if(timestamp - logTimeMap.get(message) >= 10){
                logTimeMap.put(message, timestamp);
                return true;
            }else{
                return false;
            }
        }else{
            logTimeMap.put(message, timestamp);
            return true;
        }
    }
}

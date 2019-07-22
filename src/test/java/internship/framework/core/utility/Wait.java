package internship.framework.core.utility;

import org.apache.commons.lang.time.StopWatch;
import java.util.concurrent.Callable;

public class Wait {

    public static <T> T  until(Callable<T> function){
        return until(10,100,function);
    }

    public static <T> T  until(int timeoutInSeconds, Callable<T> function){
        return until(timeoutInSeconds,100,function);
    }

    public static <T> T  until(int timeout, int pollMiliSeconds, Callable<T> function){
        T result = null;
        StopWatch watch = new StopWatch();
        watch.start();
        do{
            try{
                result = function.call();
                if (result instanceof Boolean && ((Boolean) result).booleanValue() == true){
                    return result;
                }
                if (!(result instanceof Boolean) && result != null){

                    return result;
                }
            }catch(Exception e){

            }
            try {
                Thread.sleep(pollMiliSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(watch.getTime() <= timeout * 1000);
        return result;
    }
}
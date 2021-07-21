package doownload;


import java.util.concurrent.*;
 
public class Constans {
//    public static final int MAX_THREAD_COUNT = getSystemProcessCount();
    public static final int MAX_THREAD_COUNT = 5;
    private static final int MAX_IMUMPOOLSIZE = MAX_THREAD_COUNT;
 
    /**
     * �Զ����̳߳�
     */
    private static ExecutorService MY_THREAD_POOL;
    /**
     * �Զ����̳߳�
     */
    public static ExecutorService getMyThreadPool(){
        if(MY_THREAD_POOL == null){
            MY_THREAD_POOL = Executors.newFixedThreadPool(MAX_IMUMPOOLSIZE);
        }
        return MY_THREAD_POOL;
    }
 
    // �̳߳�
    private static ThreadPoolExecutor threadPool;
 
    /**
     * ������������ �̳߳�
     * @return
     */
    public static ThreadPoolExecutor getThreadPool(){
        if(threadPool == null){
            threadPool = new ThreadPoolExecutor(MAX_IMUMPOOLSIZE, MAX_IMUMPOOLSIZE, 3, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<Runnable>(16),
                    new ThreadPoolExecutor.CallerRunsPolicy()
            );
        }
        return threadPool;
    }
 
    /**
     * ��ȡ������cpu����
     * @return
     */
    private static int getSystemProcessCount(){
        int count = Runtime.getRuntime().availableProcessors();
        return count;
    }
 
}

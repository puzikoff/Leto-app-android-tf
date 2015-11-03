package ru.letoapp.utilities;

/**
 * This class is designed to keep track of retry mechanism for default base methods we have like
 * clickById, getText, fillText field. This class give's us a possibility to be aware of how many retries
 * did we do in this default methods in case if element was not found.
 * We have frequent problems with StaleElementException and this class will help us to fight with this problem
 */
public class RetryStrategy {
    public static final int DEFAULT_RETRIES = 3;
    public static final long DEFAULT_WAIT_TIME_IN_MILLI = 1000;

    private int numberOfRetries;
    private int numberOfTriesLeft;
    private long timeToWait;

    public RetryStrategy() {
        this(DEFAULT_RETRIES, DEFAULT_WAIT_TIME_IN_MILLI);
    }

    public RetryStrategy(int numberOfRetries, long timeToWait) {
        this.numberOfRetries = numberOfRetries;
        numberOfTriesLeft = numberOfRetries;
        this.timeToWait = timeToWait;
    }

    /**
     * @return true if there are tries left
     */
    public boolean shouldRetry() {
        return numberOfTriesLeft > 0;
    }

    public void errorOccured() throws Exception {
        numberOfTriesLeft--;
        if (!shouldRetry()) {
            throw new Exception("Retry Failed: Total " + numberOfRetries
                    + " attempts made at interval " + getTimeToWait()
                    + "ms");
        }
        waitUntilNextTry();
    }

    public void errorOccured(Throwable throwable) throws Exception {
        numberOfTriesLeft--;
        if (!shouldRetry()) {
            throw new Exception("Retry Failed: Total " + numberOfRetries
                    + " attempts made at interval " + getTimeToWait()
                    + "ms.\n"
                    + "Error message is : "+throwable.getMessage()
                    + "\n"
                    +"Caused by : "+throwable.getCause());
        }
        waitUntilNextTry();
    }

    public long getTimeToWait() {
        return timeToWait;
    }

    private void waitUntilNextTry() {
        try {
            Thread.sleep(getTimeToWait());
        } catch (InterruptedException ignored) {
        }
    }
}
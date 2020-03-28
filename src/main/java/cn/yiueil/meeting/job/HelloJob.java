package cn.yiueil.meeting.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * message
 * __   __ ____            _  __
 * \ \ / /|_ _| __ __ ___ (_)| |
 * \ V /  | | | || |/ -_)| || |
 * |_|  |___| \_,_|\___||_||_|
 * create by YIueil on time 2020/3/27
 */
public class HelloJob implements Job {
    public HelloJob() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException
    {
        System.err.println("Hello!  HelloJob is executing.");
    }
}

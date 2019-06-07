package com.twsihan.examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Application
{
    private static Logger logger = LogManager.getLogger(Application.class);


    public static void main(String[] args)
    {
        try {
            Application app = new Application();

            app.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() throws Exception
    {
        logger.info("------- Initializing ----------------------");

        // First we must get a reference to a scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        logger.info("------- Initialization Complete -----------");
        logger.info("------- Scheduling Job  -------------------");

        // Start up the scheduler (nothing can actually run until the
        // scheduler has been started)
        scheduler.start();

        logger.info("------- Started Scheduler -----------------");

        // wait long enough so that the scheduler as an opportunity to
        // run the job!
        logger.info("------- Waiting 65 seconds... -------------");
        try {
            // wait 65 seconds to show job
            Thread.sleep(65L * 1000L);
            // executing...
        } catch (Exception e) {
            //
        }

        // shut down the scheduler
        logger.info("------- Shutting Down ---------------------");
        scheduler.shutdown(true);
        logger.info("------- Shutdown Complete -----------------");
    }
}

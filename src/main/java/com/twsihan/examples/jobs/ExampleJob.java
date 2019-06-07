package com.twsihan.examples.jobs;

import com.twsihan.examples.mappers.ExampleMapper;
import com.twsihan.examples.components.mybatis.session.MapperFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;

import java.util.Date;

public class ExampleJob implements Job
{
    private static Logger logger = LogManager.getLogger(ExampleJob.class);

    private static final String COUNT = "count";


    public void execute(JobExecutionContext context)
    {
        ExampleMapper exampleMapper = MapperFactory.BASE.getMapper(ExampleMapper.class);

        JobKey jobKey = context.getJobDetail().getKey();
        JobDataMap data = context.getJobDetail().getJobDataMap();
        int count;
        if (data.containsKey(COUNT)) {
            count = data.getInt(COUNT);
        } else {
            count = 0;
        }
        count++;
        data.put(COUNT, count);

        logger.info("ExampleJob: " + jobKey + " done at " + new Date() + " Execution #" + exampleMapper.getCount());
    }
}

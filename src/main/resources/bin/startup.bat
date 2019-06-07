@echo off

rem Set Quartz to the base directory of the Quartz Distribution
@SET WD=%~d0%~p0
@SET BASE_DIR=%WD%..

rem a configuration file for log4j logging
@SET LOG4J_ENV="-Dlog4j.configuration=file:%WD%log4j2.xml"

rem Set the location and name of the quartz.properties file
@SET QUARTZ_ENV="-Dorg.quartz.properties=%WD%quartz.properties"

@ren "java" %LOG4J_ENV% %QUARTZ_ENV% Application
"java" -jar $BASE_DIR/twsihan-quartz-mybatis-examples.jar

# Internship Project
Put your drivers and your selenium grid jar in the same folder.
If you have mac use commands to start selenium grid with chrome or firefox:
java -Dwebdriver.chrome.driver="chromedriver" -jar selenium-server-standalone-3.141.0.jar
java -Dwebdriver.firefox.profile="geckodriver" -jar selenium-server-standalone-3.141.0.jar
By default will be used port 4444. Make sure to specify a different port if you want to used a different one
Next you will have to update the config.properties files with your grid ip

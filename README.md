# socialtech-demo

Pre-requisites:
1. Java8
2. Maven
3. git clone https://github.com/maxski/socialtech-demo.git

* Basic run: mvn clean test -Dbrowser=chrome

Additional params:
 1. Proxy could be defined: -Dproxy="http://proxyUrl:proxyPort"
 2. Tested on Chrome 74. To use higher or lower Chrome version, please, download appropriate driver http://chromedriver.chromium.org/downloads and point access to it via: -Ddriver.path.value="path to Chromedriver"

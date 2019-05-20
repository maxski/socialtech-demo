# socialtech-demo

Pre-requisites:
* Java8
* maven
* git clone https://github.com/maxski/socialtech-demo.git

Basic run: mvn clean test -Dbrowser=chrome

Additional params:
 * proxy could be defined: -Dproxy="http://proxyUrl:proxyPort"
 * tested on Chrome 74. To use higher or lower Chrome version, please, download appropriate driver http://chromedriver.chromium.org/downloads and point access to it via: -Ddriver.path.value="path to Chromedriver"

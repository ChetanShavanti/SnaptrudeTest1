const { setHeadlessWhen } = require('@codeceptjs/configure');

// turn on headless mode when running with HEADLESS=true environment variable
// export HEADLESS=true && npx codeceptjs run
setHeadlessWhen(process.env.HEADLESS);

exports.config = {
  tests: './*_test.js',
  output: './Snaptrude',
  helpers: {
    Puppeteer: {
     
     url: 'https://app.snaptrude.com/',
      show: true,
      keepBrowserState: true,
      waitForNavigation: 'networkidle0',
      restart: false,
      windowSize: '1200x900',
      getPageTimeout: 0,
      chrome:{
        args: ["--no-sandbox"]
      }
    }
  },
  include: {
    I: './steps_file.js'
  },
  bootstrap: null,
  mocha: {
    reporterOptions:{
      mochafile: "Snaptrude/result.xml",
      reportDir:"Snaptrude"
    }
  },

  name: 'snaptrude',
  plugins: {
    allure: {
      enabled: true,
      require: '@codeceptjs/allure-legacy',
    },
    pauseOnFail: {},
    retryFailedStep: {
      enabled: true
    },
   tryTo: {
    enabled: true
   },
    screenshotOnFail: {
      enabled: true
    },
    stepByStepReport: {
      enabled:true

    },
 
  }
}
